package de.fuberlin.winfo.project.visualization.web.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import de.fuberlin.winfo.project.FormatConv;
import de.fuberlin.winfo.project.XMIIO;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.Solution;

public class Stats {
	private Solution[] solutions;

	public Stats(File[] listFiles, Solution... arr) {
		this.solutions = arr;
		System.out.println("routes");
		generateRouteGraph(listFiles, arr, new int[] { 0, 7, 10, 15, 20, 25, 30, 45, 50 }, r -> r.getWay().size() - 1,
				"mi");
		System.out.println("consumption model");
		generateRouteGraph(listFiles, arr, new int[] { 0, 10, 16, 20, 24, 26, 30, 34 },
				r -> Math.round(r.getTotalVehicleBatteryConsumption() / 1000f), "mi2");

		System.out.println();
		System.out.println();

		avg("tour duration $[h]$", r -> r.getWay().get(r.getWay().size() - 1).getDuration().getEndInSec()
				- r.getWay().get(0).getDuration().getStartInSec(), i -> i / 3600d);
		avg("tour distance $[km]$", r -> (int) r.getTotalDistanceInM(), i -> i / 1000d / 1000d);
		avg("tour energy $C_s$ $[kwh]$", r -> (int) r.getTotalVehicleBatteryConsumption(), i -> i / 1000d);
		avg("number of timewindows $[\\%]$",
				r -> (int) (r.getWay().stream().filter(v -> v.getArc().getEnd() instanceof Order)
						.map(o -> (Order) o.getArc().getEnd())
						.filter(o -> o.getTimeWindow().getEndInSec() - o.getTimeWindow().getStartInSec() < 86400)
						.count() * 100 / (r.getWay().size() - 2)),
				i -> i);
		avg("tour orders", r -> r.getWay().size() - 1, i -> i);
		avg("tour locations", r -> (int) r.getWay().stream().filter(rr -> (rr.getArc().getEnd() instanceof Order))
				.map(a -> ((Order) a.getArc().getEnd()).getReceiver()).distinct().count(), i -> i);

		for (int i = 0; i < arr.length; i++) {
			int sum = multipleVehicleUsage(arr[i]);
			System.out.println("multiple vehicle usage at " + listFiles[i].getName() + ":\t" + sum);
		}
	}

	private int multipleVehicleUsage(Solution solution) {
		Route route = solution.getRoutes().stream()
				.min((a, b) -> Integer.compare(a.getWay().get(a.getWay().size() - 1).getDuration().getEndInSec(),
						b.getWay().get(b.getWay().size() - 1).getDuration().getEndInSec()))
				.get();
		return (int) solution.getRoutes().stream().filter(r -> r.getWay().get(0).getDuration().getStartInSec() > route
				.getWay().get(route.getWay().size() - 1).getDuration().getEndInSec()).count();
	}

	private void generateRouteGraph(File[] listFiles, Solution[] arr, int[] quantile, R rr, String fN) {
		List<List<String>> l = new ArrayList<List<String>>();
		l.add(Arrays.asList("nr,"
				.concat(Arrays.stream(listFiles).map(f -> f.getName()).collect(Collectors.joining(","))).split(",")));

		for (int t = 0; t + 1 < quantile.length; t++) {
			ArrayList<String> arrayList = new ArrayList<String>();
			arrayList.add(quantile[t] + "--" + (quantile[t + 1] - 1));
			l.add(arrayList);
		}
		ArrayList<String> al = new ArrayList<String>();
		al.add(quantile[quantile.length - 1] + "+");
		l.add(al);

		for (int i = 0; i < arr.length; i++) {
			Map<Integer, List<Route>> map = arr[i].getRoutes().stream().collect(Collectors.groupingBy(r -> {
				for (int s = 0; s + 1 < quantile.length; s++) {
					if (rr.onRoute(r) < quantile[s + 1]) {
						return quantile[s];
					}
				}
				return quantile[quantile.length - 1];
			}));

			Arrays.stream(quantile).filter(ii -> !map.containsKey(ii))
					.forEach(ii -> map.put(ii, new ArrayList<Route>()));

			ArrayList<Integer> list = new ArrayList<Integer>(map.keySet());
			Collections.sort(list);

			for (int k = 0; k < list.size(); k++) {
				Integer integer = list.get(k);
				List<String> arrayList = l.get(k + 1);
				String string = map.get(integer).size() + "";
				arrayList.add(string);
			}
		}

		l.forEach(k -> System.out.println(k.stream().collect(Collectors.joining(" "))));
		File file = new File(
				"F:\\Dropbox\\FU\\Module\\Masterarbeit\\ShareLaTeX\\Master Thesis - Sven\\thesis\\img\\" + fN + ".csv");
		try {
			FileOutputStream stream = new FileOutputStream(file);
			l.forEach(k -> {
				try {
					stream.write(k.stream().collect(Collectors.joining(" ")).concat("\r").getBytes());
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String collect = l.stream().filter(e -> !e.get(0).equals("nr")).map(e -> e.get(0))
				.collect(Collectors.joining(",")).replace("[", "").replace("]", "");
		String s = "symbolic x coords={" + collect + "},";
		System.out.println(s);
	}

	private List<List<String>> getCustomerPerRoute(Solution[] arr) {
		List<List<String>> l = new ArrayList<List<String>>();
		ArrayList<String> header = new ArrayList<String>();
		l.add(header);
		header.add("nr");
		IntStream.range(0, arr.length).forEach(a -> header.add(a + "sol"));
		int maxRoutes = Collections
				.max(Arrays.asList(arr), (a, b) -> Integer.compare(a.getRoutes().size(), b.getRoutes().size()))
				.getRoutes().size();
		for (int m = 0; m < arr.length; m++) {
			Solution s = arr[m];
			for (int i = 0; i < maxRoutes; i++) {
				if (l.size() <= i) {
					ArrayList<String> arrayList = new ArrayList<String>();
					arrayList.add(l.size() + "");
					l.add(arrayList);
				}
				List<String> list = l.get(i);
				int j = s.getRoutes().size() - 1 >= i ? s.getRoutes().get(i).getWay().size() - 1 : 0;
				list.add("" + j);
			}
		}
		return l;
	}

	private void special(Solution... arr) {
		for (Route r : arr[1].getRoutes()) {
			int start = r.getWay().get(0).getDuration().getStartInSec();
			int end = r.getWay().get(r.getWay().size() - 1).getDuration().getEndInSec();
			double i = (end - start) / 3600d;
			if (i > 7d) {
				System.out.println(i);
			}
		}
	}

	interface R {
		int onRoute(Route r);
	}

	interface E {
		double onValue(double i);
	}

	private void avg(String s, R r, E a) {

		for (int k = 0; k < solutions.length; k++) {
			Solution solution = solutions[k];
			List<Double> l = new ArrayList<Double>();
			l.add(-1d);
			l.add(0d);
			l.add(-1d);
			for (Route route : solution.getRoutes()) {
				int i = r.onRoute(route);
				if (l.get(0) == -1 || i < l.get(0)) {
					l.set(0, (double) i);
				}
				l.set(1, l.get(1) + (double) i);
				if (l.get(2) == -1 || i > l.get(2)) {
					l.set(2, (double) i);
				}
			}
			l.set(1, l.get(1) / solution.getRoutes().size());
			IntStream.range(0, l.size()).forEach(i -> l.set(i, FormatConv.round(a.onValue(l.get(i)), 2)));
			if (k == 0) {
				System.out.print("\t\t\t" + s + " & ");
			}
			System.out.print("(");
			System.out.print(l.stream().map(o -> o + "").collect(Collectors.joining(", ")));
			System.out.print(")");
			if (k + 1 < solutions.length) {
				System.out.print(" & ");
			} else {
				System.out.print(" \\\\");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {

		File[] listFiles = Paths.get("target", "networks").toFile().listFiles();
		Arrays.stream(listFiles).forEach(f -> System.out.println("read " + f.getName()));
		Solution[] s = new Solution[listFiles.length];
		for (int i = 0; i < listFiles.length; i++) {
			s[i] = XMIIO.deserialize(new FileInputStream(listFiles[i])).getSolution().get(0);
		}
		new Stats(listFiles, s);
	}
}

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import de.fuberlin.winfo.project.FormatConv;
import de.fuberlin.winfo.project.XMIIO;
import de.fuberlin.winfo.project.model.network.Event;
import de.fuberlin.winfo.project.model.network.EventType;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.Solution;
import dnl.utils.text.table.TextTable;

public class Stats {
	private Solution[] solutions;

	public Stats(File[] listFiles, Solution... arr) {
		this.solutions = arr;
		barChartsForManagerialInsights(listFiles, arr);

		managerialInsightsTable();

		printSolutionTable(arr);
		solvintTimeVsImprovementRatio();

		improvementByRR(solutions, listFiles);
	}

	private void improvementByRR(Solution[] sol, File[] l) {
		Map<String, Map<String, Double>> map = new HashMap<String, Map<String, Double>>();
		for (int i = 0; i < sol.length; i++) {
			HashMap<String, Double> hashMap = new HashMap<String, Double>();
			map.put(l[i].getName(), hashMap);
			Solution solution = sol[i];
			for (Event e : solution.getHistory().getEvents().stream()
					.filter(e -> e.getType() == EventType.ROUTE_REDUCING).collect(Collectors.toList())) {
				String s = e.getDescription().replace(".", "").replace(",", ".");
				if (!s.trim().equals("not reduced")) {
					String[] split = s.substring(s.indexOf(":") + 1, s.length()).split("-->");
					double impr = Double.valueOf(split[1].trim()) / Double.valueOf(split[0].trim());
					if (!hashMap.containsKey("RR")) {
						hashMap.put("RR", impr);
					} else {
						hashMap.put("RR", hashMap.get("RR") + impr);
					}
				}
			}

			for (int tt = 0; tt < solution.getHistory().getEvents().size(); tt++) {
				Event e = solution.getHistory().getEvents().get(tt);
				double impr = 0;
				if (tt > 0) {
					impr = solution.getHistory().getEvents().get(tt).getValue()
							/ solution.getHistory().getEvents().get(tt - 1).getValue();
				}
				if (e.getDescription() == null) {
					continue;
				}
				if (e.getDescription().contains("OQ")) {
					String s = e.getDescription();
					String nh = s.substring(0, s.indexOf(","));
					int successfull = Integer.valueOf(s.substring(s.indexOf("(") + 1, s.indexOf("/")));
					String key = nh + "_a";
					if (!hashMap.containsKey(key)) {
						hashMap.put(key, (double) successfull);
					} else {
						hashMap.put(key, hashMap.get(key) + successfull);
					}
					key = nh + "_#";
					if (!hashMap.containsKey(key)) {
						hashMap.put(key, 1d);
					} else {
						hashMap.put(key, hashMap.get(key) + 1d);
					}

					key = nh + "_i";
					if (!hashMap.containsKey(key)) {
						hashMap.put(key, impr);
					} else {
						hashMap.put(key, hashMap.get(key) + impr);
					}
				}
			}
		}

		List<List<String>> list = new ArrayList<List<String>>();
		List<String> collect = map.keySet().stream().collect(Collectors.toList());
		collect.add(0, "");
		list.add(collect);
		map.get(map.keySet().iterator().next()).keySet().forEach(k -> {
			ArrayList<String> arrayList = new ArrayList<String>();
			arrayList.add(k);
			list.add(arrayList);
		});

		for (String s : map.keySet()) {
			Map<String, Double> map2 = map.get(s);
			int asd = 1;
			for (String ss : map2.keySet()) {
				Double double1 = map2.get(ss);
				list.get(asd++).add(FormatConv.round(double1, 3) + "");
			}
		}
		for (List<String> m : list) {
			for (String mm : m) {
				System.out.print(mm + "\t");
			}
			System.out.println();
		}
	}

	private void barChartsForManagerialInsights(File[] listFiles, Solution... arr) {
		System.out.println();
		System.out.println("routes bar diagram");
		generateRouteGraph(listFiles, arr, new int[] { 0, 7, 10, 15, 20, 25, 30, 45, 50 }, r -> r.getWay().size() - 1,
				"mi");
		System.out.println();
		System.out.println("consumption model bar diagram");
		generateRouteGraph(listFiles, arr, new int[] { 0, 10, 16, 20, 24, 26, 30, 34 },
				r -> Math.round(r.getTotalVehicleBatteryConsumption() / 1000f), "mi2");
	}

	private void managerialInsightsTable() {
		System.out.println();
		System.out.println("Values for Managerial Insights Table");

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
	}

	private void solvintTimeVsImprovementRatio() {
		System.out.println();
		System.out.println("Solving Time vs. Improvement Ratio");
		Arrays.stream(solutions).sorted((s1, s2) -> Long.compare(s1.getSolvingTime(), s2.getSolvingTime())).forEach(
				s -> System.out.println(FormatConv.round(s.getSolvingTime() / 1000d / 3600d, 3) + "\t" + getImpr(s)));
	}

	private void printSolutionTable(Solution... arr) {
		System.out.println();
		System.out.println("Solution Table");
		for (int i = 0; i < arr.length; i++) {
			Solution s = solutions[i];
			Event event = s.getHistory().getEvents().get(s.getHistory().getEvents().size() - 1);

			String output = String.format("%s & %s & %s & %s & %s & %s", i + 1, s.getRoutes().size(),
					FormatConv.withSeparator(s.getTotalVehicleBatteryConsumption(), ""),
					FormatConv.withSeparator(event.getValue(), ""), FormatConv.round(getImpr(s) * 100d, 2) + " %",
					FormatConv.asDuration(s.getSolvingTime(), ""));
			System.out.println(output);
		}
	}

	private double getImpr(Solution s) {
		double prevCost = s.getHistory().getEvents().get(0).getValue();
		double cost = s.getHistory().getEvents().get(s.getHistory().getEvents().size() - 1).getValue();
		double diff = prevCost - cost;
		return diff / prevCost;
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

		File[] listFiles = Paths.get(".", "solutions").toFile().listFiles();
		Arrays.stream(listFiles).forEach(f -> System.out.println("read " + f.getName()));
		Solution[] s = new Solution[listFiles.length];
		for (int i = 0; i < listFiles.length; i++) {
			s[i] = XMIIO.deserialize(new FileInputStream(listFiles[i])).getSolution().get(0);
		}
		new Stats(listFiles, s);
	}
}

package de.fuberlin.winfo.project;

import java.io.IOException;
import java.util.Date;

import org.joda.time.format.DateTimeFormat;

import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Vertex;

public class Utils {
	public static class StopWatch {
		int before;
		int after;

		public StopWatch() {
			before = (int) new Date().getTime();
		}

		public String stop() {
			after = (int) new Date().getTime();
			return DateTimeFormat.forPattern("mm:ss.SSS").print(after - before);
		}

		public int getAfter() {
			return after;
		}

		public int getBefore() {
			return before;
		}
	}

	public static StopWatch stopWatchGo() {
		return new StopWatch();
	}

	public static ProgressBar showProgress(int n) {
		return new ProgressBar(n);
	}

	public static class ProgressBar {
		int n;
		int progress = -1;
		private StopWatch stapWatchGo;

		public ProgressBar(int n) {
			String[] values = "0%,50%,100%".split(",");
			for (int i = 0; true;) {
				String write = "-";
				if (i == 0) {
					write = values[0];
				} else if (i == 50) {
					write = values[1];
				} else if (i == 100 - values[2].length() + 1) {
					write = values[2];
				}
				i = i + write.length();
				System.out.print(write);
				if (i >= 100) {
					break;
				}
			}
			System.out.println();
			this.n = n;
			this.stapWatchGo = stopWatchGo();
		}

		public void update(int i) {
			int prog = (int) (((double) i * 100d) / (double) n);
			if (progress >= prog) {
				return;
			}
			while (progress < prog) {
				byte[] msg = String.valueOf((char) 0x2588).getBytes();
				try {
					System.out.write(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
				progress++;
			}
		}

		public void done() {
			System.out.println();
			System.out.println("Process finished within ".concat(stapWatchGo.stop()).concat(" m"));
		}
	}

	public static Duration getTimeWindow(Vertex v) {
		if (v instanceof Depot) {
			return ((Depot) v).getTimeWindow();
		} else if (v instanceof Order) {
			return ((Order) v).getTimeWindow();
		} else {
			return null;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int n = 16;
		ProgressBar showProgress = showProgress(n);
		for (int i = 1; i <= n; i++) {
			showProgress.update(i);
			Thread.sleep(25);
		}
		showProgress.done();
	}

}

package de.fuberlin.winfo.project;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TablePrinter {
	private String[] titles;
	private String format;
	private String separator = "| ";
	private int row = -1;
	private char lineChar = '=';
	private PrintStream printStream;
	private int numberingIndent = 5;
	private String[] columnFormat;

	public TablePrinter(PrintStream stream, String... titles) {
		this.printStream = stream;
		this.titles = titles;
		format = "";
		columnFormat = new String[titles.length];
		for (int i = 0; i < columnFormat.length; i++) {
			columnFormat[i] = "%-" + titles[i].length() + "s";
		}
		buildFormat();
	}

	private void buildFormat() {
		format = separator + Arrays.stream(columnFormat).collect(Collectors.joining(separator)) + separator + "%n";
	}

	public void setParam(int columnId, boolean alignLeft, int width) {
		columnFormat[columnId] = "%" + (alignLeft ? "" : "-") + width + "s";
		buildFormat();
	}

	public void setParam(int columnId, int width) {
		columnFormat[columnId] = "%-" + width + "s";
		buildFormat();
	}

	public void init() {
		int lineLength = Arrays.stream(columnFormat)
				.map(s -> s.replace("%", "").replace("-", "").replace("s", "").trim()).map(s -> Integer.valueOf(s))
				.mapToInt(s -> (int) s).sum();
		print(titles);
		lineLength += titles.length * separator.length() - 1;
		IntStream.range(0, numberingIndent).forEach(i -> out(" "));
		out(separator.toCharArray()[0]);
		IntStream.range(0, lineLength).forEach(i -> out(lineChar));
		out(separator.toCharArray()[0]);
		newLine();
	}

	public void print(Object... content) {
		String sRow = "";
		if (row == -1) {
			row++;
			init();
			print(content);
			return;
		} else if (row > 0) {
			sRow = row++ + ".";
		} else if (row == 0) {
			row++;
		}
		out(sRow);
		IntStream.range(0, numberingIndent - sRow.length()).forEach(i -> out(" "));
		String string = String.format(format, content);
		out(string);
	}

	private void out(Object o) {
		String s = o + "";
		try {
			printStream.write(s.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void newLine() {
		out("\n");
	}

	public static void main(String[] args) {
		TablePrinter printer = new TablePrinter(System.out, "Hello World", "B", "C", "D", "E");
		printer.setParam(1, false, 10);
		printer.setParam(2, true, 10);
		printer.setParam(3, false, 10);
		IntStream.range(0, 10).forEach(i -> printer.print(i * 2 + 1, i * 4, i * 2, i * 4, 1));
	}
}

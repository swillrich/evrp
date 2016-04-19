package de.fuberlin.winfo.project;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TablePrinter {
	String[] titles = "#, Prev Costs, New Costs, diff".split(", ");
	String format = "";
	int border = 8;
	String separator = "|  ";
	int rows = 0;
	char lineChar = '=';

	public void setTitles(String[] titles) {
		this.titles = titles;
	}

	private void init() {
		format = "";
		for (String title : titles) {
			int length = title.length() + border;
			format += "%-" + (length + separator.length()) + "s";
		}
		System.out.println();
		print(titles);
		int lineLength = Arrays.stream(titles).mapToInt(String::length).sum() + border * titles.length
				+ separator.length() * titles.length - 1;
		IntStream.range(0, lineLength).forEach(i -> System.out.print(lineChar));
		System.out.println();
	}

	public void print(Object... content) {
		if (rows == 0) {
			rows++;
			init();
		}
		Object[] c = new Object[titles.length];

		int offSet = titles.length - content.length;

		if (offSet > 0) {
			c[0] = "" + rows++;
		}

		for (int i = offSet; i < titles.length; i++) {
			c[i] = "" + content[i - offSet];
			if (i > 0) {
				c[i] = separator + c[i];
			}
		}
		String string = String.format(format, c);
		System.out.println(string);
	}
}

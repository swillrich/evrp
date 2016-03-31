package de.fuberlin.winfo.project.input.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;

import de.fuberlin.winfo.project.Log;
import dnl.utils.text.table.TextTable;

/**
 * @author willrich
 * 
 *         This abstract class organizes the read in / input of all CSV files
 *         given.<br>
 */
public abstract class AbstractCSVInput {

	/**
	 * The given CSV file to be read
	 */
	private File src;
	/**
	 * The separator which is used indicate a new column. ';' is default value.
	 */
	private char separator = ';';
	/**
	 * Is true if the first row represents the title row. False otherwise.
	 */
	private boolean firstRowIsTitle;
	private char quoteChar = '"';

	/**
	 * Constructs a new CSV input object. This call also executes the iterator,
	 * which invoke the abstract method to be implemented for each content row
	 * of the CSV file.
	 * 
	 * @param csvFile
	 *            The given CSV file to be read
	 * @param separator
	 *            The separator which is used indicate a new column. ';' is
	 *            default value.
	 * @param firstRowIsTitle
	 *            Is true if the first row represents the title row. False
	 *            otherwise.
	 * @throws FileNotFoundException
	 */
	public AbstractCSVInput(File csvFile, Character separator, boolean firstRowIsTitle, char quoteChar)
			throws Exception {
		Log.debug(Log.CSV_PARSING, "Starts with parsing file " + csvFile.getAbsolutePath(), null);
		this.src = csvFile;
		this.quoteChar = quoteChar;
		this.separator = separator == null ? this.separator : separator;
		this.firstRowIsTitle = firstRowIsTitle;
		iterate();
	}

	private void iterate() throws Exception {
		CSVReader reader = getReader();
		reader.readNext();
		for (String[] readNext = reader.readNext(); readNext != null; readNext = reader.readNext()) {
			try {
				nextLine(readNext);
			} catch (Exception e) {
				throw new Exception("Failure in line: " + lineAsString(readNext), e);
			}
		}
	}

	public String[] getAsArr(String origin) {
		if (origin.startsWith("[") && origin.endsWith("]")) {
			String[] strings = origin.substring(1, origin.length() - 1).split("" + this.separator);
			if (Arrays.asList(strings).stream().filter(s -> s.length() > 0).count() > 0) {
				return strings;
			} else {
				return new String[] {};
			}
		}
		return null;
	}

	/**
	 * Returns a given StringArray as comma separated output.
	 */
	public String lineAsString(String[] line) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < line.length; i++) {
			b.append(line[i]);
			if (i + 1 < line.length) {
				b.append(", ");
			}
		}
		return b.toString();
	}

	/**
	 * Iterates over the whole content of the CSV file. If the first line of the
	 * incoming CSV file contains the title names, this row will be skipped.
	 * 
	 * @param line
	 *            current line with data for each column
	 */
	public abstract void nextLine(String[] line);

	private CSVReader getReader() throws FileNotFoundException {
		CSVReader reader = new CSVReader(new FileReader(this.src), this.separator, this.quoteChar);
		return reader;
	}

	/**
	 * Prints out the table with title bar and content. If no column titles are
	 * given, the names remain unspecified.
	 * 
	 * @throws FileNotFoundException
	 */
	public void printAsTable() throws FileNotFoundException {
		CSVReader reader = getReader();
		List<String[]> all = null;
		try {
			all = reader.readAll();
		} catch (IOException e) {
			Log.debug(Log.CSV_PARSING, e.getMessage(), e);
			return;
		}
		Object[][] content;
		String[] columns;
		if (firstRowIsTitle) {
			columns = all.get(0);
			content = new Object[all.size() - 1][];
			for (int i = 1; i < all.size(); i++) {
				content[i - 1] = new Object[all.get(i).length];
				for (int c = 0; c < all.get(i).length; c++) {
					content[i - 1][c] = all.get(i)[c];
				}
			}
		} else {
			columns = new String[all.get(0).length];
			for (int columnIndex = 0; columnIndex < all.get(0).length; columnIndex++) {
				columns[columnIndex] = "no title";
			}
			content = new Object[all.size()][];
			for (int i = 0; i < all.size(); i++) {
				content[i] = new Object[all.get(i).length];
				for (int c = 0; c < all.get(i).length; c++) {
					content[i][c] = all.get(i)[c];
				}
			}
		}
		TextTable table = new TextTable(columns, content);
		table.setAddRowNumbering(true);
		table.printTable();
	}
}

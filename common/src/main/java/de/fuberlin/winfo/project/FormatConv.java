package de.fuberlin.winfo.project;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

public class FormatConv {
	public static String numberWithSeparatorAndMeter(long totalDistance) {
		return numberWithSeparator(totalDistance, "m");
	}

	public static String numberWithSeparator(double totalDistance, String appender) {
		DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.GERMAN);
		DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

		symbols.setGroupingSeparator('.');
		formatter.setDecimalFormatSymbols(symbols);
		appender = " " + appender;
		return formatter.format(totalDistance).concat(appender);
	}

	public static String asTime(long time, String appender) {
		DateTime timeObj = new DateTime(time * 1000);

		String result = new SimpleDateFormat("mm:ss").format(new Date(time * 1000));

		PeriodFormatter pf = new PeriodFormatterBuilder().printZeroAlways().appendHours().toFormatter();
		String hours = pf.print(new Period(new DateTime(0), timeObj, PeriodType.time()));
		hours = (hours.length() == 1 ? "0" : "") + hours;
		result = hours + ":" + result + "" + (appender.length() > 0 ? " " + appender : "");
		return result;
	}

	public static String getInEuro(double euro) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String moneyString = formatter.format(euro);
		return moneyString;
	}
}

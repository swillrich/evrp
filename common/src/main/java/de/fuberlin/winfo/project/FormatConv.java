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
		return withSeparator(totalDistance, "m");
	}

	public static String withSeparator(double value, String appender) {
		DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.GERMAN);
		DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

		symbols.setGroupingSeparator('.');
		formatter.setDecimalFormatSymbols(symbols);
		if (appender.length() > 0) {
			appender = " " + appender;
		}
		return formatter.format(value).concat(appender);
	}

	public static String asDuration(long time, String appender) {
		DateTime timeObj = new DateTime(time);

		String result = new SimpleDateFormat("mm:ss").format(new Date(time));

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

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();
		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	public static String asDateTime(long dateTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		return sdf.format(new Date(dateTime));
	}

	public static String getDateTimeUntilHours(long dateTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(new Date(dateTime));
	}
}

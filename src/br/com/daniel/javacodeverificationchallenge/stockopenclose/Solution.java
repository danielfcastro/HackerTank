package br.com.daniel.javacodeverificationchallenge.stockopenclose;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Solution {
	private static final String DATE_MASK = "d-MMMM-yyyy";
	private static String _url = "https://jsonmock.hackerrank.com/api/stocks/search?pageNumber=PARM_PAGE&date=PARM_DATE";
	private static Set<String> weekDaysSet = new HashSet<String>(7);
	// Static block used to verify the Days of Week
	static {
		weekDaysSet.add("Monday");
		weekDaysSet.add("Tuesday");
		weekDaysSet.add("Wednesday");
		weekDaysSet.add("Thursday");
		weekDaysSet.add("Friday");
		weekDaysSet.add("Saturday");
		weekDaysSet.add("Sunday");
	}

	/**
	 * Check if the day of week passed as argument is valid. If so, returns true
	 * 
	 * @param day
	 * @return true if it is a valid day, false otherwise
	 */
	private static boolean isValidWeekDay(String day) {
		return weekDaysSet.contains(day);
	}

	/**
	 * validates the date passed as argument and returns a LocalDate
	 * 
	 * @param date
	 * @return a LocalDate if the date passed as argument is valid, null otherwise.
	 */
	private static LocalDate validateDate(String date) {
		LocalDate retorno = null;
		// Simple Date Format is not safe for concurrency so the best practice is to
		// create one for each thread.
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_MASK, Locale.US);
		if (null != date) {
			try {
				retorno = LocalDate.parse(date, formatter);
			} catch (DateTimeParseException e) {
				e.printStackTrace();
			}
		}
		return retorno;
	}

	/**
	 * Returns a list of Dates that are between the star, the end and which the day
	 * of week is the one passed on parameter weekday
	 * 
	 * @param start   - start date
	 * @param end     - end date
	 * @param weekday - day of week to filter
	 * @return a List of LocalDate
	 */
	private static List<LocalDate> getDatesBetweenAndisAWeekday(LocalDate start, LocalDate end, String weekday) {
		long numOfDaysBetween = ChronoUnit.DAYS.between(start, end);
		List<LocalDate> retorno = null;
		if (isValidWeekDay(weekday)) {
			retorno = IntStream.iterate(0, i -> i + 1).limit(numOfDaysBetween).mapToObj(i -> start.plusDays(i))
					.collect(Collectors.toList()).stream()
					.filter(dates -> dates.getDayOfWeek().compareTo(DayOfWeek.valueOf(weekday.toUpperCase())) == 0)
					.collect(Collectors.toList());
			// retorno = retorno.stream().filter(dates ->
			// dates.getDayOfWeek().compareTo(DayOfWeek.valueOf(weekday.toUpperCase())) ==
			// 0).collect(Collectors.toList());

		}
		return retorno;

	}

	/*
	 * Complete the function below.
	 */
	static void openAndClosePrices(String firstDate, String lastDate, String weekDay) {
		List<Stock> result = new ArrayList<>();
		LocalDate _auxFirstDate = validateDate(firstDate);
		LocalDate _auxLastDate = validateDate(lastDate);
		// Gets the dates that are the specified week days and are between two dates
		List<LocalDate> range = getDatesBetweenAndisAWeekday(_auxFirstDate, _auxLastDate, weekDay);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_MASK, Locale.US);
		for (LocalDate date : range) {
			try {
				result.addAll(callRestAPI(1, date.format(formatter)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (Stock stock : result) {
			System.out.println(stock);
		}
	}

	/**
	 * Call the REST API
	 * 
	 * @param page - The page of the result
	 * @param date - The date to filter
	 * @return
	 * @throws MalformedURLException if the URL is malformed
	 * @throws IOException
	 * @throws ProtocolException
	 */
	private static List<Stock> callRestAPI(int page, String date)
			throws MalformedURLException, IOException, ProtocolException {
		StockList pagedResult;
		List<Stock> data;
		// First page execution
		Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat(DATE_MASK).create();

		// Parse the query
		String pagedURL = _url.replaceAll("PARM_PAGE", Integer.toString(page)).replaceAll("PARM_DATE", date);

		// Prepare the GET Request
		URL address = new URL(pagedURL);
		HttpURLConnection conn = (HttpURLConnection) address.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuilder content = new StringBuilder();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		conn.disconnect();
		pagedResult = (StockList) gson.fromJson(content.toString(), StockList.class);
		data = pagedResult.getData();
		if (pagedResult.getTotal_pages() > 1) {
			for (int i = 2; i < pagedResult.getTotal_pages() + 1; i++) {
				data.addAll(callRestAPI(i, date));
			}
		}
		return data;
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String _firstDate;
		try {
			_firstDate = in.nextLine();
		} catch (Exception e) {
			_firstDate = null;
		}

		String _lastDate;
		try {
			_lastDate = in.nextLine();
		} catch (Exception e) {
			_lastDate = null;
		}

		String _weekDay;
		try {
			_weekDay = in.nextLine();
		} catch (Exception e) {
			_weekDay = null;
		}

		openAndClosePrices(_firstDate, _lastDate, _weekDay);
		in.close();
	}
}

/**
 * A class to store the JSON returned by the API
 * 
 * @author daniel_ferreira
 *
 */
class StockList {
	int page = 0;
	int per_page = 0;
	int total = 0;
	int total_pages = 0;
	List<Stock> data;

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPer_page() {
		return per_page;
	}

	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public List<Stock> getData() {
		return data;
	}

	public void setData(List<Stock> data) {
		this.data = data;
	}
}

/**
 * A class to store the Stock type
 * 
 * @author daniel_ferreira
 *
 */
class Stock {
	private static final String DATE_MASK = "d-MMMM-yyyy";
	private Date date;
	String open;
	String high;
	String low;
	String close;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_MASK, Locale.US);
		return sb.append(convertToLocalDate(date).format(formatter)).append(" ").append(open).append(" ").append(close)
				.toString();
		// return new com.google.gson.Gson().toJson(this);
	}

	public static LocalDate convertToLocalDate(Date dateToConvert) {
		return Instant.ofEpochMilli(dateToConvert.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}
}
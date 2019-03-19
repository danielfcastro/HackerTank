package br.com.daniel.javacodeverificationchallenge.reformattingdates;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

class Result {
	private static Map<String, Integer> months = new HashMap<>();
	private static final String FIRST = "st";
	private static final String SECOND = "nd";
	private static final String THIRD = "rd";
	private static final String FOURTH = "th";
	private static String MINUS = "-";

	static {
		months.put("Jan", 1);
		months.put("Feb", 2);
		months.put("Mar", 3);
		months.put("Apr", 4);
		months.put("May", 5);
		months.put("Jun", 6);
		months.put("Jul", 7);
		months.put("Aug", 8);
		months.put("Sep", 9);
		months.put("Oct", 10);
		months.put("Nov", 11);
		months.put("Dec", 12);
	}

	/*
	 * Complete the 'reformatDate' function below.
	 *
	 * The function is expected to return a STRING_ARRAY. The function accepts
	 * STRING_ARRAY dates as parameter.
	 */
	private static String stripOrdinal(String day) {
		return day.replaceAll(FIRST, "").replaceAll(SECOND, "").replaceAll(THIRD, "").replaceAll(FOURTH, "");
	}
	/*
	 * Complete the 'reformatDate' function below.
	 *
	 * The function is expected to return a STRING_ARRAY. The function accepts
	 * STRING_ARRAY dates as parameter.
	 */

	public static List<String> reformatDate(List<String> dates) {
		// Write your code here
		String[] _aux = null;
		String DD, MM, YYYY;
		List<String> retorno = new ArrayList<>(dates.size());
		StringBuilder sb = null;
		for (String element : dates) {
			_aux = element.split(" ");
			DD = stripOrdinal(_aux[0]);
			DD = String.format("%02d", Integer.parseInt(DD));
			MM = String.format("%02d", months.get(_aux[1]));
			YYYY = _aux[2];
			sb = new StringBuilder();
			sb.append(YYYY).append(MINUS).append(MM).append(MINUS).append(DD);
			retorno.add(sb.toString());
			sb = null;
			_aux = null;
		}
		return retorno;
	}
}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int datesCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> dates = IntStream.range(0, datesCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		List<String> result = Result.reformatDate(dates);

		bufferedWriter.write(result.stream().collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}

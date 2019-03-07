package br.com.daniel.challenges.booking.challenge1;

import static java.util.stream.Collectors.toMap;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Map<Integer, Integer> mapOfHotels = new LinkedHashMap<Integer, Integer>();
		Map<Integer, Integer> sortedMapOfHotels = new LinkedHashMap<Integer, Integer>();
		
		Scanner in = new Scanner(System.in);// .toLowerCase()
		String[] key_word = getKeywords(in);
		int M = getNumberOfReviews(in);
		getHotelIdAndReview(mapOfHotels, in, key_word, M);		
		in.close();
	}

	private static void getHotelIdAndReview(Map<Integer, Integer> mapOfHotels, Scanner in, String[] keyWords, int M) {
		Map<Integer, Integer> sortedMapOfHotels;
		int count;
		for (int i = 0; i < M; i++) {
			count = 0;
			/// System.out.println(i);
			// alternates an hotel ID and a review belonging to that hotel.
			Integer hotelID = Integer.parseInt(in.nextLine()); // ID
			String review = in.nextLine();// review

			for (String keyWord : keyWords) {
				if (review.contains(keyWord))
					count++;
			}
			if (mapOfHotels.get(hotelID) != null)
				mapOfHotels.put(hotelID, count + mapOfHotels.get(hotelID));
			else
				mapOfHotels.put(hotelID, count);
		}
		sortedMapOfHotels = mapOfHotels.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		sortedMapOfHotels.forEach((k, v) -> System.out.println((k + ":" + v)));
		mapOfHotels.clear();
		mapOfHotels = null;
	}

	private static int getNumberOfReviews(Scanner in) {
		int M = in.nextInt();
		return M;
	}

	private static String[] getKeywords(Scanner in) {
		String key_words = in.nextLine();
		String[] key_word = key_words.split("\\s+");
		return key_word;
	}
}
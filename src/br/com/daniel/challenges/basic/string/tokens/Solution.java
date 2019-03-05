package br.com.daniel.challenges.basic.string.tokens;

import java.util.Arrays;

public class Solution {
	private static String APOSTROPHES = "'";
	private static String AT = "@";
	private static String COMMAS = ",";
	private static String EXCLAMATION = "!";
	private static String PERIOD = "\\.";
	private static String QUESTION_MARK = "\\?";
	private static String UNDERSCORE = "_";

	public static void getTokens(String s) {
		if ((null == s) || (s.equalsIgnoreCase(""))) {
			System.out.println(0);
		} else {
			StringBuilder sb = new StringBuilder();
			s = s.replaceAll(APOSTROPHES, " ");
			s = s.replaceAll(AT, " ");
			s = s.replaceAll(COMMAS, " ");
			s = s.replaceAll(EXCLAMATION, " ");
			s = s.replaceAll(PERIOD, " ");
			s = s.replaceAll(QUESTION_MARK, " ");
			s = s.replaceAll(UNDERSCORE, " ");
			s = s.replaceAll("\\s{2,}", " ").trim();
			if(s.isEmpty()) {
				System.out.println(0);
			}else {
				String tokens[] = s.split(" ");
				System.out.println(tokens.length);
				Arrays.stream(tokens).forEach(token -> System.out.println(token));				
			}
		}
	}
}

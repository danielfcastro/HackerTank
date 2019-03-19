package br.com.daniel.challenges.medium.tagcontentextractor;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	private static final String REGEX = "<([^\\/\\s<>]+[^<>\\/]*)>([^<>]+)<(\\/\\1[^\\/<>]?)>";

	public static void main(String[] args) {
		boolean matchFound = false;
		Scanner in = new Scanner(System.in);
		Pattern p = Pattern.compile(REGEX);
		int numSentences = Integer.parseInt(in.nextLine());

		while (numSentences-- > 0) {
			matchFound = false;
			String input = in.nextLine();

			Matcher m = p.matcher(input);

			while (m.find()) {
				System.out.println(m.group(2));
				matchFound = true;
			}
			if (!matchFound) {
				System.out.println("None");
			}
		}
		in.close();
	}
}
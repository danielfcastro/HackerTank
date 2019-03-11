package br.com.daniel.warmupchallenges.countingvalleys;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	private static Character UP = 'U';
	private static Character DOWN = 'D';

	// Complete the countingValleys function below.
	static int countingValleys(int n, String s) {
		int counter = 0;
		int valleys = 0;
		for (Character c : s.toCharArray()) {
			if (c.equals(UP))
				counter++;
			else if (c.equals(DOWN))
				counter--;
			if (counter == 0 && c.equals(UP))
				valleys++;
		}
		return valleys;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = 8;// scanner.nextInt();
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = "UDDDUDUU";// scanner.nextLine();

		int result = countingValleys(n, s);
		System.out.println(result);
		// bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();

		// bufferedWriter.close();

		scanner.close();
	}
}

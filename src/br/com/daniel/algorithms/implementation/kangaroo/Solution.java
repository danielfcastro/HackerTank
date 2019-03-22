package br.com.daniel.algorithms.implementation.kangaroo;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	private static final String YES = "YES";
	private static final String NO = "NO";

	// Complete the kangaroo function below.
	static String kangaroo(int x1, int v1, int x2, int v2) {
		if ((v2 >= v1) && (x2 != x1))
			return NO;
		else {
			//Calculates the ratio of difference of stating point and speed 
			float x = (float) (x2 - x1) / (v1 - v2);
			//If the lower integer of the ratio is equal itself it means that both sequences have equal spots at same time
			if (Math.floor(x) == x)
				return YES;
			else
				return NO;
		}
	}

	static long sumOfAP(int a, int d, int n) {
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + a;
			a = a + d;
		}
		return sum;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] x1V1X2V2 = scanner.nextLine().split(" ");

		int x1 = Integer.parseInt(x1V1X2V2[0]);

		int v1 = Integer.parseInt(x1V1X2V2[1]);

		int x2 = Integer.parseInt(x1V1X2V2[2]);

		int v2 = Integer.parseInt(x1V1X2V2[3]);

		String result = kangaroo(x1, v1, x2, v2);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}

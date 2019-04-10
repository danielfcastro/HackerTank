package br.com.daniel.algorithms.implementation.betweentwosets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	/*
	 * Complete the getTotalX function below.
	 */
	static int getTotalX(int[] a, int[] b) {
		/*
		 * Write your code here.
		 */
		int count = 0;
		int gcd = b[0];
		int lcm = lowestCommonMultiplier(a);
		for (int i = 1; i < b.length; i++) {
			gcd = greatestCommonDivisor(gcd, b[i]);
		}
		int m = lcm;
		int i = 1;
		while (m <= gcd) {
			m = lcm * i;
			if (gcd % m == 0) {
				count++;
			}
			i++;
		}

		return count;
	}

	static int greatestCommonDivisor(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return greatestCommonDivisor(b, a % b);
		}
	}

	static int lowestCommonMultiplier(int[] array) {
		int retorno = 1;
		for (int i : array) {
			retorno = (retorno * i) / greatestCommonDivisor(retorno, i);
		}
		return retorno;
	}



	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nm = scan.nextLine().split(" ");

		int n = Integer.parseInt(nm[0].trim());

		int m = Integer.parseInt(nm[1].trim());

		int[] a = new int[n];

		String[] aItems = scan.nextLine().split(" ");

		for (int aItr = 0; aItr < n; aItr++) {
			int aItem = Integer.parseInt(aItems[aItr].trim());
			a[aItr] = aItem;
		}

		int[] b = new int[m];

		String[] bItems = scan.nextLine().split(" ");

		for (int bItr = 0; bItr < m; bItr++) {
			int bItem = Integer.parseInt(bItems[bItr].trim());
			b[bItr] = bItem;
		}

		int total = getTotalX(a, b);

		bw.write(String.valueOf(total));
		bw.newLine();

		bw.close();
	}
}
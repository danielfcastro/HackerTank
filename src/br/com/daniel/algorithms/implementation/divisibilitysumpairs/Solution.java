package br.com.daniel.algorithms.implementation.divisibilitysumpairs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the divisibleSumPairs function below.
	static int divisibleSumPairs(int n, int k, int[] ar) {
		int retorno = 0;
		// A complimentary list of remainders of the division by k
		int[] remainders = new int[k];
		for (int i = 0; i < ar.length; i++) {
			int remainder = ar[i] % k;
			remainders[remainder]++;
		}
		// All numbers that have 0 remainder must only be paired with other numbers with
		// 0 remainder
		int remaindersZero = remainders[0];

		// all elements against a subset of one less of itself and only half the pairs
		// can be used
		retorno += (remaindersZero * (remaindersZero - 1)) / 2;

		// Now, for all other remainders, pairs are of those
		// that are complementing remainders
		// i.e. if K = 5, remainders would be 0, 1, 2, 3, 4
		// we know that 0 has already been accounted for
		// so, next pairs are all of those in 1 with 4 and
		// all those in 2 with 3
		// So we only need to iterate through half of the
		// remaining remainders, and make sure that we don't
		// use a reaminder against itself for this calculation
		for (int i = 1; i <= k / 2 && i != k - i; i++) {
			retorno += remainders[i] * remainders[k - i];
		}

		// Finally, there is one more case to consider, if K
		// yields an even number of remainders, the loop above
		// would have skipped the exact middle remainder.
		// i.e. for k = 4, remainders = 0, 1, 2, 3
		// 0 has been accounted for
		// 1 and 3 were paired up
		// 2 is missing
		// This last remainder behaves like the 0 remainder,
		// so, we need to pair the numbers against themselves
		if (k % 2 == 0) {
			int halfCount = remainders[k / 2];
			retorno += (halfCount * (halfCount - 1)) / 2;
		}
		return retorno;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] ar = new int[n];

		String[] arItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arItem = Integer.parseInt(arItems[i]);
			ar[i] = arItem;
		}

		int result = divisibleSumPairs(n, k, ar);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}

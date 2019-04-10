package br.com.daniel.algorithms.implementation.breakingtherecords;

import java.io.IOException;

public class Solution {

	// Complete the breakingRecords function below.
	static int[] breakingRecords(int[] scores) {
		int min, max;
		int[] retorno = new int[2];
		retorno[0] = 0;
		retorno[1] = 0;
		min = scores[0];
		max = min;
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] > max) {
				retorno[0]++;
				max = scores[i];
			}
			if (scores[i] < min) {
				retorno[1]++;
				min = scores[i];
			}
		}
		return retorno;
	}

	public static void main(String[] args) throws IOException {
		int[] scores = {10, 5, 20, 20, 4, 5, 2, 25, 1 };

		int[] result = breakingRecords(scores);

		System.out.println("{" + result[0] + ", " + result[1] + "}");
	}
}

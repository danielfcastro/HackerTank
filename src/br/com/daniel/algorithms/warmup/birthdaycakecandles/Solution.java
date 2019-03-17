package br.com.daniel.algorithms.warmup.birthdaycakecandles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	// Complete the birthdayCakeCandles function below.
	static int birthdayCakeCandles(int[] ar) {
		Arrays.sort(ar);
		int counter = 0;
		for(int i=ar.length-1;i>0;i--) {
			if(ar[i] != ar[i-1]) {
				break;
			}else counter++;
		}
		return counter+1;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int arCount = 100000;

		int[] ar = new int[100000];
		for(int i=0;i<100000;i++) ar[i] = 1;


		int result = birthdayCakeCandles(ar);
		System.out.println(result);

		scanner.close();
	}
}

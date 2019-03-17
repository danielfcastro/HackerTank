package br.com.daniel.algorithms.warmup.plusminus;

import java.util.Scanner;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
    	float positiveFraction = 0;
    	float negativeFraction = 0;
    	float zeroFraction = 0;
    	for(int i=0;i<arr.length;i++) {
    		if(arr[i] > 0)positiveFraction++;
    		else if(arr[i] < 0)negativeFraction++;
    	}
    	System.out.println(positiveFraction /= arr.length);
    	System.out.println(negativeFraction /= arr.length);
    	zeroFraction = 1 - positiveFraction - negativeFraction;
    	System.out.println(zeroFraction);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}

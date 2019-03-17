package br.com.daniel.algorithms.warmup.staircase;

import java.util.Scanner;

public class Solution {

    // Complete the staircase function below.
    static void staircase(int n) {
    	StringBuilder sb = new StringBuilder();
    	for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(j<n-i+1) sb.append(" ");
				else sb.append("#");
			}
			sb.append('\n');
    	}
    	System.out.println(sb.toString());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}

package br.com.daniel.algorithms.implementation.maximizingxor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the maximizingXor function below.
    static int maximizingXor(int l, int r) {
    	int retorno = 0;
    	int XOR = l ^ r;
    	//To Maximize the XOR the difference between the two operators must be such that maximizes the result in every bit
    	//To start I need to get the MSB (Most Significant Bit)
    	//31 is because the MSB is the 31st bit
    	//By doing the line below I get the most significant bit of the XOR operation
    	int MSB = 31 - Integer.numberOfLeadingZeros(XOR);
    	//If I LEFT SHIFT the number 1 the number corresponding to the MSB + 1
    	//I will get a 1 followed by MSB+1 ZEROS
    	//If a subtract 1 I will get a number that has the MSB equals the MSB of r
    	//and also that maximizes the XOR operation
    	retorno = (1 << (MSB + 1)) - 1;
    	return retorno;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int r = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = maximizingXor(l, r);
        System.out.println(result);

		/*
		 * bufferedWriter.write(String.valueOf(result)); bufferedWriter.newLine();
		 * 
		 * bufferedWriter.close();
		 */
        scanner.close();
    }
}


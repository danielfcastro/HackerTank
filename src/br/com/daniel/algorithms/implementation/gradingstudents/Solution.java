package br.com.daniel.algorithms.implementation.gradingstudents;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	private static int THRESHOLD = 38;

	/*
	 * Complete the gradingStudents function below.
	 */
	static int[] gradingStudents(int[] grades) {
		/*
		 * Write your code here.
		 */
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] >= THRESHOLD) {
				int nextMultpleOfFive = roundMultipleOfFive(grades[i]);
				if (nextMultpleOfFive - grades[i] < 3) {
					grades[i] = nextMultpleOfFive;
				}
			}
		}
		return grades;
	}

	static int roundMultipleOfFive(int n) {
		return (n + 4) / 5 * 5;
	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(scan.nextLine().trim());

		int[] grades = new int[n];

		for (int gradesItr = 0; gradesItr < n; gradesItr++) {
			int gradesItem = Integer.parseInt(scan.nextLine().trim());
			grades[gradesItr] = gradesItem;
		}

		int[] result = gradingStudents(grades);

		for (int resultItr = 0; resultItr < result.length; resultItr++) {
			bw.write(String.valueOf(result[resultItr]));

			if (resultItr != result.length - 1) {
				bw.write("\n");
			}
		}

		bw.newLine();

		bw.close();

		System.out.println(result);
	}
}

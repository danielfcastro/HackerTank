package br.com.daniel.challenges.substring.comparisons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static String getSmallestAndLargest(String s, int k) {
        ArrayList<String> stack = new ArrayList<>();
        for (int i = 0; i <= s.length() - k; i++) {
            stack.add(s.substring(i, i + k));
        }

        Collections.sort(stack);

        String smallest = stack.get(0);
        String largest = stack.get(stack.size() - 1);

        return smallest + "\n" + largest;
    }

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int k = scan.nextInt();
		scan.close();

		System.out.println(getSmallestAndLargest(s, k));
	}
}
package br.com.daniel.challenges.basic.datatypes;

import java.util.Scanner;
import java.util.regex.Pattern;

public class EndOfFile {

	public static void readAndPrint() {
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter(Pattern.compile("[\\r\\n;]+"));
		StringBuilder sb = new StringBuilder();
		int counter = 1;
		while (sc.hasNext()) {
			String t = sc.next();
			sb.append(counter).append(" ").append(t).append('\n');
			counter++;
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		readAndPrint();
	}
}

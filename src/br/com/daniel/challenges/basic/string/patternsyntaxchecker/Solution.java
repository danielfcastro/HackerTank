package br.com.daniel.challenges.basic.string.patternsyntaxchecker;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Solution {
	public static void checkValidSyntax(String regex) {
		try {
			Pattern p = Pattern.compile(regex);
			System.out.println("Valid");
		} catch (PatternSyntaxException e) {
			System.out.println("Invalid");
		}
	}
}

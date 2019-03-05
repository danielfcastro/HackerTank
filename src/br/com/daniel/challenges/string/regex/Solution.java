package br.com.daniel.challenges.string.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	static class MyRegex {
		public static final String IP = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";	
		public static boolean pattern(String address) {
			Pattern p = Pattern.compile(IP);
			Matcher matcher = p.matcher(address);
			return matcher.matches();
		}		
	}
}

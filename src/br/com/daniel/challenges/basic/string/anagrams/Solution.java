package br.com.daniel.challenges.basic.string.anagrams;

public class Solution {
	public static boolean isAnagram(String a, String b) {
		boolean retorno = false;
	    String sortedA = a.toLowerCase().chars()
	    	      .sorted()
	    	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	    	      .toString();		
	    String sortedB = b.toLowerCase().chars()
	    	      .sorted()
	    	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	    	      .toString();
	    if(sortedA.equalsIgnoreCase(sortedB)) retorno = true;
	    return retorno;
	}

}

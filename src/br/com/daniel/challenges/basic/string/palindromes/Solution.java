package br.com.daniel.challenges.basic.string.palindromes;

public class Solution {
	public boolean isPalindrome(String value) {
		boolean retorno = false;
		StringBuilder sb = new StringBuilder(value.toLowerCase());
		sb = sb.reverse();
		if(value.contentEquals(sb)) retorno = true;
		return retorno;
	}

}

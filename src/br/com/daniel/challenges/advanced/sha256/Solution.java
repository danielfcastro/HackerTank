package br.com.daniel.challenges.advanced.sha256;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Solution {
	public static byte[] getSHA256(String s) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] encodedhash = digest.digest(s.getBytes(StandardCharsets.UTF_8));
		return encodedhash;
	}

	private static String bytesToHex(byte[] hash) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
	
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        System.out.println(bytesToHex(getSHA256(s)));
        scan.close();
    } 
}

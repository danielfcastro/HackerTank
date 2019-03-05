package br.com.daniel.challenges.advanced.md5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Solution {
    public static String getMD5(String s) throws NoSuchAlgorithmException {
           MessageDigest m=MessageDigest.getInstance("MD5");
           m.update(s.getBytes(),0,s.length());
           return new BigInteger(1,m.digest()).toString(16);
    }
    
    public static void main(String[] args) throws NoSuchAlgorithmException{
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        System.out.println(getMD5(s));
        scan.close();
    }
}

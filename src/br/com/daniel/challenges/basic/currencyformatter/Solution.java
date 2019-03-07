package br.com.daniel.challenges.basic.currencyformatter;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
	static NumberFormat numberFormatter;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        numberFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        String us = numberFormatter.format(payment);
        
        numberFormatter = NumberFormat.getCurrencyInstance(new Locale("EN", "IN"));
        String india = numberFormatter.format(payment);
        
        numberFormatter = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String china = numberFormatter.format(payment);
        
        numberFormatter = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String france = numberFormatter.format(payment);
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}

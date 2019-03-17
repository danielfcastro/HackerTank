package br.com.daniel.algorithms.warmup.timeconversion;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
	static int HH;
	static int MM;
	static int SS;
	
    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
    	String [] _aux = s.split(":");
    	HH = Integer.parseInt(_aux[0]);
    	MM = Integer.parseInt(_aux[1]);
    	boolean PM = false;
    	if(_aux[2].contains("PM")) {
    		_aux[2] = _aux[2].replaceAll("PM", "");
    		PM = true;
    	}else {
    		_aux[2] = _aux[2].replaceAll("AM", "");
    	}
    	
    	SS = Integer.parseInt(_aux[2]);
    	if(HH == 12) {
    		if(!PM) HH = 0;
    	}else {
    		if(PM) HH +=12;
    	}

    	StringBuilder retorno = new StringBuilder();
    	retorno.append(String.format("%02d",HH)).append(":").append(String.format("%02d",MM)).append(":").append(String.format("%02d",SS));
    	return retorno.toString();
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = "04:59:59AM";

        String result = timeConversion(s);
        System.out.println(result);

    }
}

package br.com.daniel.challenges.medium.bigdecimal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution{
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        //Write your code here
        Arrays.sort(s, new Comparator<String>() {
    	    @Override
    	    public int compare(String value1, String value2) {
    		if (value1 == null || value2 == null) {
    		    return 0;
    		}
    		BigDecimal bdValue1 = new BigDecimal(value1);
    		BigDecimal bdValue2 = new BigDecimal(value2);
    		return bdValue2.compareTo(bdValue1);
    	    }
    	});
        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}
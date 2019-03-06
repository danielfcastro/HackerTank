package br.com.daniel.challenges.basic.datatypes;

import java.util.Scanner;

public class StaticInitializerBlock {

    static int breadthLOW = -100;
    static int breadthHIGH = 100;
    static int heightlow = -100;
    static int heightHIFG = 100;
    static int error = -100;
    static int B = 0;
    static int H = 0;
    static boolean flag = false;
    static {
        flag = true;
        Scanner sc = new Scanner(System.in);
        B = sc.nextInt();
        H = sc.nextInt();
        if(B < 0 || H < 0){
            flag = false;
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        } 
        if(B >= breadthHIGH || H >= heightHIFG){
            flag = false;
        }
    }

public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class


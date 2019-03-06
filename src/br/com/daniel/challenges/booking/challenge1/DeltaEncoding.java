package br.com.daniel.challenges.booking.challenge1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeltaEncoding {
	//1 elemento =
	//elemento seguinte = ele - anterior
	static int[] delta_encode(int [] array) {
		List<Integer> temp = new ArrayList();
		int diff = 0;
		for(int i=0;i<array.length;i++) {
			if(i==0) temp.add(array[0]);
			else {
				diff =array[i] - array[i-1];
				if ((diff >=127) || (diff <= -127)) {
					temp.add(-128);
				}
				temp.add(diff);
			}
		}
		int[] ret = new int[temp.size()];
	    for (int i=0; i < temp.size(); i++)
	    {
	        ret[i] = temp.get(i).intValue();
	    }
	    return ret;
	}
	
	public static void main(String[] args) throws IOException{
		int [] array = {25626,25757,24367,24267,16,100,2,7277};
		printArray(delta_encode(array));
	}
	
	static void printArray(int []a) {
		for(int i=0; i<a.length;i++) {
			System.out.println(a[i]);
		}
		
	}
}

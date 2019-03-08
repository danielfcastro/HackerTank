package br.com.daniel.challenges.medium.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deque <Integer>deque = new ArrayDeque<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		int n = in.nextInt();
		int m = in.nextInt();
		Integer maxUniqueNumber = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            //It means that you already filled the max of Map which is m
            if (i >= m) {
                int old = deque.remove();
                if (map.get(old) == 1) {
                    map.remove(old);
                } else {
                    map.put(old, map.get(old) - 1);
                }
            }
            /* Add new value */
            deque.add(num);
            map.merge(num, 1, Integer::sum);
            maxUniqueNumber = Math.max(maxUniqueNumber, map.size());
			
            /* If all integers are unique, break out of loop */
            if (maxUniqueNumber == m) {
                break;
            }            
            
        }
        System.out.println(maxUniqueNumber);
		in.close();
		in = null;
	}
}
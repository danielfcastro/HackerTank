package br.com.daniel.challenges.medium.onedarray;

import java.util.Scanner;

public class Solution {
	
    public static boolean canWin(int[] game, int leap, int i) {
    	if(i< 0 || game[i] == 1) return false;
    	if((i == game.length - 1) || i + leap > game.length - 1) return true;
    	game[i] = 1;
    	return canWin(game, leap, i + 1) || canWin(game, leap, i-1) || canWin(game, leap, i+leap);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int sizeOfGame = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[sizeOfGame];
            for (int i = 0; i < sizeOfGame; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(game, leap, 0)) ? "YES" : "NO" );
        }
        scan.close();
        scan = null;
    }
}
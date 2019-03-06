package br.com.daniel.challenges.advanced.evenoddquery;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static int find(int[] arr, int x, int y){
        int basis = arr[x-1];
        if(x < y && arr[x] ==0) {
        	return 1;
        }
        if(basis %2 == 0) {
            return 2;
        }else return 1;
    }

    // Complete the solve function below.
    static String[] solve(int[] arr, int[][] queries) {
        int rows = queries.length;
        String[] retorno = new String[rows];
        int ans = 0;
        for (int i=0;i < rows; i++){
            ans = find(arr, queries[i][0], queries[i][1]);
            if(ans % 2 == 0) retorno[i] = "Even";
            else retorno[i] = "Odd";
        }
        return retorno;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/RESULTADO08.TXT"));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:/input08.txt"));
        String line = bufferedReader.readLine();
        int arrCount = Integer.parseInt(line);

        int[] arr = new int[arrCount];

        String[] arrItems = bufferedReader.readLine().split(" ");

        for (int arrItr = 0; arrItr < arrCount; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr]);
            arr[arrItr] = arrItem;
        }

        int q = Integer.parseInt(bufferedReader.readLine());

        int[][] queries = new int[q][2];

        for (int queriesRowItr = 0; queriesRowItr < q; queriesRowItr++) {
            String[] queriesRowItems = bufferedReader.readLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr]);
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        String[] result = solve(arr, queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(result[resultItr]);

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        //bufferedWriter.newLine();

        bufferedWriter.close();
        bufferedReader.close();

        scanner.close();
    }
}

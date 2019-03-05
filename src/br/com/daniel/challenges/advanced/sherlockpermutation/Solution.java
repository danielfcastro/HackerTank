package br.com.daniel.challenges.advanced.sherlockpermutation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    static final int MODULUS = 1000000007;

    static BigInteger C(int n, int m) {
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < m; i++) {
            result = result.multiply(BigInteger.valueOf(n - i)).divide(BigInteger.valueOf(i + 1));        }
        return result;
    }    
    // Complete the solve function below.
    static int solve(int n, int m) {
        return C(n + m - 1, n).mod(BigInteger.valueOf(MODULUS)).intValue();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int result = solve(n, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

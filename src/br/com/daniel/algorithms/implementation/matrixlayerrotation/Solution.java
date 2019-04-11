package br.com.daniel.algorithms.implementation.matrixlayerrotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	// Complete the matrixRotation function below.
	static void matrixRotation(List<List<Integer>> matrix, int r) {
		int m = matrix.size();
		int n = matrix.get(0).size();
		int layers = getLayers(m, n);
		for (int layer = 0; layer < layers; ++layer) {
			for (int x = 0; x < r % (2 * (m + n - 2 - 4 * layer)); x++) {
				int i = layer, j = layer;
				int temp = matrix.get(layer).get(layer);
				while (i < m - 1 - layer) {
					int temp2 = matrix.get(i+1).get(j);
					matrix.get(i+1).set(j, temp);
					temp = temp2;
					i++;
				}

				while (j < n - 1 - layer) {
					int temp2 = matrix.get(i).get(j+1);
					matrix.get(i).set(j+1, temp);
					temp = temp2;
					j++;
				}

				while (i > layer) {
					int temp2 = matrix.get(i-1).get(j);
					matrix.get(i-1).set(j, temp);
					temp = temp2;
					i--;
				}

				while (j > layer) {
					int temp2 = matrix.get(i).get(j-1);
					matrix.get(i).set(j-1, temp);
					temp = temp2;
					j--;
				}
			}
		}
		printMatrix(matrix);
	}

	private static int getLayers(int m, int n) {
		return Math.min(m, n) / 2;
	}
	
	private static void printMatrix(List<List<Integer>> matrix) {
		for(int x = 0; x < matrix.size(); x++ )
		{
			for(int y = 0; y < matrix.get(0).size(); y++ )
                {
                System.out.print(matrix.get(x).get(y) + " ");
            }
			System.out.println();
		}		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int m = Integer.parseInt(mnr[0]);

		int n = Integer.parseInt(mnr[1]);

		int r = Integer.parseInt(mnr[2]);

		List<List<Integer>> matrix = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

			List<Integer> matrixRowItems = new ArrayList<>();

			for (int j = 0; j < n; j++) {
				int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
				matrixRowItems.add(matrixItem);
			}

			matrix.add(matrixRowItems);
		}

		matrixRotation(matrix, r);

		bufferedReader.close();
	}
}

package br.com.daniel.algorithms.warmup.birthdaychocolate;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Solution {

	// Complete the birthday function below.
	static int birthday(List<Integer> s, int d, int m) {
		int retorno = 0;
		List<List<Integer>> partitions = getPartitions(s, m);
		Iterator<List<Integer>> ite = partitions.iterator();
		while (ite.hasNext()) {
			List<Integer> elem = ite.next();
			int sum = elem.stream().mapToInt(Integer::intValue).sum();
			if (sum == d)
				retorno++;
		}
		return retorno;
	}

	static List<List<Integer>> getPartitions(List<Integer> lista, int partitionSize) {
		List<List<Integer>> retorno = new ArrayList<>();
		boolean del = false;
		for (int i = 0; i < lista.size(); i++) {
			List<Integer> temp = new ArrayList<>();
			for (int j = i; j < i + partitionSize; j++) {
				try {
					temp.add(lista.get(j));
				} catch (IndexOutOfBoundsException e) {
					temp.clear();
					del = true;
					break;
				}
			}
			if (!del)
				retorno.add(temp);
		}
		return retorno;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int d = Integer.parseInt(dm[0]);

		int m = Integer.parseInt(dm[1]);

		int result = birthday(s, d, m);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}

package br.com.daniel.challenges.basic.datatypes;

import java.util.Scanner;

public class Datatypes {
	public static void getFittableTypes(String value) {
		StringBuilder sb = new StringBuilder(value).append(" can be fitted in:");
		int temp = 0;
		try {
			if (isByteFittable(value)) {
				temp++;
				sb.append("\n");
				sb.append("* byte");
			}
			if (isShortFittable(value)) {
				temp++;
				sb.append("\n");
				sb.append("* short");
			}
			if (isIntegerFittable(value)) {
				temp++;
				sb.append("\n");
				sb.append("* int");
			}
			if (isLongFittable(value)) {
				temp++;
				sb.append("\n");
				sb.append("* long");
			}
		} catch (NumberFormatException e) {

		}
		if (temp == 0) {
			sb.setLength(0);
			sb.append(value);
			sb.append(" can't be fitted anywhere.");
		}
		System.out.println(sb);
	}

	private static boolean isByteFittable(String value) {
		boolean retorno = false;
		try {
			Byte.parseByte(value);
			retorno = true;
		} catch (NumberFormatException e) {
		}
		return retorno;
	}

	private static boolean isShortFittable(String value) {
		boolean retorno = false;
		try {
			Short.parseShort(value);
			retorno = true;
		} catch (NumberFormatException e) {
		}
		return retorno;
	}

	private static boolean isIntegerFittable(String value) {
		boolean retorno = false;
		try {
			Integer.parseInt(value);
			retorno = true;
		} catch (NumberFormatException e) {
		}
		return retorno;
	}

	private static boolean isLongFittable(String value) {

		boolean retorno = false;
		try {
			Long.parseLong(value);
			retorno = true;
		} catch (NumberFormatException e) {
		}
		return retorno;
	}

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			String x = sc.next();
			getFittableTypes(x);
		}
		sc.close();
	}

}

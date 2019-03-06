package br.com.daniel.challenges.booking.challenge1;

public class Triangle {
	//sum of 2 edges > remaining edge
	
	public int isTriangle(int a, int b, int c) {
		int retorno = 0;
		if((a == b) && (b == c)){
			retorno = 1;
		}else if((a + b > c) && (a + c > b) && (b + c > a)){
			retorno = 2;
		}
		return retorno;
	}
}

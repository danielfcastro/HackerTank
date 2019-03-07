package br.com.daniel.challenges.booking.challenge1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CallQueueSize {
	private static int on;
	private static int optimumSize = 0;
	private static int dataPoints = 0;
	private static int customerNumber = 0;

	private static List<Call> calls = new ArrayList<>();

	public static int getOptimumSize() {
		for (int i = 0; i < dataPoints; i++) {
			for (int j = 0; j < dataPoints; j++) {
				if (i != j) {
					// If a call finishes after the begining of another call AND the same call
					// finishes before the finish of the other call
					if (calls.get(i).getEnd() >= calls.get(j).getStart()
							&& calls.get(i).getEnd() < calls.get(j).getEnd())
						on++;
				}
			}
			
		}

		optimumSize = (on - customerNumber) == 0 ? 0 : on - customerNumber;
		return optimumSize;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		customerNumber = in.nextInt();
		dataPoints = in.nextInt();

		for (int i = 0; i < dataPoints; i++) {
			Call temp = new Call();
			String line = in.nextLine();
			temp.setStart(Integer.parseInt(line.split(" ")[0]));
			temp.setEnd(Integer.parseInt(line.split(" ")[1]));
			calls.add(temp);
		}
		System.out.println(getOptimumSize());
		in.close();
	}
}

class Call {
	private int start;
	private int end;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public Call() {
		super();
		// TODO Auto-generated constructor stub
	}
}

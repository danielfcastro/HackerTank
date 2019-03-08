package br.com.daniel.challenges.medium.priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
 * Create the Student and Priorities classes here.
 */

class Student {
	private int ID;
	private String name;
	private double cgpa;

	Student(int iD, String name, double cgpa) {
		super();
		ID = iD;
		this.name = name;
		this.cgpa = cgpa;
	}

	public static Student getInstance(int iD, String name, double cgpa) {
		return new Student(iD, name, cgpa);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
}

class Priorities {
	private static final String SERVED = "SERVED";
	private static final String ENTER = "ENTER";

	public List<Student> getStudents(List<String> events) {
		PriorityQueue<Student> studentQueue = new PriorityQueue<Student>(Comparator.comparing(Student::getCgpa)
				.reversed().thenComparing(Student::getName).thenComparing(Student::getID));
		List<Student> students = new ArrayList<Student>();
		Scanner in = null;
		for (String e : events) {
			in = new Scanner(e);
			String event = in.nextLine();
			if (event.equals(ENTER)) {
				String name = in.next();
				float cgpa = in.nextFloat();
				int id = in.nextInt();
				Student student = new Student(id, name, cgpa);
				studentQueue.add(student);
			} else if (event.equals(SERVED)) {
				Student first = studentQueue.poll();
			}
			in.close();
		}
		Student first = studentQueue.poll();
		in = null;
		if (first == null) {
			return students;
		} else {
			while (first != null) {

				students.add(first);
				first = studentQueue.poll();

			}
			return students;
		}
	}
}

public class Solution {
	private final static Scanner scan = new Scanner(System.in);
	private final static Priorities priorities = new Priorities();

	public static void main(String[] args) {
		int totalEvents = Integer.parseInt(scan.nextLine());
		List<String> events = new ArrayList<>();

		while (totalEvents-- != 0) {
			String event = scan.nextLine();
			events.add(event);
		}

		List<Student> students = priorities.getStudents(events);

		if (students.isEmpty()) {
			System.out.println("EMPTY");
		} else {
			for (Student st : students) {
				System.out.println(st.getName());
			}
		}
	}
}
package br.com.daniel.challenges.basic.stack;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	private static boolean checkIfIsBalanced(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (Character c : s.toCharArray()) {
			// If the char is an opening char I push onto the stack
			if (c == '[' || c == '(' || c == '{') {
				stack.push(c);
			}
			// If it is a closing bracket
			else if (c == ']') {
				// If the stack is empty or the pop operation does not return an opening bracket
				// the string is unbalanced
				if (stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
			}
			// If it is a closing bracket
			else if (c == ')') {
				// If the stack is empty or the pop operation does not return an opening
				// parenthesis the string is unbalanced
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
			} // If it is a closing brace
			else if (c == '}') {
				// If the stack is empty or the pop operation does not return an opening brace
				// the string is unbalanced
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
			}
		}
		if(stack.isEmpty()) return true;
		else return false;
	}

	public static void main(String[] argh) {
		String input = "{}(";
		// Complete the code
		System.out.println((checkIfIsBalanced(input)));
	}
}

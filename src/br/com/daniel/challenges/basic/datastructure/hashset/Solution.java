package br.com.daniel.challenges.basic.datastructure.hashset;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		class Pair {
			String a;
			String b;

			public Pair(String a, String b) {
				super();
				this.a = a;
				this.b = b;
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((a == null) ? 0 : a.hashCode());
				result = prime * result + ((b == null) ? 0 : b.hashCode());
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Pair other = (Pair) obj;
				if (a == null) {
					if (other.a != null)
						return false;
				} else if (!a.equals(other.a))
					return false;
				if (b == null) {
					if (other.b != null)
						return false;
				} else if (!b.equals(other.b))
					return false;
				return true;
			}
		}		
		int t = 5;
		String[] pair_left = {"john", "john", "john", "mary", "mary"};
		String[] pair_right = {"tom", "mary", "tom", "anna", "anna"};


		// Write your code here
		Set <Pair> set = new HashSet<>();
		for(int i=0;i<t;i++) {
			String a = pair_left[i];
			String b = pair_right[i];
			Pair e = new Pair(a,b);
			set.add(e);
			System.out.println(set.size());
		}
	}
}
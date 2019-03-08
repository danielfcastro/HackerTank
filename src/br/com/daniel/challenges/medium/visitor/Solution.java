package br.com.daniel.challenges.medium.visitor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

enum Color {
	RED, GREEN
}

abstract class Tree {

	private int value;
	private Color color;
	private int depth;

	public Tree(int value, Color color, int depth) {
		this.value = value;
		this.color = color;
		this.depth = depth;
	}

	public int getValue() {
		return value;
	}

	public Color getColor() {
		return color;
	}

	public int getDepth() {
		return depth;
	}

	public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

	private ArrayList<Tree> children = new ArrayList<>();

	public TreeNode(int value, Color color, int depth) {
		super(value, color, depth);
	}

	public void accept(TreeVis visitor) {
		visitor.visitNode(this);

		for (Tree child : children) {
			child.accept(visitor);
		}
	}

	public void addChild(Tree child) {
		children.add(child);
	}
}

class TreeLeaf extends Tree {

	public TreeLeaf(int value, Color color, int depth) {
		super(value, color, depth);
	}

	public void accept(TreeVis visitor) {
		visitor.visitLeaf(this);
	}
}

abstract class TreeVis {
	public abstract int getResult();

	public abstract void visitNode(TreeNode node);

	public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
	private int sum = 0;
	public int getResult() {
		// implement this
		return sum;
	}

	public void visitNode(TreeNode node) {
		// implement this
	}

	public void visitLeaf(TreeLeaf leaf) {
		sum += leaf.getValue();
	}
}

class ProductOfRedNodesVisitor extends TreeVis {
	private static final int MODULUS = 1000000007;
	private int product = 1;
	public int getResult() {
		// implement this
		return product;
	}

	public void visitNode(TreeNode node) {
		// implement this
		if (node.getColor() == Color.RED) {
			multiplyBy(node.getValue());
		}
	}

	public void visitLeaf(TreeLeaf leaf) {
		// implement this
		if (leaf.getColor() == Color.RED) {
			multiplyBy(leaf.getValue());
		}		
	}
	
	private void multiplyBy(int value) {
		if (value == 0) {
			return;
		}
		product = (int) ((long) product * value % MODULUS);
	}	
}

class FancyVisitor extends TreeVis {
	private int evenDepthNonLeafSum = 0;
	private int greenLeafSum = 0;	
	public int getResult() {
		// implement this
		return Math.abs(evenDepthNonLeafSum - greenLeafSum);
	}

	public void visitNode(TreeNode node) {
		// implement this
		if (node.getDepth() % 2 == 0) {
			evenDepthNonLeafSum += node.getValue();
		}		
	}

	public void visitLeaf(TreeLeaf leaf) {
		// implement this
		if (leaf.getColor() == Color.GREEN) {
			greenLeafSum += leaf.getValue();
		}		
	}
}

public class Solution {

	public static Tree solve() {
		// read the tree from STDIN and return its root as a return value of this
		// function
		Scanner sc = new Scanner(System.in);
		int numberOfNodes = sc.nextInt();
		int[] values = new int[numberOfNodes + 1];
		for (int i = 1; i <= numberOfNodes; i++) {
			values[i] = sc.nextInt();
		}

		Color[] colors = new Color[numberOfNodes + 1];
		for (int i = 1; i <= numberOfNodes; i++) {
			colors[i] = (sc.nextInt() == 0) ? Color.RED : Color.GREEN;
		}

		@SuppressWarnings("unchecked")
		List<Integer>[] adjacentsList = new List[numberOfNodes + 1];
		for (int i = 1; i <= numberOfNodes; i++) {
			adjacentsList[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < numberOfNodes - 1; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			adjacentsList[u].add(v);
			adjacentsList[v].add(u);
		}

		sc.close();

		@SuppressWarnings("unchecked")
		List<Integer>[] childrenList = new List[numberOfNodes + 1];
		for (int i = 1; i <= numberOfNodes; i++) {
			childrenList[i] = new ArrayList<Integer>();
		}

		int[] depths = new int[numberOfNodes + 1];
		boolean[] visited = new boolean[numberOfNodes + 1];

		Queue<Integer> queue = new LinkedList<Integer>();
		depths[1] = 0;
		queue.offer(1);
		while (!queue.isEmpty()) {
			int head = queue.poll();

			if (visited[head]) {
				continue;
			}
			visited[head] = true;

			for (int adjacent : adjacentsList[head]) {
				if (!visited[adjacent]) {
					childrenList[head].add(adjacent);
					depths[adjacent] = depths[head] + 1;
					queue.offer(adjacent);
				}
			}
		}

		Tree[] nodes = new Tree[numberOfNodes + 1];
		for (int i = 1; i <= numberOfNodes; i++) {
			if (childrenList[i].isEmpty()) {
				nodes[i] = new TreeLeaf(values[i], colors[i], depths[i]);
			} else {
				nodes[i] = new TreeNode(values[i], colors[i], depths[i]);
			}
		}
		for (int i = 1; i <= numberOfNodes; i++) {
			for (int child : childrenList[i]) {
				((TreeNode) nodes[i]).addChild(nodes[child]);
			}
		}

		return nodes[1];
	}

	public static void main(String[] args) {
		Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
		ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
		FancyVisitor vis3 = new FancyVisitor();

		root.accept(vis1);
		root.accept(vis2);
		root.accept(vis3);

		int res1 = vis1.getResult();
		int res2 = vis2.getResult();
		int res3 = vis3.getResult();

		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
	}
}
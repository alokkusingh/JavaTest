package alok.test.algo.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Java implementation to check if given Binary tree
//is a BST or not

/* Class containing left and right child of current
node and key value*/
class Node {
	int data;
	Node left, right;

	public Node(int item) {
		data = item;
		// left = right = null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
}

public class BinaryTree {
	// Root of the Binary Tree
	Node root;

	/*
	 * can give min and max value according to your code or can write a function
	 * to find min and max value of tree.
	 */
	/*
	 * returns true if given search tree is binary search tree (efficient
	 * version)
	 */
	boolean isBST() {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/*
	 * Returns true if the given tree is a BST and its values are >= min and <=
	 * max.
	 */
	private boolean isBSTUtil(Node node, int min, int max) {
		/* an empty tree is BST */
		if (node == null)
			return true;

		/* false if this node violates the min/max constraints */
		if (node.data < min || node.data > max)
			return false;

		/*
		 * otherwise check the subtrees recursively tightening the min/max
		 * constraints
		 */
		// Allow only distinct values
		return (isBSTUtil(node.left, min, node.data - 1) && isBSTUtil(node.right, node.data + 1, max));
	}

	public static void inOrderTraverse(Node node) {
		if (node == null)
			return;

		inOrderTraverse(node.left);
		System.out.println(node);
		inOrderTraverse(node.right);
	}

	public static void preOrderTraverse(Node node) {
		if (node == null)
			return;

		System.out.println(node);
		preOrderTraverse(node.left);
		preOrderTraverse(node.right);
	}

	public static void postOrderTraverse(Node node) {
		if (node == null)
			return;

		postOrderTraverse(node.left);
		postOrderTraverse(node.right);
		System.out.println(node);
	}

	public static int getNodeLevel(Node root, int key) {
		return getNodeLevel(root, key, 1);
	}

	//in each iteration - if key found then level will be returned otherwise 0 will be returned
	// if non zero returned no need further iteration
	// if zero returned do further iteration until null
	private static int getNodeLevel(Node root, int key, int level) {
		if (root == null) {
			return 0;
		}

		if (root.data == key) {
			return level;
		}

		//check left tree
		int levelReturned = getNodeLevel(root.left, key, level + 1);
		if (levelReturned != 0) {
			return levelReturned;
		}

		//did not find key in left so traversal right tree
		levelReturned = getNodeLevel(root.right, key, level + 1);

		return levelReturned;
	}

	public static void printSpiralOrder(Node root) {
		if (root == null) {
			return;
		}

		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		boolean directionFalg = false;
		
		while (!stack.isEmpty()) {
			Stack<Node> internalStack = new Stack<Node>();

			while (!stack.isEmpty()) {
				Node node = stack.pop();
				System.out.format("%d ", node.data);

				if (directionFalg) {
					if (node.left != null)
						internalStack.push(node.left);

					if (node.right != null)
						internalStack.push(node.right);
				} else {
					if (node.right != null)
						internalStack.push(node.right);

					if (node.left != null)
						internalStack.push(node.left);
				}
			}
			directionFalg = !directionFalg;
			stack = internalStack;
		}
	}

	// this is BFS
	public static void printLevelTraversalBFS(Node root) {

		if (root == null)
			return;

		Queue<Node> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);

		while(!nodeQueue.isEmpty()) {
			Node node = nodeQueue.remove();

			//System.out.print(node.data + " ");
			System.out.format("%d ", node.data);
			if (node.left != null)
				nodeQueue.add(node.left);

			if (node.right != null)
				nodeQueue.add(node.right);
		}
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		//     4
		//    / \
		//   2   5
		//  / \
		// 1   3

		tree.root = new Node(4);
		tree.root.left = new Node(2);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);

		if (tree.isBST())
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");

		BinaryTree.inOrderTraverse(tree.root);
		System.out.println();
		BinaryTree.preOrderTraverse(tree.root);
		System.out.println();
		BinaryTree.postOrderTraverse(tree.root);

		System.out.println("1 Level: " + BinaryTree.getNodeLevel(tree.root, 1));
		System.out.println("2 Level: " + BinaryTree.getNodeLevel(tree.root, 2));
		System.out.println("3 Level: " + BinaryTree.getNodeLevel(tree.root, 3));
		System.out.println("4 Level: " + BinaryTree.getNodeLevel(tree.root, 4));
		System.out.println("5 Level: " + BinaryTree.getNodeLevel(tree.root, 5));
		System.out.println("6 Level: " + BinaryTree.getNodeLevel(tree.root, 6));

		System.out.println("Data:\n" +
				"\t     4\n" +
				"\t    / \\\n" +
				"\t   2   5\n" +
				"\t  / \\\n" +
				"\t 1   3");

		System.out.println("\nSpiral Traversal");
		BinaryTree.printSpiralOrder(tree.root);

		System.out.println("\nLevel Traversal - BFS");
		BinaryTree.printLevelTraversalBFS(tree.root);
	}
}
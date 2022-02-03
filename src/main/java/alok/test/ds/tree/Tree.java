package alok.test.ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree<T> {

    private Node root;

    public void setRoot(Node node) {
        this.root = node;
    }

    public void printInorder() {
        System.out.print("In Order: ");
        printInorder(root);
        System.out.println();
    }
    private void printInorder(Node node) {
        if (node == null)
            return;

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public void printPreeorder() {
        System.out.print("Pre Order: ");
        printPreeorder(root);
        System.out.println();
    }
    private void printPreeorder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        printPreeorder(node.left);
        printPreeorder(node.right);
    }
    public void printPostorder() {
        System.out.print("Post Order: ");
        printPostorder(root);
        System.out.println();
    }
    private void printPostorder(Node node) {
        if (node == null)
            return;

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    public void printZigzag() {
        if (root == null)
            return;

        boolean leftToRight = true;
        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Stack<Node> tempStatck = new Stack<>();
            while (!stack.isEmpty()) {
                Node current = stack.pop();
                System.out.print(current.data + " ");
                if (leftToRight) {
                    if (current.left != null)
                        tempStatck.add(current.left);
                    if (current.right != null)
                        tempStatck.add(current.right);
                } else {
                    if (current.right != null)
                        tempStatck.add(current.right);
                    if (current.left != null)
                        tempStatck.add(current.left);
                }
            }
            if (leftToRight)
                leftToRight = false;
            else
                leftToRight = true;
            stack = tempStatck;
        }
        System.out.println();
    }



    class Node {

        private Node left, right;
        private T data;

        public Node(T data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

    }
}

package alok.test.ds.tree;

import javax.xml.crypto.Data;

public class App {

    public static void main(String[] args) {

        //                  4
        //           3              6
        //      1               5        7
        //          2                          8


        Tree<Integer> tree = new Tree<>();
        Tree.Node node1 = tree.new Node(1);
        Tree.Node node2 = tree.new Node(2);
        Tree.Node node3 = tree.new Node(3);
        Tree.Node node4 = tree.new Node(4);
        Tree.Node node5 = tree.new Node(5);
        Tree.Node node6 = tree.new Node(6);
        Tree.Node node7 = tree.new Node(7);
        Tree.Node node8 = tree.new Node(8);
        tree.setRoot(node4);
        node4.setLeft(node3);
        node4.setRight(node6);
        node3.setLeft( node1);
         node1.setRight(node2);
        node6.setLeft(node5);
        node6.setRight(node7);
        node7.setRight(node8);

        tree.printInorder();
        tree.printPreeorder();
        tree.printPostorder();

        tree.printZigzag();




    }
}

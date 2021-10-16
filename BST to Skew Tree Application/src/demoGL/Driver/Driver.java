package demoGL.Driver;

import java.util.LinkedList;
import java.util.Queue;
import demoGL.TreeCreation.Insert;
import demoGL.Traversal.Inorder;

public class Driver {
	
	// Methods to create nodes of the tree

	public static class Node {
		public Node leftNode;
		public Node rightNode;
		public int nodeData;
	};

	public static Node newNode(int nodeData) {
		Node temp = new Node();

		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;

		return temp;
	}

	public static void main(String args[]) {

		Queue<Integer> input = new LinkedList<>();	

		// Hardcoded input provided in the Question
		
		Node root = newNode(50);
		root.leftNode = newNode(30);
		root.rightNode = newNode(60);
		root.leftNode.leftNode = newNode(10);
		root.rightNode.leftNode = newNode(40);

		
		// Inorder traversal to store the node values of BST in ascending order to make it easy to create skew tree
		
		Inorder obj = new Inorder();
		Insert object = new Insert();
		obj.inorderTraversal(root , input);
		object.skewTree(input);

	}

}

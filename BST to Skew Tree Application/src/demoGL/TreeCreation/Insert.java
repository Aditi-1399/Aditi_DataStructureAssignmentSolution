package demoGL.TreeCreation;

import java.util.Queue;

import demoGL.Driver.Driver.Node;
import demoGL.Traversal.PrintInorder;

public class Insert {

	public void skewTree(Queue<Integer> input) {
		Node skewTree = newNode(input.remove());
		while(!input.isEmpty())
			insert(skewTree , input);


		// ALTERNATE HARDCODED SECOND METHOD TO CONVERT TO SKEW TREE

		//skewTree.rightNode = newNode(input.remove());
		//skewTree.rightNode.rightNode = newNode(input.remove());
		//skewTree.rightNode.rightNode.rightNode = newNode(input.remove());
		//skewTree.rightNode.rightNode.rightNode.rightNode = newNode(input.remove());

		PrintInorder obj = new PrintInorder();
		obj.printInorder(skewTree);
	}

	public Node newNode(int nodeData) {

		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;

		return temp;
	}

	// Method to create the skew tree which takes root node and queue as inputs
	
	public Node insert(Node skewTree, Queue<Integer> input) {
		int data = input.remove();
		Node newnode = newNode(data);
		Node x = skewTree;
		// y maintains pointer to x
		Node y = null; 
		while (x != null) {
			y = x;
			if (data < x.nodeData)
				x = x.leftNode;
			else if (data > x.nodeData)
				x = x.rightNode;
			else {
				System.out.println("Value already exists!!!");
				return newnode;
			}
		}
		// If the root is null, the tree is empty.
		if (y == null)
			y = newnode;
		// assign new node node to the left child
		else if (data < y.nodeData)
			y.leftNode = newnode;
		// assign the new node to the right child
		else
			y.rightNode = newnode;
		// return pointer to new node
		return y;
	}



}

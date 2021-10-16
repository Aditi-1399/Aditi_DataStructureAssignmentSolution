package demoGL.Traversal;

import java.util.Queue;
import demoGL.Driver.Driver.Node;

public class Inorder {
	
	// Method to create a queue with all data values in ascending order which will be input to generate skew tree

	public void inorderTraversal(Node root , Queue<Integer> input) {

		if (root == null)
			return;
		else {
			inorderTraversal(root.leftNode , input);
			input.add(root.nodeData);
			inorderTraversal(root.rightNode , input);
		}

	}

}

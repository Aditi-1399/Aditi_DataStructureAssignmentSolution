package demoGL.Traversal;

import demoGL.Driver.Driver.Node;

public class PrintInorder {

	public void printInorder(Node skewTree) {
		
		// Method to display skew tree

		if (skewTree == null)
			return;
		else {
			printInorder(skewTree.leftNode);
			System.out.print(skewTree.nodeData + " ");
			printInorder(skewTree.rightNode);
		}

	}

}

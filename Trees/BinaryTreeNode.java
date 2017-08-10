import java.util.*;
import java.lang.Math;

public class BinaryTreeNode {
	private int value;
	private BinaryTreeNode leftChild;
	private BinaryTreeNode rightChild;

	public BinaryTreeNode() {
		this(0, null, null);
	}

	public BinaryTreeNode(int value, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public void breadthFirstSearch(int searchVal) {
		Queue<BinaryTreeNode> nodesToVisit = new LinkedList<>();
		nodesToVisit.add(this);

		while(nodesToVisit.peek() != null) {
			BinaryTreeNode currentNode = nodesToVisit.poll();
			if(currentNode.value == searchVal) {
				System.out.println("|" + currentNode.value + "|");
			} else {
				System.out.println(currentNode.value);
			}

			if(currentNode.leftChild != null) {
				nodesToVisit.add(currentNode.leftChild);	
			}
			if(currentNode.rightChild != null) {
				nodesToVisit.add(currentNode.rightChild);	
			}
		}
	}

	public void depthFirstSearch(int searchVal) {
		Stack<BinaryTreeNode> nodesToVisit = new Stack<BinaryTreeNode>();
		nodesToVisit.add(this);

		while(!nodesToVisit.empty()) {
			BinaryTreeNode currentNode = nodesToVisit.pop();
			if(currentNode.value == searchVal) {
				System.out.println("|" + currentNode.value + "|");
			} else {
				System.out.println(currentNode.value);
			}

			if(currentNode.leftChild != null) {
				nodesToVisit.add(currentNode.leftChild);	
			}
			if(currentNode.rightChild != null) {
				nodesToVisit.add(currentNode.rightChild);	
			}
		}
	}

	public void printPreOrder() {
		System.out.println(this.value);
		
		if(this.leftChild != null) {
			this.leftChild.printPreOrder();
		}
		if(this.rightChild != null) {
			this.rightChild.printPreOrder();
		}
	}

	public void printInOrder() {
		if(this.leftChild != null){
			this.leftChild.printInOrder();
		}
		System.out.println(this.value);
		if(this.rightChild != null) {
			this.rightChild.printInOrder();
		}
	}

	public void printPostOrder() {
		if(this.leftChild != null){
			this.leftChild.printPostOrder();
		}
		if(this.rightChild != null) {
			this.rightChild.printPostOrder();
		}

		System.out.println(this.value);
	}

	public int size() {
		if(this.leftChild == null && this.rightChild == null) {
			return 1;
		} else if(this.rightChild == null) {
			return 1 + this.leftChild.size();
		} else if(this.leftChild == null) {
			return 1 + this.rightChild.size();
		} else {
			return 1 + this.leftChild.size() + this.rightChild.size();
		}
	}

	public int height() {
		if(this.leftChild == null && this.rightChild == null) {
			return 1;
		} else if(this.leftChild == null) {
			return 1 + this.rightChild.height();
		} else if(this.rightChild == null) {
			return 1 + this.leftChild.height();
		} else {
			return 1 + Math.max(this.leftChild.height(), this.rightChild.height());
		}
	}

	public static void main(String[] args) {
		/*
					n1
				   /  \
				n2		n3
			   /
			n4		
		   /  \
		n5	   n6
		
		*/

		BinaryTreeNode n6 = new BinaryTreeNode(6, null, null);
		BinaryTreeNode n5 = new BinaryTreeNode(5, null, null);
		BinaryTreeNode n4 = new BinaryTreeNode(4, n5, n6);
		BinaryTreeNode n3 = new BinaryTreeNode(3, null, null);
		BinaryTreeNode n2 = new BinaryTreeNode(2, n4, null);
		BinaryTreeNode n1 = new BinaryTreeNode(1, n2, n3);

		// n1.breadthFirstSearch(5);
		// n1.depthFirstSearch(5);
		// n1.printPreOrder();
		// n1.printInOrder();
		// n1.printPostOrder();
		System.out.println(n1.height());
	}
	
}
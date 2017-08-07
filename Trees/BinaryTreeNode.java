import java.util.*;

// int size( )            --> Return size of subtree at node
// int height( )          --> Return height of subtree at node
// void printPostOrder( ) --> Print a postorder tree traversal
// void printInOrder( )   --> Print an inorder tree traversal
// void printPreOrder( )  --> Print a preorder tree traversal

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

	public static void main(String[] args) {
		/*
					n1
				   /  \
				n2		n3
			   /
			n4		
		   /  \
		n6	   n5
		
		*/

		BinaryTreeNode n6 = new BinaryTreeNode(6, null, null);
		BinaryTreeNode n5 = new BinaryTreeNode(5, null, null);
		BinaryTreeNode n4 = new BinaryTreeNode(4, n5, n6);
		BinaryTreeNode n3 = new BinaryTreeNode(3, null, null);
		BinaryTreeNode n2 = new BinaryTreeNode(2, n4, null);
		BinaryTreeNode n1 = new BinaryTreeNode(1, n2, n3);

		n1.breadthFirstSearch(5);
		n1.depthFirstSearch(5);
	}
	
}
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

	public BinaryTreeNode(int value) {
		this(value, null, null);
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

	public static boolean canFormTree(ArrayList<BinaryTreeNode> nodes) {
		// Given an array of BinaryTreeNodes, check if all of these nodes can form a binary tree


		/*
			SOLUTION:
			now i am thinking that i can run a breadth first search from starting from each node in the array list. if one of them comes out to use all of the nodes in the list, i.e. size of tree == size of array list, then return true

		*/

			int numNodes = nodes.size();
			for(int i = 0; i < numNodes; i++) {
				BinaryTreeNode currentRoot = nodes.get(i);
				int treeSize = 0;
				Queue<BinaryTreeNode> toVisit = new LinkedList<>();

				toVisit.add(currentRoot);
				while(toVisit.peek() != null) {
					BinaryTreeNode currentNode = toVisit.poll();
					treeSize++;

					if(currentNode.leftChild != null) {
						toVisit.add(currentNode.leftChild);	
					}
					if(currentNode.rightChild != null) {
						toVisit.add(currentNode.rightChild);	
					}
				}

				if(treeSize == numNodes) {
					return true;	
				}
			}

			return false;
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

		ArrayList<BinaryTreeNode> nodes = new ArrayList<BinaryTreeNode>();
		// nodes.add(new BinaryTreeNode(7, n3, null));	
		nodes.add(n1);
		nodes.add(n2);
		nodes.add(n3);
		nodes.add(n4);
		nodes.add(n5);
		nodes.add(n6);

		System.out.println(canFormTree(nodes));
	}
	
}
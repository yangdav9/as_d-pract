class bst {

	/* Node definition */
	static class Node {
		int value;
		Node left, right;

		Node (int d) {
			value = d;
			left = null;
			right = null;
		}
	}

	/* Variables */
	Node root;

	/* Methods */
	
	public static bst insert(bst b, int val) {
		b.root = insertHelp(b.root, val);
		return b;
	}

	public static Node insertHelp(Node root, int val) {

		//case empty
		if (root == null) {
			root = new Node(val);
			return root;
		} 
		
		if (root.value == val) return root;
		
		if (val > root.value) root.right = insertHelp(root.right,val);
		else root.left = insertHelp(root.left,val); 

		return root;
	}


	public static boolean search(bst b, int val) {
		return searchHelp(b.root, val);	
	}

	public static boolean searchHelp(Node root, int val) {
		if (root == null) {
			return false;
		}

		if (root.value == val) return true;

		if (val > root.value) return searchHelp(root.right,val);
		else return searchHelp(root.left,val);
	}


	public static bst delete(bst b, int val) {
		b.root = deleteHelp(b.root,val);
		return b;
	}

	public static Node deleteHelp(Node root, int val) {
		if (root == null) return null;
		
		//perform delete
		if (val == root.value) {
			if ((root.left == null) && (root.right == null)) { //delete leaf
				root = null;
			} else if ((root.left == null) && (root.right != null)) { //replace with successor, then delete
				root.value = successor(root, val);
				root.right = deleteHelp(root.right,root.value);
			} else if ((root.left != null) && (root.right == null)) { //replace with predecessor, then delete
				root.value = predecessor(root,val);
				root.left = deleteHelp(root.left,root.value);
			} else {  //replace with either successor or predecessor
				root.value = successor(root, val);
				root.right = deleteHelp(root.right,root.value);
			}
		} else if (val > root.value) { //search right subtree for value
			root.right = deleteHelp(root.right,val); 
		} else { //search left subtree for value
			root.left = deleteHelp(root.left,val);
		}
		return root;

	}

	//leftmost of right subtree
	public static int successor(Node root, int val) {
		Node subTree = root.right;

		while(subTree.left != null) subTree = subTree.left;
		
		return subTree.value;
	}

	//rightmost of left subtree
	public static int predecessor(Node root, int val) {
		Node subTree = root.left;

		while(subTree.right != null) subTree = subTree.right;

		return subTree.value;
	}



	public static void inOrderPrint(Node root) {
		if (root == null) return;

		inOrderPrint(root.left);
		System.out.println("Current node is: " + root.value);
		inOrderPrint(root.right);
	}

	public static void preOrderPrint(Node root) {
		if (root == null) return;

		System.out.println("Current node is: " + root.value);
		preOrderPrint(root.left);
		preOrderPrint(root.right);
	}

	public static void postOrderPrint(Node root) {
		if (root == null) return;
		postOrderPrint(root.left);
		postOrderPrint(root.right);
		System.out.println("Current node is: " + root.value);
	}

/*


*/


	public static void main(String[] args) {
		bst b = new bst();

		b = insert(b, 2);
		b = insert(b, -1);
		b = insert(b, 4);
		b = insert(b, -3);
		b = insert(b, -2);
		b = insert(b, 3);
		b = insert(b, 6);
		b = insert(b, 5);


		preOrderPrint(b.root);
		System.out.println("");

//		if (!search(b, 4)) System.out.println("4 not in tree");
//		if (search(b, 5)) System.out.println("5 in tree");

//		b = delete(b,4);
		b = delete(b,-1);
		preOrderPrint(b.root);

//		preOrderPrint(b.root);
//		postOrderPrint(b.root);

	}

}

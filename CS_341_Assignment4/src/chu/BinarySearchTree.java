package chu;

public class BinarySearchTree {
	
	private Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public void addNode(Node n) {
		addNode(root, n);
	}
	
	public void addNode(Node pointer, Node n) {
		if (pointer == null) {
			root = n;
		} else {
			
			while (true) {
				
				if (n.word.equals(pointer.word)) { //Word is already in tree
					return;
				} else if (n.word.compareTo(pointer.word) < 0) { //Word appears before alphabetically
					if (pointer.left == null) {
						pointer.left = n;
						return;
					}
					pointer = pointer.left;
					
				} else { //Word appears after alphabetically
					if (pointer.right == null) { 
						pointer.right = n;
						return;
					}
					pointer = pointer.right;
				}
			}
		}
	}
	
	/*
	public void addNodeR(Node n) {
		if (root == null) {
			root = n;
		} else {
			Node pointer = root;
			addNodecheckOrderRecursion(pointer, n);
		}
	}
	
	public void addNodecheckOrderRecursion(Node pointer, Node n) {
		if (n.word.compareTo(pointer.word) == 0) {
			
		} else if (n.word.compareTo(pointer.word) < 0) {
			if (pointer.left == null) {
				pointer.left = n;
			} else {
				addNodecheckOrderRecursion(pointer.left, n);
			}
			
		} else {
			if (pointer.right == null) {
				pointer.right = n;
			} else {
				addNodecheckOrderRecursion(pointer.right, n);
			}
		}
	}*/
	
	
	
	public boolean spellCheck(String word) {
		Node pointer = root;
		if (root != null) {
			while (true) {
				if (word.equals(pointer.word)) {
					return true;
				} else if (word.compareTo(pointer.word) < 0) {
					if (pointer.left == null) {
						return false;
					}
					pointer = pointer.left;
					
				} else {
					if (pointer.right == null) {
						return false;
					}
					pointer = pointer.right;
				}
			}
		}
		return false;
		
	}
	
	public void checkWord(String word) {
		if (word.equals(root.word)) {
			if (root.left == null && root.right == null) {
				root = null;
				
			} else if (root.right == null) {
				root = root.left;
				
			} else if (root.left == null) {
				root = root.right;
				
			} else {
				Node remains;
				if (Math.abs(root.word.compareTo(root.left.word)) <= Math.abs(root.word.compareTo(root.right.word))) {
					remains = root.right;
					root = root.left;
					
				} else {
					remains = root.left;
					root = root.right;
					
				}
				addNode(root, remains);
			}
			return;
			
		} else {
			
			Node pointer = root;
			while (pointer.left != null || pointer.right != null) {
				if (pointer.left != null && word.equals(pointer.left.word)) {
					takeOut(pointer, true);
					return;

				} else if (pointer.right != null && word.equals(pointer.right.word)) {
					takeOut(pointer, false);
					return;
					
				} else if (word.compareTo(pointer.word) < 0) {
					pointer = pointer.left;
				} else {
					pointer = pointer.right;
				}
			}
			
		}
		
	}
	
	private void takeOut(Node pointer, boolean isLeft) {
		Node takeout;
		if (isLeft) {
			takeout = pointer.left;
		} else {
			takeout = pointer.right;
		}
		
		
		if (takeout.left == null && takeout.right == null) {
			if (isLeft) {
				pointer.left = null;
			} else {
				pointer.right = null;
			}
			
		} else if (takeout.right == null) {
			if (isLeft) {
				pointer.left = takeout.left;
			} else {
				pointer.right = takeout.left;
			}

			
		} else if (takeout.left == null) {
			if (isLeft) {
				pointer.left = takeout.right;
			} else {
				pointer.right = takeout.right;
			}
			
			
		} else {
			Node remains;
			Node put;
			
			if (Math.abs(takeout.word.compareTo(takeout.left.word)) <= Math.abs(takeout.word.compareTo(takeout.right.word))) {
				remains = takeout.right;
				put = takeout.left;
			
			} else {
				remains = takeout.left;
				put = takeout.right;

			}
			
			if (isLeft) {
				pointer.left = put;
			} else {
				pointer.right = put;
			}

			
			if (pointer == null) {
				addNode(remains);
			} else {
				addNode(pointer, remains);
			}
			
		}
		
	}
	

	public Node getHead() {
		return root;
	}
	
	public void printTree() {
		System.out.print("\n\t");
		printTreeRecursion(root);
		System.out.println("\n");
	}
	
	private void printTreeRecursion(Node root) {
		if (root != null) {
			printTreeRecursion(root.left);
			System.out.print(root.word + ", ");
			printTreeRecursion(root.right);
		}
	}
	
}

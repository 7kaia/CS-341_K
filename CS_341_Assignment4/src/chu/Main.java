package chu;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();

		assert(!bst.spellCheck("apple")): "This should return false, the tree is empty";
		System.out.println("Test 1: nothing is removed from empty tree - Success");
		
		String str1 = "potato";
		bst.addNode(new Node(str1)); //add potato
		
		bst.printTree(); //PRINT TREE
		
		assert(bst.getHead() != null && bst.getHead().word.equals(str1)): "Root of binary tree is not equal to first node added";
		System.out.println("Test 2: \"potato\" is at root of the tree - Success");
		
		
		bst.addNode(new Node("eggs")); //add "eggs"
		bst.addNode(new Node("ice cream")); //add "ice cream"
		bst.addNode(new Node("steak")); //add "steak"
		bst.addNode(new Node("pork")); //add "pork"
		bst.addNode(new Node("apple")); //add "apple"
		
		bst.printTree(); //PRINT TREE
		
		assert(6 == checkCount(bst.getHead())): "Size is tree is not 6 when it should be";
		assert(checkOrder(bst.getHead())): "Order of the tree is not ascending";
		System.out.println("Test 3: Size of tree is 6, order of tree is ascending - Success");
		
		bst.addNode(new Node("chicken")); //add "chicken"
		
		bst.printTree(); //PRINT TREE
		
		assert(7 == checkCount(bst.getHead())): "Size is tree is not 7 when it should be";
		System.out.println("Test 4: Size of tree is 7 after adding \"chicken\" - Success");
		
		
		bst.addNode(new Node("chicken")); //add "chicken" for the 2nd time
		
		bst.printTree(); //PRINT TREE
		
		assert(7 == checkCount(bst.getHead())): "Size of tree should not have changed";
		assert(checkOrder(bst.getHead())): "Order of the tree is not ascending";
		System.out.println("Test 5: attempt to put \"chicken\", Size of tree didn't change and is still in ascending order - Success");
		
		bst.printTree(); //PRINT TREE
		
		assert(bst.spellCheck("eggs")): "Method should find 'eggs' and return true";
		System.out.println("Test 6: \"eggs\" was successfully found in tree - Success");
		
		bst.printTree(); //PRINT TREE
		
		assert(!bst.spellCheck("chocolate")): "Method should not find 'chocolate' and return false";
		System.out.println("Test 7: \"chocolate\" was not found in tree - Success");
		
		bst.checkWord("chocolate"); // try to remove the word "chocolate"
		
		bst.printTree(); //PRINT TREE
		
		assert(7 == checkCount(bst.getHead())): "Nothing should've been removed from the tree here";
		System.out.println("Test 8: attempt to remove \"chocolate\", no node was removed - Success");
		
		
		bst.checkWord("ice cream"); //remove "ice cream"
		//System.out.println(checkCount(bst.getHead()));
		//System.out.println(checkOrder(bst.getHead()));
		
		bst.printTree(); //PRINT TREE
		
		assert(6 == checkCount(bst.getHead())): "Only 'ice cream' should've been removed";
		assert(checkOrder(bst.getHead())): "Order of the tree is not ascending";
		System.out.println("Test 9: \"ice cream\" was removed (1 child node), its child nodes unaffected - Success");
		
		bst.checkWord("potato"); //remove "potato", the root
		
		bst.printTree(); //PRINT TREE
		
		assert(5 == checkCount(bst.getHead())): "Only 'potato' should've been removed";
		assert(checkOrder(bst.getHead())): "Order of the tree is not ascending";
		System.out.println("Test 10: root node \"potato\" was removed, its child nodes unaffected - Success");
		
		bst.printTree(); //PRINT TREE
		
		assert(bst.getHead().word.equals("steak")): "New root should've been set to 'steak'";
		System.out.println("Test 11: new root node is \"steak\" - Success");
		
		bst.addNode(new Node("honey")); //add "honey"
		bst.addNode(new Node("lamb")); //add "lamb"
		bst.addNode(new Node("chili")); //add "chili"
		
		bst.printTree(); //PRINT TREE
		
		bst.checkWord("chili"); //remove "chili"
		
		bst.printTree(); //PRINT TREE
		
		assert(7 == checkCount(bst.getHead())): "Only 'honey' should've been removed";
		assert(checkOrder(bst.getHead())): "Order of the tree is not ascending";
		System.out.println("Test 12: \"chili\" was removed (no child nodes) - Success");
		
		
		bst.checkWord("eggs"); //remove "eggs"
		
		bst.printTree(); //PRINT TREE
		
		assert(6 == checkCount(bst.getHead())): "Only 'eggs' should've been removed";
		assert(checkOrder(bst.getHead())): "Order of the tree is not ascending";
		System.out.println("Test 13: \"eggs\" was removed (2 child nodes) - Success");
		
		
		
		
		
	}
	
	//ASSERT METHODS
		private static boolean checkOrder(Node root) {
			ArrayList<String> list = new ArrayList<String>();
			checkRecursion(root, list);
			
			for (int i = 0; i < list.size()-1; i++) {
				if (list.get(i).compareTo(list.get(i+1)) >= 0) {
					return false;
				}
			}
			return true;
			
		}
		
		private static void checkRecursion(Node root, ArrayList<String> list) {
			if (root != null) {
				checkRecursion(root.left, list);
				list.add(root.word);
				checkRecursion(root.right, list);
			}
		}
		
		
		private static int checkCount(Node root) {
			ArrayList<String> list = new ArrayList<String>();
			checkRecursion(root, list);
			return list.size();
		}
		
}

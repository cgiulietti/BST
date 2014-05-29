package BinarySearchTree;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class BSTTest {

	@Test
	public void testLookup() {
	  BST<Integer> tree = new BST<Integer>();
	      
      tree.insert(8);
      tree.insert(10);
      tree.insert(6);
      tree.insert(15);
      tree.insert(60);
      tree.insert(1);
      tree.insert(3);
      tree.insert(4);
      tree.insert(5);
      tree.insert(2);
      tree.insert(3);
      tree.insert(7);
      tree.insert(12);
      tree.insert(10);
      
      assertEquals(tree.lookup(4),true);
      assertEquals(tree.lookup(44),false);
      assertEquals(tree.lookup(1),true);
      assertEquals(tree.lookup(60),true);
      assertEquals(tree.lookup(80),false);
      assertEquals(tree.lookup(33),false);
      assertEquals(tree.lookup(900),false);
	}
	
	@Test
	public void testInOrderTaversal() {
	  BST<Integer> tree = new BST<Integer>();
	  ArrayList<Integer> sol = new ArrayList<Integer>();
	      
      tree.insert(8);
      tree.insert(10);
      tree.insert(6);
      tree.insert(15);
      tree.insert(60);
      tree.insert(1);
      tree.insert(3);
      tree.insert(4);
      tree.insert(5);
      tree.insert(2);
      tree.insert(3);
      tree.insert(7);
      tree.insert(12);
      tree.insert(10);
      
      sol.add(1);
      sol.add(2);
      sol.add(3);
      sol.add(4);
      sol.add(5);
      sol.add(6);
      sol.add(7);
      sol.add(8);
      sol.add(10);
      sol.add(12);
      sol.add(15);
      sol.add(60);
      
      assertEquals(tree.printInOrder(),sol);
	}
	
	@Test
	public void testPostOrderTaversal() {
	  BST<Integer> tree = new BST<Integer>();
	  ArrayList<Integer> sol = new ArrayList<Integer>();
	      
      tree.insert(8);
      tree.insert(10);
      tree.insert(6);
      tree.insert(15);
      tree.insert(60);
      tree.insert(1);
      tree.insert(3);
      tree.insert(4);
      tree.insert(5);
      tree.insert(2);
      tree.insert(3);
      tree.insert(7);
      tree.insert(12);
      tree.insert(10);
      
      sol.add(2);
      sol.add(5);
      sol.add(4);
      sol.add(3);
      sol.add(1);
      sol.add(7);
      sol.add(6);
      sol.add(12);
      sol.add(60);
      sol.add(15);
      sol.add(10);
      sol.add(8);
      
      assertEquals(tree.printPostOrder(),sol);
	}
	
	@Test
	public void testPreOrderTaversal() {
	  BST<Integer> tree = new BST<Integer>();
	  ArrayList<Integer> sol = new ArrayList<Integer>();
	      
      tree.insert(8);
      tree.insert(10);
      tree.insert(6);
      tree.insert(15);
      tree.insert(60);
      tree.insert(1);
      tree.insert(3);
      tree.insert(4);
      tree.insert(5);
      tree.insert(2);
      tree.insert(3);
      tree.insert(7);
      tree.insert(12);
      tree.insert(10);
      
      sol.add(8);
      sol.add(6);
      sol.add(1);
      sol.add(3);
      sol.add(2);
      sol.add(4);
      sol.add(5);
      sol.add(7);
      sol.add(10);
      sol.add(15);
      sol.add(12);
      sol.add(60);
      
      assertEquals(tree.printPreOrder(),sol);
	}
	
	@Test
	public void testDelete() {
	  BST<Integer> tree = new BST<Integer>();
	  ArrayList<Integer> sol = new ArrayList<Integer>();
	      
      tree.insert(8);
      tree.insert(10);
      tree.insert(6);
      tree.insert(15);
      tree.insert(60);
      tree.insert(1);
      tree.insert(3);
      tree.insert(4);
      tree.insert(5);
      tree.insert(2);
      tree.insert(3);
      tree.insert(7);
      tree.insert(12);
      tree.insert(10);
      
      sol.add(1);
      sol.add(2);
      sol.add(3);
      sol.add(5);
      sol.add(7);
      sol.add(8);
      sol.add(10);
      sol.add(12);
      sol.add(15);
      sol.add(60);
      
      tree.delete(6);
      tree.delete(4);
      assertEquals(tree.printInOrder(),sol);
      
      tree.delete(2);
      tree.insert(60);
      tree.insert(30);
      tree.delete(10);
      tree.insert(28);
      
      sol.clear();
      sol.add(1);
      sol.add(3);
      sol.add(5);
      sol.add(7);
      sol.add(8);
      sol.add(12);
      sol.add(15);
      sol.add(28);
      sol.add(30);
      sol.add(60);
      
      assertEquals(tree.printInOrder(),sol);
      
	}
	
	@Test
	public void testIsBST() {
		/*    50
		 *   /  \
			20	 90
		   /  \
		  9   25 
		  	 /  \
		    22  55
		  	   /  \
		  	  28  57
		*/
		BST.Node<Integer> n1 = new BST.Node(57,null,null);
		BST.Node<Integer> n2 = new BST.Node(28,null,null);
		BST.Node<Integer> n3 = new BST.Node(55,n2,n1);
		BST.Node<Integer> n4 = new BST.Node(22,null,null);
		BST.Node<Integer> n5 = new BST.Node(25,n4,n3);
		BST.Node<Integer> n6 = new BST.Node(9,null,null);
		BST.Node<Integer> n7 = new BST.Node(20,n6,n5);
		BST.Node<Integer> n8 = new BST.Node(90,null,null);
		BST.Node<Integer> root = new BST.Node(50,n7,n8);
		
		assertEquals(BST.isBST(root),false);
	}
	
	@Test
	public void testIsBST2() {
		/*    50
		 *   /  \
			20	 90
		   /  \
		  9   25 
		  	 /  \
		    22  30
		  	   /  \
		  	  28  35
		*/
		BST.Node<Integer> n1 = new BST.Node(35,null,null);
		BST.Node<Integer> n2 = new BST.Node(28,null,null);
		BST.Node<Integer> n3 = new BST.Node(30,n2,n1);
		BST.Node<Integer> n4 = new BST.Node(22,null,null);
		BST.Node<Integer> n5 = new BST.Node(25,n4,n3);
		BST.Node<Integer> n6 = new BST.Node(9,null,null);
		BST.Node<Integer> n7 = new BST.Node(20,n6,n5);
		BST.Node<Integer> n8 = new BST.Node(90,null,null);
		BST.Node<Integer> root = new BST.Node(50,n7,n8);
		
		assertEquals(BST.isBST(root),true);
	}
	
	@Test
	public void testIsBST3() {
		/*    50
		 *   /  \
			20	 90
		   /  \
		  9   25 
		  	 /  \
		    22  23
		  	   /  \
		  	  22  35
		*/
		BST.Node<Integer> n1 = new BST.Node(35,null,null);
		BST.Node<Integer> n2 = new BST.Node(22,null,null);
		BST.Node<Integer> n3 = new BST.Node(23,n2,n1);
		BST.Node<Integer> n4 = new BST.Node(22,null,null);
		BST.Node<Integer> n5 = new BST.Node(25,n4,n3);
		BST.Node<Integer> n6 = new BST.Node(9,null,null);
		BST.Node<Integer> n7 = new BST.Node(20,n6,n5);
		BST.Node<Integer> n8 = new BST.Node(90,null,null);
		BST.Node<Integer> root = new BST.Node(50,n7,n8);
		
		assertEquals(BST.isBST(root),false);
	}

	@Test
	public void testIsBST4() {
		/*    50
		 *   /  \
			20	 90
		   /  \
		  9   25 
		  	 /  \
		    10  30
		  	   /  \
		  	  28  35
		*/
		BST.Node<Integer> n1 = new BST.Node(57,null,null);
		BST.Node<Integer> n2 = new BST.Node(28,null,null);
		BST.Node<Integer> n3 = new BST.Node(55,n2,n1);
		BST.Node<Integer> n4 = new BST.Node(10,null,null);
		BST.Node<Integer> n5 = new BST.Node(25,n4,n3);
		BST.Node<Integer> n6 = new BST.Node(9,null,null);
		BST.Node<Integer> n7 = new BST.Node(20,n6,n5);
		BST.Node<Integer> n8 = new BST.Node(90,null,null);
		BST.Node<Integer> root = new BST.Node(50,n7,n8);
		
		assertEquals(BST.isBST(root),false);
	}
	
	@Test
	public void testIsBST5() {
		/*    50
		 *   /    \
			20	    90
		   /  \    /
		  9   25  49  
		  	 /  \
		    22  30
		  	   /  \
		  	  28  35
		*/
		BST.Node<Integer> n1 = new BST.Node(57,null,null);
		BST.Node<Integer> n2 = new BST.Node(28,null,null);
		BST.Node<Integer> n3 = new BST.Node(55,n2,n1);
		BST.Node<Integer> n4 = new BST.Node(10,null,null);
		BST.Node<Integer> n5 = new BST.Node(25,n4,n3);
		BST.Node<Integer> n6 = new BST.Node(9,null,null);
		BST.Node<Integer> n7 = new BST.Node(20,n6,n5);
		BST.Node<Integer> n8 = new BST.Node(49,null,null);
		BST.Node<Integer> n9 = new BST.Node(90,n8,null);
		BST.Node<Integer> root = new BST.Node(50,n7,n9);
		
		assertEquals(BST.isBST(root),false);
	}
	
	@Test
	public void testIsBST6() {
		/*    50
		 *   /    \
			20	    90
		   /  \    /
		  9   25  70  
		  	 /  \   \
		    22  30  100
		  	   /  \
		  	  28  35
		*/
		BST.Node<Integer> n1 = new BST.Node(57,null,null);
		BST.Node<Integer> n2 = new BST.Node(28,null,null);
		BST.Node<Integer> n3 = new BST.Node(55,n2,n1);
		BST.Node<Integer> n4 = new BST.Node(10,null,null);
		BST.Node<Integer> n5 = new BST.Node(25,n4,n3);
		BST.Node<Integer> n6 = new BST.Node(9,null,null);
		BST.Node<Integer> n7 = new BST.Node(20,n6,n5);
		BST.Node<Integer> n8 = new BST.Node(100,null,null);
		BST.Node<Integer> n9 = new BST.Node(70,null,n8);
		BST.Node<Integer> n10 = new BST.Node(90,n9,null);
		BST.Node<Integer> root = new BST.Node(50,n7,n10);
		
		assertEquals(BST.isBST(root),false);
	}
}

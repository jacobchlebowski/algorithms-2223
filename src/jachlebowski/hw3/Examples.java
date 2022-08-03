package jachlebowski.hw3;

import static org.junit.Assert.*;

import org.junit.Test;

public class Examples {

	@Test
	public void test() {
		
		Comparable[] trueArray = {1,2,3,4,5};
		Comparable[] falseArray= {10,2,3,4,50,6,7,8,9};
		assertTrue(Q1.isSorted(trueArray));
		assertFalse(Q1.isSorted(falseArray));
		
//		
//		BST bst = new BST();
//		BST copy = bst.copy();
//		assertEquals(bst,copy);
//		
		
		Q4 q4 = new Q4();
		q4.AVL();
	}
	
	
	
	
}

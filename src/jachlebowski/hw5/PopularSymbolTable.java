package jachlebowski.hw5;

import algs.days.day18.AVL;
import algs.days.day18.TreeMap;
// use any classes you want from Sedgewick
import edu.princeton.cs.algs4.*;

/**
 * Your goal is to maintain a set of (key, value) pairs like a symbol table, with some
 * enhanced behavior.
 * 
 * For simplicity, each key is just an 'Integer' and each value is also an 'Integer'.
 * Aside from this limitation, the key (or value) can be any 32-bit integer, including
 * negative numbers.
 *  
 * You can 'put(key, value)' or 'get(key)' or 'remove(key)' as expected for a symbol table.
 * These should all execute with performance no worse than O(log N). You need to know the
 * size of the table and be ready to return size on demand in O(1) time.
 * 
 * In addition:
 * 
 * 1. 'get(key)' returns the value associated with key. This must (in worst case) perform in O(log N).
 *     If no key is in the symbol table, then null is returned.
 * 
 * 2. 'put(key, value)' associated the given value with the key. This must (in worst case) perform in O(log N).
 *     This method returns true when adding the key for the first time, otherwise it returns false when 
 *     simply replacing the value associated with the key.
 * 
 * 3. 'reverseMatch(value)' -- returns an Iterable containing in ascending order all keys that map to a given value.
 *     Note that this is the reverse of symbol table. 
 *     
 *     To receive full credit, the performance of this operation must be O(K + log N) where K is 
 *     the number of keys that map to the given value. If the number of keys that map is independent 
 *     of N, then in the best case this takes O(log N) time. 
 *     
 *     If none of the keys map to this value, then an empty Iterable is returned (never null).
 *     
 *     Note K <= N in all cases. If, in fact, all keys in the symbol table map to the same value,
 *     then performance is O(N) since K=N.
 *     
 * 4. 'remove(key)' -- removes the (key, value) pair if it exists. Note that if the key does not exist,
 *     then false is returned, otherwise true is returned.
 * 
 */
public class PopularSymbolTable {
	TreeMap<Integer,Integer> tm;  //st
	LinearProbingHashST<Integer,AVL<Integer>> linear; //tracker
	int n; //size
	
	public PopularSymbolTable () {
		//this.n;
		tm = new TreeMap<Integer,Integer>();
		linear = new LinearProbingHashST<Integer,AVL<Integer>>();
	}
	
	
	
	
	
	/** Return number of (key, value) pairs in the table. Performance must be O(1). */
	public int size() {
		return n;
	}
	
	/** Might return an empty Queue object. */
	public Queue<Integer> reverseMatch(Integer value) { 
		System.out.println("reverseMatch check");
		Queue<Integer> queue = new Queue<Integer>();
		AVL<Integer> avl = linear.get(value);
		if(avl != null) {
			Iterable<Integer> iterable = avl.keys();
			for(Integer i : iterable) {
				queue.enqueue(i);
			}
		}
		return queue;
	}
	
	
	
	
	/** Return value associated with key. */
	public Integer get(Integer key) {
		System.out.println("get check");
		return tm.get(key);
	}
	
	
	
	
	
	/**
	 * Return true if the key was newly added to the collection.
	 */
	public boolean put (Integer key, Integer value) {
		System.out.println("put check");
		Integer put = tm.put(key, value);
		if(linear.contains(value)) {
			linear.get(value).insert(key);
		}
		else {
			linear.put(value, new AVL<Integer>());
			linear.get(value).insert(key);
		}
		if(put==null) {
			n =n +1;
			return true; //true if its new key
		}
		else {
			linear.get(put).fastDelete(key); //delete
			return false;  //return false if already exists
		}
	}
	
	/**
	 * Return true if the key was removed.
	 */
	public boolean remove (Integer key) {
		System.out.println("remove check");
		Integer remove = tm.remove(key);
		if(remove==null) {
			n=n-1;
			return true; //removed
		}
		if(key==98765) {
			System.out.println("what");
			return true;
		}
		else {
			linear.get(remove).fastDelete(key);
			return false; //not removed
		}
	}
	
}

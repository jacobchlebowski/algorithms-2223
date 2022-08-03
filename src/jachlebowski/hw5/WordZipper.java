package jachlebowski.hw5;

import java.io.FileNotFoundException;
import java.util.Scanner;

// use any classes from Sedgewick...
import edu.princeton.cs.algs4.*;
import jachlebowski.hw4.Q2;
// Note that the Day18 implementation of AVL removes <Key,Value> and only uses <Key>
import algs.days.day18.AVL;
import algs.hw5.Dictionary;

/**
 * Copy this class into your project area and modify it for problem 1 on HW5.
 */
public class WordZipper {

	/**
	 * Represent the mapping of (uniqueID, 3- and 4-letter words) from String <-> Integer where Integer is vertex id
	 */
	static SeparateChainingHashST<String,Integer> map = new SeparateChainingHashST<String,Integer>();
	static SeparateChainingHashST<Integer,String> reverse = new SeparateChainingHashST<Integer,String>();

	/** Store all three-letter and four-letter words (in lowercase). */
	static AVL<String> avl; 
	
	/**
	 * Return a Queue of words that result by adding a single letter to the three letter word.
	 * 
	 * There are 4*26 possible words that could result by adding a single letter (a-z) at each of the 
	 * four possible spots
	 * 
	 *      E A T
	 *      
	 *     SEAT
	 *      ERAT
	 *       EAST
	 *        EATS
	 *        
	 * It is acceptable for this method to return duplicates in the queue.
	 * 
	 * For example, if the word is "BET" then it could include in its response
	 * "BEET" (where the E is inserted between the B and E) and "BEET" (where
	 * the E is inserted between the E and the T).
	 */
	public static Queue<String> addOne(String three) {
		//for loop from 0-2 to iterate through all letters
		//for loop 0-26 for each letter in alphabet
		//make all words, check map to make sure word is valid
		//add it to queue , and return queue
		Queue<String> queue = new Queue<String>();
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<27;j++) {
				char newChar = (char)('a' + j);
				String word = three.substring(0, i) + newChar + three.substring(i);
				if(map.contains(word)) {
					queue.enqueue(word);
				}
			}
		}
		return queue;
	}

	/**
	 * Return valid words by removing one of the four letters.
	 * 
	 * It is acceptable for this method to return duplicates in the queue.
	 * For example, if the word is 'BEET' then the words returned could 
	 * be {"BEE", "BET", "BET"}
	 */
	public static Queue<String> removeOne(String four) {
		Queue<String> queue = new Queue<String>();
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<27;j++) {
			    StringBuilder sb = new StringBuilder(four);
			    sb.deleteCharAt(i);
			    String word = sb.toString();
				if(map.contains(word)) {
					queue.enqueue(word);
				}
			}
		}
		return queue;
	}
	
	
	
	
	/**
	 * Main method to execute.
	 *
	 * From console, enter the start and end of the word ladder.
	 */
	public static void main(String[] args) throws FileNotFoundException {

		// Use this to contain all three- and four-letter words that you find in dictionary
		avl = new AVL<String>();
		
		// Construct AVL tree of all three- and four-letter words.
		// Note: you will have to copy this file into your project to access it.
		Scanner sc = Dictionary.words();
		int i=0;
		while(sc.hasNext()) {
			String word = sc.next();
			if(word.length()==3||word.length()==4) {
			avl.insert(word);
			map.put(word, i);
			reverse.put(i, word);
			i++;
			}
		}
		// now construct graph, where each node represents a word, and an edge exists between
		// two nodes if their respective words are off by a single letter. Hint: use the
		// keys() method provided by the AVL tree. Your graph will be an undirected graph.
		
		// TODO: FILL IN HERE
		Graph G = new Graph(map.size());
				for(String j : avl.keys()) {
					if(j.length()==4) {
						Queue<String> RO = removeOne(j); //gives back queue of 3 letter words - iterate until there's none left
						while(!RO.isEmpty()) {
							G.addEdge(map.get(j), map.get(RO.dequeue()));
						}
					
					}
					if(j.length()==3) {
						Queue<String> AO = addOne(j); //gives back 4 letter words
						while(!AO.isEmpty()) {
						G.addEdge(map.get(j), map.get(AO.dequeue()));
						}
				}
			}
		
		
		sc.close();  // once done, you can close this resource.
		
		// this loop will complete when the user enters in a non-word.
		while (true) {
			StdOut.println("Enter word to start from (all in lower case):");
			String start = StdIn.readString().toLowerCase();
			StdOut.println("Enter word to end at (all in lower case):");
			String end = StdIn.readString().toLowerCase();
	
			// need to validate that these are both actual four-letter words in the dictionary
			if (!avl.contains(start)) {
				StdOut.println (start + " is not a valid word in the dictionary.");
				System.exit(-1);
			}
			if (!avl.contains(end)) {
				StdOut.println (end + " is not a valid word in the dictionary.");
				System.exit(-1);
			}
	
			// Once both words are known to exist in the dictionary, then create a search
			// that finds shortest distance (should it exist) between start and end.
			// be sure to output the words in the word zipper, IN ORDER, from the start to end.
			// IF there is no word zipper possible, then output "NONE POSSIBLE."
			
			BreadthFirstPaths bfs = new BreadthFirstPaths(G,map.get(start));
			
			//nine - ten
			if(bfs.hasPathTo(map.get(end))) {
				for(int id : bfs.pathTo(map.get(end))) {
					System.out.println(reverse.get(id));
				 }
			}
			else {System.out.println("NONE POSSIBLE");}
			
		}
		
	}
}

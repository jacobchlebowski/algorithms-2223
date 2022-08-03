package jachlebowski.hw1;

import algs.hw1.*;
import algs.hw1.api.*;

/**
 * Copy this class into your USERID.hw1 package and improve this implementation.
 * 
 * NOTE: The runtime results for this implementation appear in Q4 for
 * this homework assignment.
 */
public class HeisenbergFinder implements IHeisenbergFinder {

	/** 
	 * Replace this inefficient function with something more efficient.
	 * 
	 * You can inspect the contents of the array for h using inspect() method.
	 */
	
	
	//1*N is in ascending order
	//Inspect Middle... (is target bigger than? less than?)
	//Int numMoves... Inspect element at any index plus or minus num of moves?
	
	public int find(Heisenberg h, int target) { 
		
		int max=h.N-1;
		int min=0;
		int mid = (int)Math.floor(max/2);
		int i=0;
		
		while(min<=max) {
			int inspect = h.inspect(mid);
				if (target+i < inspect) {
					max=mid-1;
					mid=(int)Math.floor((max-min)/2);
					i--;
				}
				
				else if(target+i > inspect) {
					min=mid+1;
					mid=(int)Math.floor(min+(max-min)/2);
					i++;
				}
				else if(target+i==inspect) {
					return mid;
			}
		}
		return -1;
	}
	



	
	
	
	
	
	
	// You do not need to modify below this line.
	// ------------------------------------------
	public static void main(String[] args) {
		for (int i = 1; i < 20; i++) {
			Heisenberg h = new Heisenberg(i, 99);
			int numProbes = h.solver(new HeisenbergFinder());
			System.out.println(i + "\t" + numProbes);
		}
		System.out.println();
		
		for (int i = 3; i < 257; i=2*i+1) {
			Heisenberg h = new Heisenberg(i, 99);
			int numProbes = h.solver(new HeisenbergFinder());
			System.out.println(i + "\t" + numProbes);
		}
	}
}

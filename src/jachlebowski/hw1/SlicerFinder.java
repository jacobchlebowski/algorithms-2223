package jachlebowski.hw1;

import algs.hw1.*;
import algs.hw1.api.*;

/**
 * Copy this class into your project and complete its implementation
 */
public class SlicerFinder implements ISlicerFinder {

	/**
	 * Complete this implementation.
	 * 
	 * You can inspect the contents of the array for s using the inLeft() and
	 * inTop() methods.
	 */
	
	//method completed in office hours
	public Coordinate find(Slicer s, int target) {
		//find column where target exists
		for(int c=0;c<s.N;c++) {
			if(s.inLeft(c,target)) {
				//found column portion for COORDINATE
				//next is to find the row WHILE we have the column!
				for(int r=0;r<s.N;r++) {
					if(s.inTop(r, target)) {
						//found row portion for COORDINATE
						return new Coordinate(r,c);
					}
				}
			}
		}
		return null; //IF TARGET VALUE DOES NOT EXIST
	}
	
	
	

	// You do not need to modify below this line.
	// ------------------------------------------
	public static void main(String[] args) {
		for (int i = 1; i < 20; i++) {
			Slicer s = new Slicer(i, 99);
			s.solver(new SlicerFinder());

			System.out.println(i + "\t" + s.getNumProbes());
		}
		System.out.println();

		for (int n = 1; n < 65; n *= 2) {
			Slicer s = new Slicer(n, 99);
			int numProbes = s.solver(new SlicerFinder());
			System.out.println(n + "\t" + numProbes);
		}
	}
}

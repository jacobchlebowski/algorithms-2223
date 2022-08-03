package jachlebowski.hw1;

import algs.hw1.*;
import algs.hw1.api.*;

public class ManhattanSquareFinder implements IManhattanSquareFinder {

	/**
	 * Return the Coordinate of location in ManhattanSquare containing target.
	 * 
	 * You can inspect the contents of the array for ms using the distance() method.
	 */
		
	public Coordinate find(ManhattanSquare ms, int target) {
	for(int r=0; r<ms.N;r++) {
		for(int c=0;c<ms.N;c++) {
			if((ms.distance(r, c, target))>0) {/*do nothing*/}
			else if((ms.distance(r, c, target))==0) {
				Coordinate coordinates = new Coordinate(r,c);
				return coordinates;
			}
		}
	}
	return null;
}
	// You do not need to modify below this line.
	// ------------------------------------------
	public static void main(String[] args) {
		for (int n = 1; n < 15; n++) {
			ManhattanSquare ms = new ManhattanSquare(n, 99);
			int numProbes = ms.solver(new ManhattanSquareFinder());
			System.out.println(n + "\t" + numProbes);
		}
	}
}

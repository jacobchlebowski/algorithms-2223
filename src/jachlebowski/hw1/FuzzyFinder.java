package jachlebowski.hw1;

import algs.hw1.*;
import algs.hw1.api.*;

/**
 * Copy this class into your USERID.hw1 package and complete it.
 */
public class FuzzyFinder implements IFuzzySquareFinder {

	/**
	 * Return the Coordinate(r,c) where target exists. If it is not in 
	 * the 2D array, return null.
	 * 
	 * You can inspect the contents of the array for fs using the probe3x3() method.
	 */
	public Coordinate find(FuzzySquare fs, int target) {
		
		//start at r=1,c=1
		//check each r and c's 3x3
		//if value is NOT present, do nothing
		
		//if value is present in 3x3, search each r,c around it 
		//(if they both have the target value within proximity, the value is there)
		
		int notFound=0;
		
		for(int c=1;c<fs.N;c++) {
			for(int r=1;r<fs.N;r++) {
	
			notFound=(fs.probe3x3(r, c, target));
				
				//if NOT found
				if((notFound==5)){return null;}
				
				
				//if found
				if(notFound==0) {
					if(fs.probe3x3(r, c+1, target)!=0) {c=c-1;}  //if target is NOT in next column, that means its in current column
					else if(fs.probe3x3(r, c+2, target)!=0) {/*c stays the same*/}  //if target is NOT in next two columns over, c
					else {c=c+1;}
					
					if(fs.probe3x3(r+1, c, target)!=0) {r=r-1;}  
					else if(fs.probe3x3(r+2, c, target)!=0) {/*r stays the same*/}
					else {r=r+1;}
					
					return new Coordinate(r,c);
				}
				
			
				
			}
		}
		return null;
	}

	// You do not need to modify below this line.
	// ------------------------------------------
	public static void main(String[] args) {
		for (int i = 5; i < 40; i++) {
			FuzzySquare fs = new FuzzySquare(i, 99);
			fs.solver(new FuzzyFinder());
			System.out.println(i + "\t" + fs.getNumProbes());
		}
	}
}

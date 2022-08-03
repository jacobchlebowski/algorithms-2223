package jachlebowski.hw3;
import algs.days.day17.BST;
import algs.days.day18.AVL;
import edu.princeton.cs.algs4.StdRandom;

public class Q4 {

	public void AVL(){
		
		
		//RUN IN Examples.java FOR FULL TABLE
		
		int largest=0;
		int newLargest=0;
		int count =0;
		System.out.println("N\t\t LargestHeight\t\t Number Found");
		for(int N=1;N<=40;N++) {
			count =0;
			//10k for loop
			for (int i = 0; i < 10000; i++) {
			AVL<Double> avl = new AVL<Double>();
			
				//for each N
				for(int j=1;j<=N;j++) {
					double r = StdRandom.uniform(N);   // random value between 0 and 40.
					avl.insert(r);
				}
				if(avl.height()>=newLargest) {newLargest=avl.height();
				count++;}
				largest = avl.height();
			}
			
			
			//print
			System.out.println(N + "\t" + "\t\t" + largest + "\t\t" + count);
		}
		
		

	}
}

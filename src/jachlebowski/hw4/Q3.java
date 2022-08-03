package jachlebowski.hw4;

import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;

/**
 * How many random directed graphs of V vertices have a cycle?
 * 
 * Create a random graph by adding an edge between two vertices u and v with a probability
 * of 50%
 */
public class Q3 {
	public static void main(String[] args) {
		
		int sumDC = 0;
		int connected=0;
		System.out.println("Graphs with probability 0.5");
		System.out.println("N\t" + "#Cycles\t\t" + "#Connected\t");
		for(int N=2;N<15;N++) {
			sumDC = 0;
			connected=0;
			for(int i=0;i<=10000;i++) {
			Digraph dg = new Digraph(N);
			
			
				//for each N
				for(int u=0;u<N;u++) {
					for(int v=0; v<N;v++) {
						if(Math.random()<0.5 && (u!=v)) {
							dg.addEdge(u,v);
						}
					}
				}
				
				DirectedCycle dc = new DirectedCycle(dg);
				if(dc.hasCycle()) {
					sumDC++;
				}
				
				BreadthFirstDirectedPaths bfs = new BreadthFirstDirectedPaths(dg,0);
				for(int p=1; p<dg.V();p++) {
					if(!(bfs.hasPathTo(p))) {
						break;
					}
					if(bfs.hasPathTo(p)&&(p==dg.V()-1)) {
						connected++;
					}
				}
		}
		System.out.println(N + "\t" + sumDC + "\t\t" + connected);
	}
		
	
		
		
		int sumDC2 = 0;
		int connected2=0;
		System.out.println("\n\nGraphs with probability 1/N");
		System.out.println("N\t" + "#Cycles\t\t" + "#Connected\t");
		for(int N=2;N<15;N++) {
			sumDC2 = 0;
			connected2=0;
			for(int i=0;i<=10000;i++) {
			Digraph dg = new Digraph(N);
			
			
				//for each N
				for(int u=0;u<N;u++) {
					for(int v=0; v<N;v++) {
						if(Math.random()<1.0/N && (u!=v)) {
							dg.addEdge(u,v);
						}
					}
				}
				
				DirectedCycle dc = new DirectedCycle(dg);
				if(dc.hasCycle()) {
					sumDC2++;
				}
				
				BreadthFirstDirectedPaths bfs = new BreadthFirstDirectedPaths(dg,0);
				for(int p=0; p<dg.V();p++) {
					if(!(bfs.hasPathTo(p))) {
						break;
					}
					if(bfs.hasPathTo(p)&&(p==dg.V()-1)) {
						connected2++;
					}
				}
		}
		System.out.println(N + "\t" + sumDC2 + "\t\t" + connected2);
	}
		
		
	}
}

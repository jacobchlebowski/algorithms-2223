package jachlebowski.hw5;

import java.util.Iterator;

import algs.days.day26.FloydWarshallUndirected;
import algs.hw4.map.GPS;
import algs.hw5.FloydWarshallSolutionAnimation;
import algs.hw5.map.HighwayMapWeighted;
import algs.hw5.map.WeightedInformation;
import edu.princeton.cs.algs4.EdgeWeightedGraph;

/**
 * Question 2 of Homework 5.
 * 
 * Given the Massachusetts highway map data, find two vertices in the graph such
 * that the shortest distance between them is greater than any other pair of
 * vertices in the graph.
 * 
 * In other words, can you find two locations in Massachusetts such that using
 * the available map data, you’ve computed the shortest total distance in terms
 * of accumulated mileage, and no other pair of vertices demands a longer trip.
 */
public class Q2 {
	public static void main(String[] args) {
		WeightedInformation info = HighwayMapWeighted.undirectedGraph();
		EdgeWeightedGraph graph = info.ewgraph;
		
		System.out.println("Computing Floyd-Warshall: This might take up to a minute...");
		FloydWarshallUndirected fw = new FloydWarshallUndirected(graph);
		System.out.println("done");

		// THIS IS WHERE YOU MUST DO SOME WORK TO DETERMINE TWO VERTICES
		double highestMiles=0;
		int v1 = 0;
		int v2 = 0;
		
		for (int i = 0; i < graph.V(); i++) {
			for (int j = 0; j < graph.V(); j++) {
				double distance=0;
				Iterator<Integer> p = fw.shortestPath(i, j).iterator();
				boolean firstTime = true;
				int posPrev = 0;
				while(p.hasNext()) {
		
					int posCurrent = p.next();
					if(firstTime==false) {
						distance = info.positions.get(posCurrent).distance(info.positions.get(posPrev)) + distance;
					}
					firstTime=false;
					posPrev = posCurrent;
			}
				
				if(highestMiles<distance) {
					highestMiles=distance;
					v1=i;
					v2=j;
			}
		}
	}
		// THAT HAVE THE GREATEST OF THE SHORTEST DISTANCES.
		
		// To visually animate the solution, properly use integer vertex endpoints. You know this is 
		// right when you see it!
		System.out.println(highestMiles);
		System.out.println("vertex1 is " + v1 + " "  + info.labels.get(v1) + " @ " + info.positions.get(v1));
		System.out.println("vertex2 is " + v2 + " "  + info.labels.get(v2) + " @ " + info.positions.get(v2));
		new FloydWarshallSolutionAnimation(fw).launch(v1, v2);
		
		
	}
}

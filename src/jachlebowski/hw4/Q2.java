package jachlebowski.hw4;

import algs.days.day21.BreadthFirstPaths;
import algs.days.day20.*;
import algs.hw4.map.*;
import edu.princeton.cs.algs4.Graph;

/**
 * The goal of this question is to:
 * 
 * 1. Find the western-most location in Massachusetts
 * 2. Find the eastern-most location in Massachusetts
 * 3. Determine the shortest distance between these two locations IN TERMS OF THE 
 *    TOTAL NUMBER OF HIGHWAY EDGES USED. YOU ARE NOT YET READY TO TAKE MILEAGE INTO ACCOUNT
 * 4. Next create a copy of the highway graph that removes all line segments from I-90, the 
 *    Massachusetts Turnpike toll road.
 * 5. From this copy, determine the shortest distance between these two locations IN TERMS OF THE 
 *    TOTAL NUMBER OF HIGHWAY EDGES USED. YOU ARE NOT YET READY TO TAKE MILEAGE INTO ACCOUNT.
 */
public class Q2 {
	
	/**
	 * This method must create a copy of the graph, which you can do by recreate a graph with 
	 * the same number of vertices as the original one, BUT you only add an edge to the copy
	 * if the edge in the original graph IS NOT EXCLUSIVELY a line segment from the Mass Pike.
	 * 
	 * For example, in the data set you will see two nodes:
	 * 
	 * 		I-90@49|MA 42.169702 -72.580876
	 * 		I-90@51|MA 42.161558 -72.541995
	 * 
	 * These lines correspond to vertex #639 (the first one @49) and vertex #641 (the second one @51).
	 * Because the label for both of these vertices includes "I-90@" this edge must not appear in 
	 * the copied graph, since it is a highway segment exclusively on the Mass Turnpike.
	 * 
	 * Note that the edge is eliminated only when BOTH are present. For example, the following
	 * line segment will remain:
	 * 
	 * 		I-95(23)/MA128	                ==> vertex #705
	 * 		I-90@123B&I-95@24&MA128@24(95)  ==> vertex #1785
	 */
	static Information remove_I90_segments(Information info) {
		Graph copy = new Graph(info.graph.V()); //has all vertices but no edges yet
		
		
		
		//DOES THAT EDGE BELONG IN NEW GRAPH?
		for(int i=0;i<copy.V();i++) {
			for(int neighbor : info.graph.adj(i)) { 
				String id =info.labels.get(i);
				String n = info.labels.get(neighbor);
				if((!(id.startsWith("I-90")))&&(!(n.startsWith("I-90")))) {
					copy.addEdge(i,neighbor);
				}
			}
		}
	
		
		// DO YOUR WORK HERE...
		
		Information newInfo = new Information(copy, info.positions, info.labels);
		return newInfo;
	}
	
	
	/** 
	 * This helper method returns the western-most data point in the Information, given its latitude and
	 * longitude.
	 * 
	 * https://en.wikipedia.org/wiki/Latitude
	 * https://en.wikipedia.org/wiki/Longitude
	 * 
	 */
	public static int westernMostVertex(Information info) {
		double smallest=info.positions.get(0).longitude;
		 int westernMostID=0;
		
		for(int id: info.labels.keys()) {
			if(info.positions.get(id).longitude < smallest) {
				smallest=info.positions.get(id).longitude;
				westernMostID = id;
			}
		}
		//System.out.println("Western Most:\t " + info.labels.get(188) + " with an ID of " + westernMostID);
		return westernMostID;
	}
	
	/** 
	 * This helper method returns the eastern-most data point in the Information, given its latitude and
	 * longitude.
	 * 
	 * https://en.wikipedia.org/wiki/Latitude
	 * https://en.wikipedia.org/wiki/Longitude
	 * 
	 */
	public static int easternMostVertex(Information info) {
		double largest=info.positions.get(0).longitude;
		int easternMostID=0;
		
		for(int id: info.labels.keys()) {
			if(info.positions.get(id).longitude > largest) {
				largest=info.positions.get(id).longitude;
				easternMostID = id;
			}
		}
		//System.out.println("Eastern Most:\t " + info.labels.get(698) + " with an ID of " + easternMostID);
		return easternMostID;
	}
	
	/** 
	 * This helper method returns the southern-most data point in the Information, given its latitude and
	 * longitude.
	 * 
	 * https://en.wikipedia.org/wiki/Latitude
	 * https://en.wikipedia.org/wiki/Longitude
	 * 
	 */
	public static int southernMostVertex(Information info) {
		double smallest=info.positions.get(0).latitude;
		int southernMostID=0;
		
		for(int id: info.labels.keys()) {
			if(info.positions.get(id).latitude < smallest) {
				smallest=info.positions.get(id).latitude;
				southernMostID = id;
			}
		}
		//System.out.println("Southern Most:\t " + info.labels.get(1446) + " with an ID of " + southernMostID);
		return southernMostID;
	}
	
	/** 
	 * This helper method returns the northern-most data point in the Information, given its latitude and
	 * longitude.
	 * 
	 * https://en.wikipedia.org/wiki/Latitude
	 * https://en.wikipedia.org/wiki/Longitude
	 * 
	 */
	public static int northernMostVertex(Information info) {
		double largest=info.positions.get(0).latitude;
		int northernMostID=0;
		
		for(int id: info.labels.keys()) {
			if(info.positions.get(id).latitude > largest) {
				largest=info.positions.get(id).latitude;
				northernMostID = id;
			}
		}
		//System.out.println("Northern Most:\t " + info.labels.get(247) + " with an ID of " + northernMostID);
		return northernMostID;
	}
	
	
	
	
	public static void main(String[] args) {
	
		Information info = HighwayMap.undirectedGraph();
		
//		 for(int id : info.labels.keys()) {
//			  System.out.println(id + "->" + info.labels.get(id)+ "->" + info.positions.get(id));
//		 }
		 
//		 BreadthFirstPaths bfs = new BreadthFirstPaths(info.graph,0);
//		 for(int id : bfs.pathTo(1691)) {
//			// System.out.println(id);
//		 }
		
		Q2.westernMostVertex(info);
		Q2.easternMostVertex(info);
		Q2.southernMostVertex(info);
		Q2.northernMostVertex(info);
	
		
		System.out.println("\nQ2.1");
		System.out.print("westernMOST to easternMOST BFS: \t");
		int numEdges = -1;
		 BreadthFirstPaths bfs = new BreadthFirstPaths(info.graph,Q2.westernMostVertex(info));
		 for(int id : bfs.pathTo(Q2.easternMostVertex(info))) {
			 numEdges++;
		 }
		 System.out.println(numEdges);
		 
		 
		 System.out.print("southernMOST to northernMOST BFS: \t");
		 int numEdges2 = -1;
		 BreadthFirstPaths bfs2 = new BreadthFirstPaths(info.graph,Q2.southernMostVertex(info));
		 for(int id : bfs2.pathTo(Q2.northernMostVertex(info))) {
			 numEdges2++;
		 }
		 System.out.println(numEdges2);
		
		 
		 System.out.println("\nQ2.2");
		 System.out.print("westernMOST to easternMOST DFS: \t");
		 int numEdges3=-1;
		 DepthFirstPaths dfs = new DepthFirstPaths(info.graph,Q2.westernMostVertex(info));
		 for(int id: dfs.pathTo(Q2.easternMostVertex(info))) {
			 numEdges3++;
		 }
		 System.out.println(numEdges3);
		
		 
		 
		 System.out.print("southernMOST to northernMOST DFS: \t");
		 int numEdges4=-1;
		 DepthFirstPaths dfs2 = new DepthFirstPaths(info.graph,Q2.southernMostVertex(info));
		 for(int id: dfs2.pathTo(Q2.northernMostVertex(info))) {
			 numEdges4++;
		 }
		 System.out.println(numEdges4);
		 
		 
		 
		 
		 System.out.println("\nQ2.3");
		 Information info2 = Q2.remove_I90_segments(info);
		 	
		 System.out.print("easternMOST to westernMOST BFS without Mass Pike: \t");
		 int numEdges5 = -1;
		 BreadthFirstPaths bfs3 = new BreadthFirstPaths(info2.graph,Q2.easternMostVertex(info2));
		 for(int id : bfs3.pathTo(Q2.westernMostVertex(info2))) {
			 numEdges5++;
		 }
		 System.out.println(numEdges5);
			 
			 
			 System.out.print("southernMOST to northernMOST BFS without Mass Pike: \t");
			 int numEdges6 = -1;
			 BreadthFirstPaths bfs4 = new BreadthFirstPaths(info2.graph,Q2.southernMostVertex(info2));
			 for(int id : bfs4.pathTo(Q2.northernMostVertex(info2))) {
				 numEdges6++;
			 }
			 System.out.println(numEdges6);
	}
}

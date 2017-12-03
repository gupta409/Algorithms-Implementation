package com.csci4041.hw2.problem5;

import com.csci4041.hw2.problem5.Edge;
import com.csci4041.hw2.problem5.Node;

public class BellmanFord {
	public static boolean findShortest(Graph g, Node start) {
		boolean isDAG = true;
		//Initialize back edges and distances
		if(g != null && g.getGraphNodes() != null)
		for(Node n:g.getGraphNodes()) {
			n.setPrevious(null);
			if(n!=start) {
				n.setDistance(GraphConstants.INF);
			}else {
				n.setDistance(0);
			}
		}
		//Perform BellmanFord
		for(int i=1;i<=g.getGraphNodes().size()-1;i++) {
			for(Node n:g.getGraphNodes()) {
				relaxEdeges(n);
			}
		}
		for(Node n:g.getGraphNodes()) {
				for(Edge e: n.getAdjList()) {
					if(e.getDestination().getDistance()>e.getSource().getDistance()+e.getWeight()) {
						isDAG = false;
						return isDAG;
					}
				}
		}
		return isDAG;
	}
	private static void relaxEdeges(Node n) {
		if(n != null && n.getAdjList() != null)
		for(Edge e:n.getAdjList()) {
			//If distance after choosing the current edge is lower update the distance
			double expectedDistance = n.getDistance()+e.getWeight();
			double currentDistance =  e.getDestination().getDistance();
			if(expectedDistance < currentDistance) {
				//Update distance
				e.getDestination().setDistance(expectedDistance);
				e.getDestination().setPrevious(e.getSource());
			}
		}
	}
}

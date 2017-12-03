package com.csci4041.hw2.problem5;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
	public static List<Node> findShortestPath(Node source, Node destination, Graph graph) {
		//Initialize Distances
		for(Node n : graph.getGraphNodes()) {
			if(n != source) {
				n.setDistance(GraphConstants.INF);
			}else {
				n.setDistance(0);
			}
			n.setPrevious(null);
		}
		//Keep local copy of graph as a Min Heap for efficient traversal
		List<Node> heapGraph = new ArrayList<Node>();
		for(Node n: graph.getGraphNodes()) {
			heapGraph.add(n);
		}
		//Get node with minimum distance and relax each node
		Node current = null;
		List<Node> path = new ArrayList<Node>();
		while(heapGraph.size()>0) {
			heapGraph.sort(new NodeComparator());
			//heapGraph.get(0).setPrevious(current);
			current = heapGraph.get(0);
			heapGraph.remove(0);
			if(current != destination) {
				if(current!=null) {
					//Relax all edges from the node
					relaxEdeges(current);
				}else {
					System.out.println("Heap exited with error");
					break;
				}	
			}else {
				break;
			}
		}
		while(current != null) {
			path.add(current);
			current = current.getPrevious();
		}
		return path;
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

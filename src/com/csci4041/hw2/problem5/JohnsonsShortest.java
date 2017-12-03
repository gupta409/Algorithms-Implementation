package com.csci4041.hw2.problem5;

import java.util.ArrayList;
import java.util.HashMap;

public class JohnsonsShortest {
	public static HashMap<Integer, Integer> hValues = new HashMap<Integer,Integer>();
	public static HashMap<Integer,HashMap<Integer,Integer>> shortestPaths = new HashMap<Integer,HashMap<Integer,Integer>>();
	public static int track = 0;
	public static int runcount = 0;
	public static HashMap<Integer,HashMap<Integer,Integer>> findShortestSet(Graph g) {
		//Add super source node to graph
		Node source = new Node();
		source.setAdjList(new ArrayList<Edge>());
		if(g.getGraphNodes() != null) {
			for(Node n:g.getGraphNodes()) {
				//Adding only nodes which have not been processed yet
				if(n.isVisted()== false) {
					Edge e = new Edge(source, n, 0);
					source.getAdjList().add(e);	
				}
			}	
			g.getGraphNodes().add(source);
		}else {
			System.out.println("Empty graph given");
			return null;
		}
		//Perform Bellman Ford for each edge
		boolean isValid = BellmanFord.findShortest(g, source);
		if(isValid==false) {
			return null;
		}
		//Re-weight all edges which are from a new node
		for(Node u:g.getGraphNodes()) {
				if(u != source)
					hValues.put(u.getId(), (int)u.getDistance());
				if(u.getAdjList() != null)
				for(Edge e: u.getAdjList()) {
					e.setWeight(e.getWeight()+e.getSource().getDistance()-e.getDestination().getDistance());	
			}
		}
		//Remove super node from graph
		g.getGraphNodes().remove(g.getGraphNodes().indexOf(source));
		//Perform Dijkstra's for all nodes
		for(int i=0;i<g.getGraphNodes().size();i++) {
			Node s = g.getGraphNodes().get(i);
			int j;
			if(runcount == 1 && s.isVisted() == true)
				j = track;
			else
				j = 0;
			for(;j<g.getGraphNodes().size();j++) {
				Node d = g.getGraphNodes().get(j);
				Dijkstra.findShortestPath(s, d, g);
				int distance = (int)d.getDistance();	
				if(!shortestPaths.containsKey(s.getId())) {
					shortestPaths.put(s.getId(), new HashMap<Integer,Integer>());
				}
				//Add to matrix and Un-weight
				shortestPaths.get(s.getId()).put(d.getId(), distance - hValues.get(s.getId()) + hValues.get(d.getId()));
			}
			s.setVisted(true);
		}	
		track = shortestPaths.size()-1;
		runcount++;
		return shortestPaths;
	}
}

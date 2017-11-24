package com.csci4041.hw2.problem2;

public class DFS {
	private static int time;
	public static void performDFS(Graph g) {
		for(Node n : g.getGraphNodes()) {
			n.init();
		}
		time  = 0;
		for(Node n : g.getGraphNodes()) {
			if(!n.isVisted()) {
				DFSVisit(n);
			}
		}
	}
	private static void DFSVisit(Node u) {
		time = time + 1;
		u.setVisitTime(time);
		u.setVisted(true);
		if(u.getAdjList()!=null)
		for(Edge e: u.getAdjList()) {
			if(!e.getDestination().isVisted()) {
				e.getDestination().setPrevious(u);
				DFSVisit(e.getDestination());
			}
		}
		time = time + 1;
		u.setFinishTime(time);
	}
}

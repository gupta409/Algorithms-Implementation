package com.csci4041.hw2.problem4;

import java.util.List;

public class Graph {
	List<Node> graphNodes;

	public Graph(List<Node> graphNodes) {
		super();
		this.graphNodes = graphNodes;
	}
	public Graph() {
		this.graphNodes = null;
	}
	public List<Node> getGraphNodes() {
		return graphNodes;
	}
	public void setGraphNodes(List<Node> graphNodes) {
		this.graphNodes = graphNodes;
	}
	
		
}

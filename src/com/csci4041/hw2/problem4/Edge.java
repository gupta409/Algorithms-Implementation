package com.csci4041.hw2.problem4;

public class Edge {
	Node source;
	Node destination;
	double weight;
	public Edge(Node source, Node destination, double weight) {
		super();
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
	public Node getSource() {
		return source;
	}
	public void setSource(Node source) {
		this.source = source;
	}
	public Node getDestination() {
		return destination;
	}
	public void setDestination(Node destination) {
		this.destination = destination;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}

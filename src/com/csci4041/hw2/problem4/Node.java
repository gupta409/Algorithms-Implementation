package com.csci4041.hw2.problem4;

import java.util.List;

public class Node {
	private int id;
	private	double distance;
	private List<Edge> adjList;
	private boolean isVisted;
	private Node previous;
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public List<Edge> getAdjList() {
		return adjList;
	}
	public void setAdjList(List<Edge> adjList) {
		//TODO: Validate list before assigning
		this.adjList = adjList;
	}
	public boolean isVisted() {
		return isVisted;
	}
	public void setVisted(boolean isVisted) {
		this.isVisted = isVisted;
	}
	public Node(List<Edge> adjList, int id) {
		super();
		this.distance = GraphConstants.INF;
		//TODO: Validate list before assigning
		this.adjList = adjList;
		this.isVisted = false;
		this.id = id;
		this.previous = null;
	}
	public Node(int id) {
		super();
		this.distance = GraphConstants.INF;
		this.adjList = null;
		this.isVisted = false;
		this.id = id;
		this.previous = null;
	}
	public Node() {
		super();
		this.distance = GraphConstants.INF;
		this.adjList = null;
		this.isVisted = false;
		this.previous = null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Node getPrevious() {
		return previous;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
}

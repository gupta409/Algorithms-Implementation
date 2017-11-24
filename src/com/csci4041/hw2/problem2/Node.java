package com.csci4041.hw2.problem2;

import java.util.List;

public class Node {
	private int id;
	private	double distance;
	private List<Edge> adjList;
	private boolean isVisted;
	private Node previous;
	private int visitTime;
	private int finishTime;
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
		validateEdges(adjList);
		this.adjList = adjList;
	}
	private void validateEdges(List<Edge> adjList) {
		for(Edge e:adjList) {
			if(e.source != this) {
				System.out.println("Invalid Edge Found");
			}
		}
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
		validateEdges(adjList);
		this.adjList = adjList;
		this.isVisted = false;
		this.id = id;
		this.previous = null;
		this.visitTime = 0;
		this.finishTime = 0;
	}
	public Node(int id) {
		super();
		this.distance = GraphConstants.INF;
		this.adjList = null;
		this.isVisted = false;
		this.id = id;
		this.previous = null;
		this.visitTime = 0;
		this.finishTime = 0;
	}
	public Node() {
		super();
		this.distance = GraphConstants.INF;
		this.adjList = null;
		this.isVisted = false;
		this.previous = null;
		this.visitTime = 0;
		this.finishTime = 0;
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
	public int getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(int visitTime) {
		this.visitTime = visitTime;
	}
	public int getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}
	public void init() {
		this.previous = null;
		this.isVisted = false;
		this.visitTime = 0;
		this.finishTime = 0;
	}
}

package com.csci4041.hw2.problem5;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
	//Gives negative value if o1 has less distance than o2. 
	@Override
	public int compare(Node o1, Node o2) {
		if(o1.getDistance() < o2.getDistance()) {
			return -1;
		}
		if(o1.getDistance() > o2.getDistance()) {
			return 1;
		}
		else
		return 0;
	}

}

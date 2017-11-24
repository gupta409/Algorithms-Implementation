package com.csci4041.hw2.problem2;

import java.util.Comparator;

public class TopologicalComparator implements Comparator<Node>{

	@Override
	public int compare(Node o1, Node o2) {
		int results = 0;
		if(o1.getFinishTime()>o2.getFinishTime()) {
			results = 1;
		}else
		if(o1.getFinishTime()<o2.getFinishTime()) {
			results = -1;
		}else
			results = 0;
		return results;
	}

}

package com.csci4041.hw2.problem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RunDFS {
	private static PrintWriter output;
	private static Scanner input;
	public static void main(String[] args) {
		//Extract data from input file
		// Setup I/O file connections
		try {
			input = new Scanner(new File(args[0]));
			output = new PrintWriter(new File("output.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("No file found!");
		}
		//Make graph from input data
		Map<Integer, Node> nodeMap = new HashMap<Integer, Node>();
		String nextLine = null;
		while(input.hasNextLine()) {
			nextLine = input.nextLine();
			int tempSource = new Integer(nextLine.split(":")[0]);
			Node source = null;
			if(nodeMap.containsKey(tempSource)) {
				source = nodeMap.get(tempSource);
			}else {
				source = new Node(tempSource);
				source.setAdjList(new ArrayList<Edge>());
				nodeMap.put(tempSource, source);
			}
			if(nextLine.split(":").length>1)
			for(String s: nextLine.split(":")[1].split(" ")) {
				int sId = new Integer(s);
				Node destination = null;
				if(nodeMap.containsKey(sId)) {
					destination = nodeMap.get(sId);
				}else {
					destination = new Node(sId);
					nodeMap.put(sId, destination);
				}
				source.getAdjList().add(new Edge(source, destination, 1));
			}
		}
		List<Node> nodes = new ArrayList<Node>();
		for(Node n: nodeMap.values()) {
			nodes.add(n);
		}
		Graph g = new Graph(nodes);
		//Perform DFS on graph
		DFS.performDFS(g);
		g.getGraphNodes().sort(new TopologicalComparator());
		for(Node n:g.getGraphNodes()) {
			System.out.print(n.getId()+"\t");
		}
		//Close I/O Connections
		input.close();
		output.close();
	}
}

package com.csci4041.hw2.problem3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DijkstraTest {
	private static PrintWriter output;
	private static Scanner input;
	public static void main(String[] args) {
		// Setup I/O file connections
		try {
			input = new Scanner(new File(args[0]));
			output = new PrintWriter(new File("output.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("No file found!");
		}
		int source = 0, destination = 0;
		//Read first line for source and destination
		if(input.hasNextLine()) {
			String line1 = input.nextLine();
			String splits[] = line1.split(" ");
			try {
				source = new Integer(splits[0]);
				destination = new Integer(splits[1]);
			}
			catch(NumberFormatException e) {
				System.out.println("Malformatted input file. Error in parsing source and destination nodes");
				e.printStackTrace();
			}
		}
		//Read next lines for entire graph
		double edgeWeight = GraphConstants.INF;
		ArrayList<Node> nodes = new ArrayList<Node>();
		if(input.hasNextLine()) {
			String temp = input.nextLine();
			String weights[] = temp.split(" ");
			Node n1;
			//Get data of first node
			if(weights.length > 0) {
				n1 = new Node(0);
				//Add first node to list of nodes
				nodes.add(n1);
				//Make all other nodes
				for(int i=1; i<weights.length;i++){
					nodes.add(new Node(i));
					nodes.get(i).setAdjList(new ArrayList<Edge>());
				}
				//Create Adj List of first node
				n1.setAdjList(new ArrayList<Edge>());
				for(int i=0;i<weights.length;i++) {
					double wt = new Double(weights[i]);
					if(wt < GraphConstants.INF && i != 0) {
						nodes.get(0).getAdjList().add(new Edge(nodes.get(0), nodes.get(i), wt));	
					}
				}
			}else {
				System.out.println("Invalid Graph Data");
			}
		}else {
			System.out.println("No Graph Data Found");
		}
		//Fill adj list for all other nodes
		int j = 1;
		while(input.hasNextLine()) {
			String temp = input.nextLine();
			String weights[] = temp.split(" ");
			if(weights.length > 0) {
				nodes.get(j).setId(j);
				for(int i=0;i<weights.length;i++) {
					double wt = new Double(weights[i]);
					if(wt < GraphConstants.INF && i != j) {
						nodes.get(j).getAdjList().add(new Edge(nodes.get(j), nodes.get(i), wt));	
					}
				}
			}
			j++;
		}
		Graph graph = new Graph(nodes);
		//Call dijkstra's on source destination
		List<Node> path = Dijkstra.findShortestPath(nodes.get(source), nodes.get(destination), graph);
		System.out.println("Cost: " + path.get(0).getDistance());
		for(int i=path.size()-1;i>=0;i--) {
			System.out.print(path.get(i).getId()+"\t");
		}
	}

}

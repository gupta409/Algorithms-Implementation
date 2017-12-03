package com.csci4041.hw2.problem5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.csci4041.hw2.problem5.Edge;
import com.csci4041.hw2.problem5.Graph;
import com.csci4041.hw2.problem5.GraphConstants;
import com.csci4041.hw2.problem5.Node;

public class JohnsonsTest {
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
		//Read next lines for entire graph
		ArrayList<Node> nodes = new ArrayList<Node>();
		if(input.hasNextLine()) {
			String temp = input.nextLine().trim();
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
					double wt = new Double(weights[i].trim());
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
		int firstGraphSize = nodes.size();
		while(j<firstGraphSize &&input.hasNextLine()) {
			String temp = input.nextLine().trim();
			String weights[] = temp.split(" ");
			if(weights.length > 0) {
				nodes.get(j).setId(j);
				for(int i=0;i<weights.length;i++) {
					double wt = new Double(weights[i].trim());
					if(wt < GraphConstants.INF && i != j) {
						nodes.get(j).getAdjList().add(new Edge(nodes.get(j), nodes.get(i), wt));	
					}
				}
			}
			j++;
		}
		//Run Johnsons
		Graph graph = new Graph(nodes);
		HashMap<Integer,HashMap<Integer,Integer>> h = JohnsonsShortest.findShortestSet(graph);
		if(h==null) {
			output.append("Negative Cycle");
		}else {
			for(int i=0;i<h.size();i++) {
				for(int k=0;k<h.size();k++) {
					output.append(h.get(i).get(k)+"");
					if(k!=h.size()-1) {
						output.append(" ");	
					}					
				}
				if(i!=h.size()-1)
					output.append("\n");
			}			
		}
		//Read new nodes and add to graph
		nodes = (ArrayList<Node>) graph.getGraphNodes();
		if(input.hasNextLine()) {
			String temp = input.nextLine().trim();
			String weights[] = temp.split(" ");
			Node n1;
			//Get data of first node
			if(weights.length > 0) {
				n1 = new Node(j);
				//Add first node to list of nodes
				nodes.add(n1);
				//Make all new nodes
				for(int i=j+1; i<weights.length;i++){
					nodes.add(new Node(i));
					nodes.get(i).setAdjList(new ArrayList<Edge>());
				}
				//Create Adj List of first node
				n1.setAdjList(new ArrayList<Edge>());
				for(int i=0;i<weights.length;i++) {
					double wt = new Double(weights[i].trim());
					if(wt < GraphConstants.INF && i != j) {
						nodes.get(j).getAdjList().add(new Edge(nodes.get(j), nodes.get(i), wt));
						nodes.get(i).getAdjList().add(new Edge(nodes.get(i), nodes.get(j), wt));
					}
				}
			}else {
				System.out.println("Invalid Second Graph Data");
			}
		}else {
			System.out.println("No Second Graph Data Found");
			//Close I/O Connections
			input.close();
			output.close();
			return;
		}
		//Make new graph
		j = j +1;
		while(input.hasNextLine()) {
			String temp = input.nextLine().trim();
			String weights[] = temp.split(" ");
			if(weights.length > 0) {
				nodes.get(j).setId(j);
				for(int i=0;i<weights.length;i++) {
					double wt = new Double(weights[i].trim());
					if(wt < GraphConstants.INF && i != j) {
						nodes.get(j).getAdjList().add(new Edge(nodes.get(j), nodes.get(i), wt));
						nodes.get(i).getAdjList().add(new Edge(nodes.get(i), nodes.get(j), wt));
					}
				}
			}
			j++;
		}
		//Re-run partial johnsons
		graph.setGraphNodes(nodes);
		h = JohnsonsShortest.findShortestSet(graph);
		output.append("\n");
		if(h==null) {
			output.append("Negative Cycle");
		}else {
			for(int i=0;i<h.size();i++) {
				for(int k=0;k<h.size();k++) {
					if(h.get(i).get(k) != null)
						output.append(h.get(i).get(k)+"");
					if(k!=h.size()-1 && h.get(i).get(k) != null) {
						output.append(" ");	
					}					
				}
				if(i!=h.size()-1 && h.get(i).get(0) != null)
					output.append("\n");
			}			
		}
		//Close I/O Connections
		input.close();
		output.close();
	}
}
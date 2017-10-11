package com.csci4041.hw1.problem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Teller {
	private static ArrayList<Customer> customerList = new ArrayList<Customer>();
	private static PrintWriter output;
	private static Scanner input;

	public static void main(String args[]) {
		// Setup I/O file connections
		try {
			input = new Scanner(new File(args[0]));
			output = new PrintWriter(new File("output.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("No file found!");
		}
		// Extract Customer Details from input.txt
		String tempLine;
		String splits[];
		while (input.hasNextLine()) {
			tempLine = input.nextLine();
			splits = tempLine.split(":");
			try {
				customerList.add(new Customer(splits[0].trim(), new Integer(splits[1].trim())));
			} catch (Exception e) {
				System.out.println("Malformatted Input");
			}
		}
		// Make priority queue
		PriorityQueue bankQueue = new PriorityQueue(customerList);
		// Export Data to file output.txt based on priority
		if (bankQueue.getSize() > 0) {
			output.append(bankQueue.extract_max().getName());
		}
		while (bankQueue.getSize() > 0) {
			output.append(" ");
			output.append(bankQueue.extract_max().getName());
		}
		input.close();
		output.close();
	}
}

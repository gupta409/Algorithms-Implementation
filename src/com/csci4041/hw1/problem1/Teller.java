package com.csci4041.hw1.problem1;

import java.util.ArrayList;

public class Teller {
	public static void main(String args[]) {
		ArrayList<Customer> customerList =  new ArrayList<Customer>();
		//TODO:Extract Customer Details from input.txt
		customerList.add(new Customer("Anish",1));
		customerList.add(new Customer("Rai",2));
		customerList.add(new Customer("Suresh",3));
		customerList.add(new Customer("Rahul",4));
		PriorityQueue bankQueue = new PriorityQueue(customerList);
		while(bankQueue.getSize()>0) {
			//TODO: Add names to the output.txt
			System.out.println(bankQueue.extract_max().getName());
		}
	}
}

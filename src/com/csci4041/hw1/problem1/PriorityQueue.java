package com.csci4041.hw1.problem1;

import java.util.ArrayList;

public class PriorityQueue extends Heap<ArrayList<Customer>, Customer>{

	PriorityQueue(ArrayList<Customer> myList) {
		super(myList);
		this.buildMaxHeap();
	}
	
	public void insert(Customer customer) {
		this.addNode(customer);
	}
	public Customer maximum() {
		return this.getRoot();
	}
	public Customer extract_max() {
		Customer maxCustomer = this.getRoot();
		this.removeNode(1);
		this.maxHeapify(1);
		return maxCustomer;
	}
}

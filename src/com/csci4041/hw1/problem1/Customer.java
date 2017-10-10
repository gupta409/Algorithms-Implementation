package com.csci4041.hw1.problem1;

public class Customer implements Comparable<Customer>{
	private String name;
	private Integer priority;
	public Customer(String name, Integer priority) {
		super();
		this.name = name;
		this.priority = priority;
	}
	public String getName() {
		return name;
	}
	public Integer getPriority() {
		return priority;
	}
	@Override
	public int compareTo(Customer o) {
		int result = 0;
		if(this.priority > o.getPriority()) {
			result = 1;
		}
		else {
			result = -1;
		}
		return result;
	}
	
}

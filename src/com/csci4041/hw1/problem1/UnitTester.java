package com.csci4041.hw1.problem1;

import java.util.Arrays;
import java.util.List;

public class UnitTester {
	public static void main(String args[]) {
		System.out.println("Hello World");
		List<Integer> myList;
		myList = Arrays.asList(1,2,3,4,5,6,7,8,9);
		Heap<List<Integer>, Integer> myHeap = new Heap<List<Integer>, Integer>(myList);
		myHeap.printNodes();
		myHeap.buildMaxHeap();
		System.out.println("\n==============================");
		myHeap.printNodes();
	}
}

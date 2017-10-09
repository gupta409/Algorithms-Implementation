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
		myHeap.printNodes();
		/*System.out.println("\n=========Swap Left=========");
		myHeap.swapLeft(1);
		myHeap.printNodes();
		System.out.println("\n=========Swap Right=========");
		myHeap.swapRight(1);
		myHeap.printNodes();
		*/
	}
}

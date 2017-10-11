package com.csci4041.hw1.problem4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BucketSort {
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
		// TODO: Take data from the input.txt
		List<String> myList = Arrays.asList("Anish", "Rahul", "arush", "Anish", "Rahul", "arush", "Anish", "Rahul",
				"arush", "Anish", "Rahul", "arush", "Anish", "Rahul", "arush", "Anish", "Rahul", "arush", "Anish",
				"Rahul", "arush", "Anish", "Rahul", "arush", "Anish", "Rahul", "arush", "Anish", "Rahul", "arush");
		ArrayList<String> myList1 = new ArrayList<String>();
		for (String string : myList) {
			myList1.add(string);
		}
		// FIXME: Fix Case-sensitive nature
		sort(myList1, 0);
		for (String s : myList1)
			System.out.println(s);
		// TODO: Print output to output.txt
	}

	/**
	 * Function sorts the elementList. If elementList is more than 10 elements then
	 * it performs bucket sort else sorts with Insertion Sort.
	 */
	public static void sort(List<String> elementList, int depth) {
		// Perform Bucket sort
		// Create Buckets and fill them with relevant data each bucket has a list of
		// strings
		Map<Character, List<String>> bucketList = new HashMap<Character, List<String>>();
		if (elementList.size() > 10) {
			char c;
			List<String> tempList;
			// Divides the elements to buckets with same character at index depth
			for (String element : elementList) {
				if (depth < element.length()) {
					c = element.charAt(depth);
				} else {
					// Put elements with depth more than element size into different bucket
					c = '\0';
				}
				if (bucketList.containsKey(c)) {
					bucketList.get(c).add(element);
				} else {
					tempList = new ArrayList<String>();
					tempList.add(element);
					bucketList.put(c, tempList);
				}
			}
			// Recursively perform bucket sort on the buckets made above
			List<String> subElementList;
			for (Character key : bucketList.keySet()) {
				subElementList = (ArrayList<String>) bucketList.get(key);
				if (key != '\0') {
					sort(subElementList, depth + 1);
				} else {
					sort(subElementList.subList(0, (int) Math.ceil(subElementList.size() / 2)), depth);
					sort(subElementList.subList((int) Math.ceil(subElementList.size() / 2), subElementList.size()),
							depth);
				}
			}
		} else {
			// Insertion Sort on the data elements
			sort(elementList);
			return;
		}
		// While is topmost sort level
		if (depth == 0) {
			List<String> minSet;
			elementList.clear();
			while (!bucketList.isEmpty()) {
				minSet = bucketList.remove(FindMin(bucketList));
				elementList.addAll(minSet);
			}
		}
	}

	private static void sort(List<String> elements) {
		String temp = null;
		for (int i = 0; i < elements.size(); i++) {
			for (int j = i; j < elements.size(); j++) {
				if (elements.get(i).compareToIgnoreCase(elements.get(j)) <= 0) {
					temp = elements.get(i);
					elements.set(i, elements.get(j));
					elements.set(j, temp);
				}
			}
		}
	}

	private static Character FindMin(Map<Character, List<String>> data) {
		Character minChar = null;
		if (!data.keySet().isEmpty()) {
			for (Character c : data.keySet()) {
				if (minChar == null)
					minChar = c;
				else if (c.compareTo(minChar) <= 0) {
					minChar = c;
				}
			}
		} else {
			minChar = null;
		}
		return minChar;
	}
}

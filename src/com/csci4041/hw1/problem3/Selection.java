package com.csci4041.hw1.problem3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Selection {
	private static PrintWriter output;
	private static Scanner input;

	public static void main(String[] args) {
		// Setup I/O file connections
		try {
			input = new Scanner(new File(args[0]));
			//input = new Scanner("input.txt");
			output = new PrintWriter(new File("output.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("No file found!");
		}
		// Extract Customer Details from input.txt
		int i = 0;
		List<Integer> data = new ArrayList<Integer>();
		try {
			i = input.nextInt();
			// i = new Integer(line1.trim());
			while (input.hasNextInt()) {
				data.add(input.nextInt());
			}
		} catch (Exception e) {
			System.out.println("Malformatted input");
		}
		// Send data to output.txt
		int answer;
		try {
			answer = select(i - 1, data);
		} catch (IndexOutOfBoundsException e) {
			answer = 0;
			System.out.println("Index of bound. Invalid input given");
		}
		// Export Data to file output.txt based on priority
		output.print(answer);
		input.close();
		output.close();
	}

	public static int select(int key, List<Integer> data) {
		int maxIndex = data.size() - 1;
		int piviot = data.get(maxIndex); // Take last element as pivot
		if (maxIndex == key) {
			return piviot; // Data found return value
		} else {
			// Data not found perform partition
			int temp;
			int j = -1;
			for (int i = 0; i < maxIndex; i++) {
				if (data.get(i) <= piviot) {
					j = j + 1;
					temp = data.get(j);
					data.set(j, data.get(i));
					data.set(i, temp);
				}
			}
			j++;
			temp = data.get(j);
			data.set(j, data.get(maxIndex));
			data.set(maxIndex, temp);
			// Call recursively
			if (key < j) {
				return select(key, data.subList(0, j));
			} else if (key > j) {
				return select(key - j - 1, data.subList(j + 1, maxIndex + 1));
			} else {
				System.out.println(data.get(j));
				return data.get(j);
			}

		}
	}

}

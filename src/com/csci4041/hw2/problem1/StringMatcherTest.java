package com.csci4041.hw2.problem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StringMatcherTest {
	private static PrintWriter output;
	private static Scanner input;
	public static void main(String[] args) {
		//Extract data from input file
		// Setup I/O file connections
		try {
			input = new Scanner(new File(args[0]));
			output = new PrintWriter(new File("output.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("No file found!");
		}
		String pattern = input.nextLine();
		String data = input.nextLine();
		StringMatcher automata = new StringMatcher(pattern);
		List<Integer> matches =  automata.matcher(data);
		StringMatcher rever = new StringMatcher(new StringBuilder(pattern).reverse().toString());
		matches.addAll(rever.matcher(data));
		Collections.sort(matches);
		for(int i:matches.subList(0, matches.size()-1)) {
			output.append(i+" ");
		}
		output.append(matches.get(matches.size()-1)+"");
		//Close I/O Connections
		input.close();
		output.close();
	}

}

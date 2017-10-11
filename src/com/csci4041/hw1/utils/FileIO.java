package com.csci4041.hw1.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIO {
	public static void read(String pathName) {
		try {
			Scanner input=  new Scanner(new File(pathName));
			while(input.hasNextInt())
			{
				//TODO: Perform operations
			}
			input.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("No file \""+pathName+"\" found!");
		}
	}
	public static void write() {
		try {
			PrintWriter output = new PrintWriter(new File("output.txt"));
			//TODO: Perform operations
			//output.print(nums[count-1]);
			output.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error creating \"output.txt\"!");
		}

	}
}

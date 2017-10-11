package com.csci4041.hw1.problem3;

import java.util.Arrays;
import java.util.List;

public class SelectionSort {

	public static void main(String[] args) {
		//TODO: Get list from input.txt
		//FIXME: i starts from 1
		int i = 0;
		List<Integer> data = Arrays.asList(1,2,3,4);
		//TODO: Send data to output.txt
		System.out.println(select(i, data));
	}
	public static int select(int key, List<Integer> data) {
		int maxIndex = data.size()-1;
		int piviot = data.get(maxIndex);	//Take last element as pivot
		if(maxIndex == key) {
			return piviot;	//Data found return value
		}
		else {
			//Data not found perform partition
			int temp;
			int j = -1;
			for(int i = 0;i<maxIndex;i++) {
				if(data.get(i)<=piviot) {
					j = j +1;
					temp = data.get(j);
					data.set(j, data.get(i));
					data.set(i, temp);
				}
			}
			j++;
			temp = data.get(j);
			data.set(j, data.get(maxIndex));
			data.set(maxIndex, temp);
			//Call recursively
			if(key<j) {
				return select(key, data.subList(0, j));	
			}else 
				if(key>j) {
				return select(key-j-1, data.subList(j+1, maxIndex+1));
			}else {
				return data.get(j);
			}
			
		}
	}

}

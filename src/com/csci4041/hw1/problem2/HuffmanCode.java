package com.csci4041.hw1.problem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class HuffmanCode {
	public static void main(String args[]) {
		//TODO: Read from File
		String input = "ffffeeeeeeeeefccccccccccccbbbbbbbbbbbbbddddddddddddddddaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		//Count String entry and make map
		Map<Character,Integer> inputMap = new HashMap<Character,Integer>();
		char tempChar;
		int tempCount = 1;
		for(int index=0;index<input.length();index++) {
			tempChar = input.charAt(index);
			//If map has the count available increment that
			if(inputMap.containsKey(tempChar)) {
				tempCount = inputMap.get(tempChar);
				tempCount++;
				inputMap.put(tempChar, tempCount);
			}
			else {
				//Else add it to the map and set count to 1
				tempCount = 1;
				inputMap.put(tempChar, tempCount);
			}
		}
		List<HuffmanNode> huffmanNodes = new ArrayList<HuffmanNode>();
		//Convert to HuffmanNodes
		for(Character key : inputMap.keySet()) {
			huffmanNodes.add(new HuffmanNode(key, inputMap.get(key)));
		}
		//Perform Huffman Coding
		Map<Character,String> compressionTable = compress(huffmanNodes);
		//TODO:Write to file
		
		//TODO: Remove only for test purpose
		for (HuffmanNode data : huffmanNodes) {
			System.out.println(data.getKey()+"\t"+data.getFrequency());
		}
		for(Character key : compressionTable.keySet()) {
			System.out.println("\n"+key+"\t"+compressionTable.get(key));
		}
		System.out.println("END");
	}
	public static Map<Character,String> compress(List<HuffmanNode> huffmanNodes) {
		Map<Character, String> compressionTable = new HashMap<Character,String>();
		for(HuffmanNode huffmanNode : huffmanNodes) {
			compressionTable.put(huffmanNode.getKey(), "");
		}
		//Make tree from given nodes
		generateTree(huffmanNodes);
		//Traverse tree
		HuffmanNode source = huffmanNodes.get(0);
		String compressionString = "";
		traveseGraph(source, compressionTable,compressionString);
		return compressionTable;
	}
	private static void traveseGraph(HuffmanNode source, Map<Character, String> compressionTable,String compressedString) {
		if(source.isLeaf()) {
			//Add it to the compression string to the table
			compressionTable.put(source.getKey(), compressedString);
		}
		else {
			if(source.getLeftNode()!=null) {
				traveseGraph(source.getLeftNode(), compressionTable, compressedString+"0");
			}
			if(source.getRightNode()!=null) {
				traveseGraph(source.getRightNode(), compressionTable, compressedString+"1");
			}
			
		}
	}
	private static void generateTree(List<HuffmanNode> huffmanNodes) {
		if(huffmanNodes.size()==1) {
			return;
		}
		else {
			Collections.sort(huffmanNodes);
			HuffmanNode newNode = new HuffmanNode('\0', huffmanNodes.get(0).getFrequency()+huffmanNodes.get(1).getFrequency(), huffmanNodes.get(0), huffmanNodes.get(1));
			huffmanNodes.remove(1);
			huffmanNodes.remove(0);
			huffmanNodes.add(newNode);
			generateTree(huffmanNodes);
		}
	}
}

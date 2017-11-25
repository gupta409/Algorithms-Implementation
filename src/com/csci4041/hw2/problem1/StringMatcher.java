package com.csci4041.hw2.problem1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringMatcher {
	private String pattern;
	private Map<Integer, HashMap<Character,Integer>> states;
	StringMatcher(String pattern){
		this.pattern = pattern;
		this.states = new HashMap<Integer, HashMap<Character,Integer>>(); 
		setup();
	}
	private void setup() {
		Map<Character,Character> options = new HashMap<Character, Character>();
		//Find unique character in the string
		for(char c:pattern.trim().toCharArray()) {
			if(!options.containsKey(c)) {
				options.put(c, c);
			}
		}
		for(int q=0;q<=pattern.length();q++) {
			for(char a: options.values()) {
				int k = Math.min(pattern.length(), q+1);
				while(k>=0 && !isSuffix(pattern.substring(0, k),pattern.substring(0, q)+a)) {
					k = k-1;
				}
				if(states.containsKey(q)) {
					states.get(q).put(a, k);
				}else {
					HashMap<Character,Integer> temp = new HashMap<Character,Integer>();
					temp.put(a, k);
					states.put(q, temp);
				}
			}
		}
	}
	private boolean isSuffix(String substring, String string) {
		if(string.substring(string.length()-substring.length()).compareTo(substring) == 0) {
			return true;
		}else
		return false;
	}
	public void printStates() {
		for(HashMap<Character,Integer> m:states.values()) {
			for(Integer i:m.values()) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	public List<Integer> matcher(String data) {
		List<Integer> matchIndex = new ArrayList<Integer>();
		int q = 0;
		for(int i=0;i<data.length();i++) {
			q = states.get(q).get(data.charAt(i));
			if(q == pattern.length()) {
				matchIndex.add(new Integer(i-pattern.length()+1));
			}
		}
		return matchIndex;
	}
}

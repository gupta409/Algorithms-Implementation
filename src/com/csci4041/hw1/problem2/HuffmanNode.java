package com.csci4041.hw1.problem2;

public class HuffmanNode implements Comparable<HuffmanNode> {
	private char key;
	private int frequency;
	private HuffmanNode leftNode, rightNode;

	HuffmanNode() {
		leftNode = null;
		rightNode = null;
	}

	HuffmanNode(char key, int value) {
		this();
		this.key = key;
		this.frequency = value;
	}

	public HuffmanNode(char key, int frequency, HuffmanNode leftNode, HuffmanNode rightNode) {
		this.key = key;
		this.frequency = frequency;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	public char getKey() {
		return key;
	}

	public void setKey(char key) {
		this.key = key;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public HuffmanNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(HuffmanNode leftNode) {
		this.leftNode = leftNode;
	}

	public HuffmanNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(HuffmanNode rightNode) {
		this.rightNode = rightNode;
	}

	public boolean isLeaf() {
		boolean isLeaf = false;
		if (leftNode == null && rightNode == null)
			isLeaf = true;
		else
			isLeaf = false;
		return isLeaf;
	}

	@Override
	public int compareTo(HuffmanNode o) {
		int ans = 0;
		if (this.frequency >= o.getFrequency()) {
			ans = 1;
		} else {
			ans = -1;
		}
		return ans;
	}

}

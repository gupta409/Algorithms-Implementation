package com.csci4041.hw1.problem1;

import java.util.List;


public class Heap<T extends List<E> , E extends Comparable<E>> {
	

	private T list;
	
	public Heap() {
		this.list = null;
	}
	public Heap(T myList) {
		this.list = myList;
	}

	public E getRoot() {
		return this.getNode(1);
	}

	public E getNode(int index) {
		E data;
		try {
			data = list.get(index - 1);
		} catch (IndexOutOfBoundsException e) {
			data = null;
		}
		return data;
	}

	public E getParent(int index) {
		index = (int) Math.floor(index / 2);
		E data;
		try {
			data = list.get(index - 1);
		} catch (IndexOutOfBoundsException e) {
			// e.printStackTrace();
			data = null;
		}
		return data;
	}

	public E getLeftLeaf(int index) {
		index = index * 2;
		E data;
		try {
			data = list.get(index - 1);
		} catch (IndexOutOfBoundsException e) {
			// e.printStackTrace();
			data = null;
		}
		return data;
	}

	public E getRightLeaf(int index) {
		index = (index * 2) + 1;
		E data;
		try {
			data = list.get(index - 1);
		} catch (IndexOutOfBoundsException e) {
			// e.printStackTrace();
			data = null;
		}
		return data;
	}

	public int getSize() {
		int size;
		size = list.size();
		return size;
	}

	// Swaps element at index a with element at index b
	private void swap(int a, int b) {
		E temp = list.get(a - 1);
		list.set(a - 1, list.get(b - 1));
		list.set(b - 1, temp);
	}

	// Swaps node i with Left Leaf of i
	public void swapLeft(int i) {
		swap(i, 2 * i);
	}

	// Swaps node i with Right Leaf of i
	public void swapRight(int i) {
		swap(i, 2 * i + 1);
	}

	public void maxHeapify(int i) {
		int n = list.size();
		while (i <= n) {
			// Find max among parent, left node, right node
			// Swap parent with max
			E parent = this.getNode(i);
			E left = this.getLeftLeaf(i);
			E right = this.getRightLeaf(i);
			if (parent != null) {
				if (left != null) {
					if (right != null) {
						//All data is present
						if ((int) left.compareTo(parent) > 0 && (int) left.compareTo(right) > 0) {
							swapLeft(i);
							i = i * 2;
						}
						else
						if ((int) right.compareTo(parent) > 0 && (int) right.compareTo(left) > 0) {
							swapRight(i);
							i = i * 2 + 1;
						} else {
							i = n + 1;
						}
					} else {
						//Only Left is present
						if ((int) left.compareTo(parent) > 0) {
							swapLeft(i);
							i = i * 2;
						} else {
							i = n + 1;
						}
					}
				} else if (right != null) {
					//Only right is present
					if ((int) right.compareTo(parent) > 0) {
						swapRight(i);
						i = i * 2 + 1;
					} else {
						i = n + 1;
					}
				}
				else {
					//Nothing is present
					i = n + 1;
				}
			} else {
				i = n + 1;
			}
		}
	}

	public void buildMaxHeap() {
		int n = list.size() / 2;
		for (int i = n; i >= 1; i--) {
			this.maxHeapify(i);
		}
	}

	public void printNodes() {
		for (int i = 1; i <= this.getSize() / 2; i++) {
			System.out.println("\n-------------------" + i + "-----------------------");
			System.out.println(this.getNode(i));
			System.out.print(this.getLeftLeaf(i));
			System.out.print("\t" + this.getRightLeaf(i));
		}
	}
	
	public void removeNode(int i){
		try{
			list.remove(i-1);
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("Invalid Removal");
		}
		catch(UnsupportedOperationException e) {
			System.out.println("Invalid Input List type sent. No able to remove elements from List");
		}
	}
	
	public void addNode(E data) {
			list.add(data);
			this.maxHeapify((int)Math.floor(list.size()/2));
	}
}

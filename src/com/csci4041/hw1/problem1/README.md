# Problem 1: Priority Queue

## Problem Statement
Implement a _priority queue_. In particular, you are asked to simulate a waiting line that forms in front of a bank teller in a typical bank. Different customers have different priorities. A priority queue should support the following functions (you must build these functions):
 - Insert(S,x) inserts the element x into the set S.
 - Maximum(S) returns the element of S with the largest key.
 - Extract_Max(S) removes and returns the element of S with the largest key.

Your program should be based on a heap structure. The input must accept the different customers and their priorities (Customer Name and Customer Priority are two attributes that you must use). As an output, the program should produce a list of the customers based on their priorities (decreasing order). You may assume priorities are integers.

This is a sample output.txt file (spaces separating customer names (no space after the final name)):  
`Alan Paul`  
... for this input file (one customer and priority per line in this format):  
`Paul:2  
Alan:5`  
You can break ties in any order if their priorities are the same.   


## Solution
 
The solution given makes use of the following classes with each class having the given use:

**Teller.java:**
    This class is the class with the main(). It is used to get data from the input.txt, parse the data, convert it to a priority queue and then write the data to the output.txt

**Customer.java:**    
    This class defines the identity of the customer. It has only two properties: Name and Priority. The class also defines compareTo() which tell how two customers should be compared to each other

**Heap.java:**
    This class defines a generic heap structure. It makes use of List to store the data and exposes the data out as a heap using various functions like getParent(), getLeftNode, getRightNode, getNode, getRoot, etc. It also provides functions to maintain heap structure like maxHeapify, buildMaxHeap, etc.

**PriorityQueue:**
    This class extends the Heap class to make a priority queue in heap structure. It maintains it's own max heap structure throughout its lifetime. It provides the functionality of insert, extract_max, and max. After queue mutating operations like extract_max and insert the tree regains its heap property by performing maxHeapify on relevant property. Note it makes use of heap.java addNode() to insert a node which in itself performs maxHeapify
The solution given makes use of the following classes with each class having the given use:

Teller.java:
	This class is the class with the main(). It is used to get data from the input.txt, parse the data, convert it to a priority queue and then write the data to the output.txt

Customer.java:	
	This class defines the identity of the customer. It has only two properties: Name and Priority. The class also defines compareTo() which tell how two customers should be compared to each other

Heap.java:
	This class defines a generic heap structure. It makes use of List to store the data and exposes the data out as a heap using various functions like, getParent(), getLeftNode, getRightNode, getNode, getRoot, etc. It also provides functions to maintain heap structure like maxHeapify, buildMaxHeap, etc.

PriorityQueue:
	This class extends the Heap class to make a priority queue in heap structure. It is maintains it's own max heap structure throughout it's lifetime. It provides functionality of insert, extract_max, and max. After queue mutating operations like extract_max and insert the tree regains it's heap property by performing maxHeapify on relevant property. Note it makes use of heap.java addNode() to insert a node which in itself performs maxHeapify

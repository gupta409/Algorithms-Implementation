Problem #2
For this problem we make use of two classes:
HuffmanNode.java:	This is a class defining each node of the Huffman Tree. Each node has the following properties:
					Key: To identify the node. For a leaf node this defines the character
					Frequency: To identify the number of times this key appears in the string.
					LeftNode: Object of the left node in the Huffman Tree. It is null for a leaf node.
					RightNode: Object of the right node in the Huffman Tree. It is null for a leaf node.
					The class also provides functions to compare two nodes with each other.
					
HuffmanCode.java:	This class is the main class which performs Huffman Coding using the HuffmanNode. First the string in the input is processed to extract the HuffmanNodes for each of them. These HuffmanNodes are created with the help of a HashMap.
					Once all the huffman leaf nodes are found. A tree is created using the compress function. This function recursivly calls itself to make the Huffman Tree with the huffman coding algorithm.
					Finally the Huffman Tree is traversed for finding the huffman code for each of the Leaf nodes. This is also done using HashMaps to store the key,value pair of the charecter along with it's HuffmanCode.

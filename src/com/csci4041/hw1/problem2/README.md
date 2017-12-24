# Problem 2: Huffman Code

## Problem Statement
Build a data compression system using the Huffman’s algorithm. In other words, you are given a sequence of alphabet characters and you are asked to construct the Huffman’s code. Your “output.txt” file should have the bit representation for every character that appears in the file (and should not contain characters that are NOT present in the input file).  
Sample output.txt (any valid Huffman code in this format):  
```  
a:0 
b:101
c:100
d:111
e:1101
f:1100
```  
Sample input.txt (all characters on a single line with no spaces bewteen):  
`ffffeeeeeeeeefccccccccccccbbbbbbbbbbbbbddddddddddddddddaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa`  

## Solution
For this problem we make use of two classes:
**HuffmanNode.java:**
    This is a class defining each node of the Huffman Tree. Each node has the following properties:
    Key: To identify the node. For a leaf node, this defines the character
    Frequency: To identify the number of times this key appears in the string.
    LeftNode: Object of the left node in the Huffman Tree. It is null for a leaf node.
    RightNode: Object of the right node in the Huffman Tree. It is null for a leaf node.
    The class also provides functions to compare two nodes with each other.

**HuffmanCode.java:**
    This class is the main class which performs Huffman Coding using the HuffmanNode. First, the string in the input is processed to extract the HuffmanNodes for each of them. These HuffmanNodes are created with the help of a HashMap.
    Once all the Huffman leaf nodes are found. A tree is created using the compress function. This function recursively calls itself to make the Huffman Tree with the Huffman coding algorithm.
    Finally, the Huffman Tree is traversed for finding the Huffman code for each of the Leaf nodes. This is also done using HashMaps to store the key,value pair of the charecter along with it's HuffmanCode.

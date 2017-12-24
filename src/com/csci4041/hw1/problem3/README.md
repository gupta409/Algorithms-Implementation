# Problem 3: Selection Algorithm

## Problem Statement
Use _selection_ (i.e. average runtime of O(n)) to find the ith smallest number. The first number in the
text file (on its own line) will be “i”. The second line will the array of numbers which you want to
find the ith smallest. You may assume the array contains only integers.
Sample _output.txt_ (single number only):
`4`
Sample _input.txt_ (the first line will be the integer “i”, the second line will be array with spaces between
elements (no space after last)):
```
7
4 5 8 2 4 7 5 0 8 2 3 9 23 48 ­12 49
```

## Solution:

**Selection:**
The Selection class has a static function select which partitions the input based on a pivot, the last element of the input if the pivot is at the required selection index after partitioning it returns it as the answer. Else it recursively calls itself after shrinking the input.
It makes use of ArrayList to store the data. 
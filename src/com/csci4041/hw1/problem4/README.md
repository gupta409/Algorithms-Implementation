# Problem 4: Modified Bucket Sort

## Problem Statement
Assume you have a list of names that you want to sort in alphabetical order. Use bucket sort to solve this problem (i.e. the program should run in average case O(n)). However, use bucket sort recursively to ensure that each of the final buckets that are sorted via insertion sort contains no more than 10 elements/names. The way you would do this is when sorting each bucket, if there are more than 10 elements/names in the bucket then you would create sub-buckets and run a mini-bucket sort on only the elements in this large bucket. You may assume there are no spaces in the names and only contain normal English alphabet characters. Also, the first letter of names will be capitalized.  
Sample _output.txt_ (sorted name array separated by spaces (no space after final name)):  
`Candy Mahesh Rishi Svetovid`  
Sample _input.txt_ (unsorted names separated by spaces (no space after final name)):  
`Svetovid Candy Rishi Mahesh`  

## Solution

BucketSort is implemented with two functions:  

**sort(List<String>,int):**
    This function in the root function to call for performing BucketSort. It takes the data as a list of strings and the second parameter it takes is the depth with which the bucket sort begins. For all useful purposes, it should be zero while calling the function. This is required for the recursive nature of the BucketSort being done such that there cannot be more than 10 elements in a bucket.

**sort(List<String>):**
    This function is used to perform insertion sort on the List of strings. This is called by the bucketsort sort function to sort the list of 10 elements it has.
The implementation of bucketsort here first finds the total characters in the input and then decide how many buckets to be made. 
BucketSort is implemented with two functions:

sort(List<String>,int):
	This function in the the root function to call for performing BucketSort. It takes the data as a list of strings and the second parameter it takes is the depth with which the bucket sort begin. For all useful purposes the it should be zero while calling the function. This is required for the recursive nature of the BucketSort being done such that there cannot be more than 10 elements in a bucket.

sort(List<String>):
	This function is used to perform insertion sort on the List of strings. This is called by the bucketsort sort function to sort the list of 10 elements it has.
The implementation of bucketsort here first finds the total charecters in the input and then decideds how many buckets to be made. 

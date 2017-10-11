Selection:
The Selection class has a static function select which partitions the input based on a pivot, the last element of the input, if the pivot is at the required selection index after partitioning it returns it as the answer. Else it recursively calls itself after shrinking the input.
It makes use of ArrayList to store the data. 
# Topological Sort : Problem Statement
In this problem the input file will have classes listed with their prerequisites. Your output.txt should list
a valid order for taking all of these classes while meeting all the prerequisites.
You may assume there are no circular prerequisites (i.e. class A requires class B. Class B requires class
C. Class C requires class A). You may assume all classes that are prerequisites of another are listed.
The courses can be any string (not necessarily numbers)
Sample input file (course identifier before “:”. Prerequisites after “:” with spaces between):
```
1001:
1133:
2011:
1933:1133
4041:1933 2011
```
Sample output.txt (valid class ordering with spaces between (no space after final class)):
`1133 2011 1933 4041 1001`
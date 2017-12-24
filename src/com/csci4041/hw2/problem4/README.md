# Johnson's algorithm : Problem Statement

Implement _Johnson's algorithm_ to fin all pairs shortest paths. The input text file will contain the graph
represented as an adjacency matrix. Values of 2 millino will represent “infinity” edge weights (i.. when
there is no edge between vertexes). You can assume all pairs of shortest paths will be less than 2
million.
Your output.txt should contain a matrix of all pairs shortest paths (just the distances). If there is a
negative cycle present, output.txt should contain just the words (without quotes): “Negative cycle”.
The matrix for shortest paths should have spaces between the numbers and a single row on one line
(similar to the input file). The vertex order must also be the same as the input text file, so the first row
in the input text file must correspond to the shortest paths from the first vertex in output.txt.
Sample _input file #1_ (contains adjacency matrix):
```
0 2000000 4
2 0 7
2000000 3 0
```
Sample _output.txt_ (no trailing spaces after last number):
```
0 7 4
2 0 6
5 3 0
```
Sample _input file #2_ (contains adjacency matrix):
```
0 2000000 ­4
­1 0 7
2000000 ­2 0
```
Sample _output.txt_ (just this line and no other words):
`Negative cycle`
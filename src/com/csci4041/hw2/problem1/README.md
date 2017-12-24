# Finite Automata based String Matcher : Problem Statement

Make a string match program using a finite automata. However, you need to modify it so it finds the
patter either forwards or backwards. The first word in the input file is the pattern (on its own line).
The second word will be the string you are trying to match. Output all indexes where a match starts
happening.
You may assume we will only put the normal 26 English letters in lower case for both the pattern and
string. It is possible for a match to happen twice (if the pattern is symmetric). You should output the
index of this match twice then. Assume indexes start from 0.
Sample input file (all characters on a single line with no spaces between):
```
abcc 
abccbabcc
```
Corresponding sample output.txt file (spaces separating indexes (no space after final index)):
`0 2 5`
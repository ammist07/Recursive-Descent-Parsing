# Recursive-Descent-Parsing
Consider the following BNF grammar:

A -> I = E
E -> P O P | P
O -> + | - | * | / | **
P -> I | L | UI | UL | (E)
U -> + | - | !
I -> C | CI
C -> a | b | ... | y | z
L -> D | DL
D -> 0 | 1 | ... | 8 | 9
        
Using the technique described in class implement a recursive descent parser that recognizes strings in this language. 

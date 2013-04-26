Sixth Question Notes:

Word class:
- The Word class is used to encapsulate the word String and parent int used to remember the index in the words array of the BFS parent.

Words class:
 - The Words class contains the words list array and the search path algorithm.
	The populate method read the words from the file into the array.
	The findPath method is finds the path from one word to the other using a BFS approach.

!!!IMPORTANT!!! The algorithm is expecting errorless input. Meaning if you input an invalid word it will probably run forever in cycles or crash.
!!!IMPORTANT!!! The file input is static in dimensions and so are some parts of the algorithm. Any extra flexibility or error proofness could have been programmed if there was need for it.

Algorithm Complexity:

LEGEND:
n - amount of words

Time Complexity: O(n^2) - AT TOTAL WORST - Average case is alot less and hard to determine because it's word dependant.
Memory Complexity: O(n) - with a high constant factor but not high enough to call it O(n^2).


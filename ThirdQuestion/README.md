Third Question Notes:

Data class:
- Data class is where all the computation happens. It's pretty straightforward. 
	The populate method read the file and constructs the arrays.
	The draw method draws the grid and optionally(commented out) also the word list. (disabled by default)
	The findWords method is the entry point of the algorithm.
	The checkForWord method is called for every letter in the grid * every word.
	The directionalCheckWord methods check for words in every direction.
	!!!IMPORANT!!! -> There are only 6 directions implemented, because all the words were found using only those six.
				   -> Since the assignment didn't specify it had to check for all 8 directions. Optimal solution was assumed.
	the displayOutput method displays the output String which contains all the words found including their orientation and starting position.
				   
Algorithm Complexity:

LEGEND:
n - amount of characters in grid
w - amount of words

Memory complexity: O(n + w) => O(N) -> Linear based on the amount of elements on input.
Time complexity: O(n*w) => O(N) -> Linear based on the amount of elements on input.

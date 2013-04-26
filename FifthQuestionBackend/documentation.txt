Fifth Question Notes:

Score class:
- The Score class is an object used to encapsulate the String name, float score data pair.

HighScores class:
- The HighScores class is the class containing the high scores table and the sort function used to sort them.
	The sort method is the entry point of the quicksort algorithm.
	The quickSort method is the sorting algorithm of my choice used for sorting the high scores (smallest->largest)
	The partition method is a method used by the quickSort algorithm.
	The printScores method displays the contents of the highScores array from the last element to the first (results in the largest->smallest order)

!!!IMPORANT!!!The highScores table and insert method are static just for the purpose of this tutorial. Again, there's no other reason for them to be.
!!!IMPORANT!!!The quicksort algorithm is programmed staticly (it can work only with the highScores array and doesnt have a Comparer class parameter) just for the purpose of this tutorial.

Algorithm Complexity:

Memory Complexity: O(1) - The recursive quicksort doesnt construct any arrays. The sorting is done "in-place".

Time Complexity: O(N^2) - However the average case is O(N*log(N)) and is much more likely.

Solution Required Notes:

How to improve time complexity:
	First option: The quicksort algorithm can be optimized to improve the worst case performance to O(N*log(N)).
				  Additionally for arrays smaller than 10 elements (approx.). The insertion sort is prefferable due to its smaller constant factor.
	Second option: If the score values have a small range. (for example 0 - 100) The counting sort could be effectively used for large amounts of data.
				   This algorithm would improve the time complexity to (S + n) where S is the range of scores and n the amount of elements. Resulting in a linear time complexity.
	Third option: Paralellization of partitioning of different sections of the array. :) Wouldn't improve the time complexity of the algorithm itself, but the algorithm would finish faster.
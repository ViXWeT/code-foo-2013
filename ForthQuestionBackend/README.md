Forth Question Notes:

- The main method is loaded with a test case.

Person class:
- The Person class is the object used for defining a single family member.
- It stores the name String, generation int (just for output displaying - not required for the algorithm itself), children ArrayList<String>, and parents String[]

!!!IMPORTANT!!! The children and parents are stored as Strings for following reasons:
	1. If we saved children and parents as objects of Person class AND passed them by refference(default, means we wouldnt copy them),
		the refferences would become invalid every time the family tree sorts itself and the order changes.
	2. If we saved children and parents as objects of Person class AND copied them(passing by value),
		it would be false linking because the entries would be duplicates and couldn't really be considered part of the tree.
	- Therefore the children and parents are stored as strings and shall the need ever arise for somebody to access their objects in the tree,
	  they can do so by searching them considerably fast using the tree search functions.
	  
Family class:
- The Family class is the class containing the familyTree ArrayList<ArrayList<Person> > and all the search, sort and display functions required.
	The insert methods are implemented only for faster and clearer test cases input in the main() function.
	The sort method sorts the tree -> Each generation by name using a custom Comparator defined in Person class and optimized java Collections.sort.
	The searchByName method searches the whole tree for a match in name attribute of the Person class and returns an ArrayList<Person> in case multiple matches are found.
	The searchByGeneration method returns an entire generation without having to search for it.
	the searchByNameAndGeneration method searches the specified generation for a match in the name attribute of the Person class and returns a Person since there can't be two person in one generation with the same name.

!!!IMPORTANT!!! The Family class variables and methods are static just for the purpose of this example. There is no other reason for them to be.
	
Algorithm Complexity:

LEGEND:
g - number of generations
gn - number of people in g generation
n - number of people in the familyTree

Time Complexity:
	- Sorting: O(g*gn*log(gn)) => O(N*log(N))
	- SearchByName: O(g*log(gn)) => O(log(N)) per generation
	- SearchByGeneration: O(1) => Returning a generation is a constant time operation
	- SearchByNameAndGeneration: O(log(gn)) => O(log(N))

Alternative Solution:

The familyTree data container could have been also implemented as an n-ary tree and stored in a one dimensional array.
However for this solution to be effective the n-ary tree would have to be complete. 
Meaning every node would have to have the same amount of children. 
Which means if you had 10 parent pairs, 9 of them had 2 children, 1 of them had 10 children (just an example).
You'd have to make them all have 10 children (for example by storing nulls). 
Which would result in a waste of 72 Person objects in terms of memory.

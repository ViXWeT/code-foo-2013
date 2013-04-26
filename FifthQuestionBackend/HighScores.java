public class HighScores
{
	private static int n = 0;
	private static int lastIndex = 0;
	public static Score[] highScores;
	
	public static void setSize(int n)
	{
		HighScores.n = n;
		highScores = new Score[n];
	}
	
	public static int getSize()
	{
		return HighScores.n;
	}
	
	public static void printScores()
	{
		System.out.println("Scores ordered from the highest to the lowest:");
		for(int i = HighScores.n-1; i>-1; --i)
		{
			System.out.println("Name: "+ highScores[i].getName() + " Score: " + highScores[i].getScore());
		}
	}
	
	public static void insert(String name, double score)
	{
		if(n!=0&&lastIndex<n)
		{
			highScores[lastIndex]= new Score(name, (float)score);
			++lastIndex;
		}
	}
	
	public static void sort()
	{
		quickSort(0, highScores.length-1);
	}
	
	private static void quickSort(int left, int right)
	{
		int partitionBound = partition(left, right);
		if( left < partitionBound - 1)
			quickSort(left, partitionBound - 1);
		if( right > partitionBound)
			quickSort(partitionBound, right);
	}
	
	private static int partition(int left, int right)
	{
		int leftIterator = left;
		int rightIterator = right;
		Score swapTmp;
		float pivot = highScores[(left + right)/2].getScore();
		while(leftIterator <= rightIterator)
		{
			while(highScores[leftIterator].getScore() < pivot)
				++leftIterator;
			while(highScores[rightIterator].getScore() > pivot)
				--rightIterator;
			if(leftIterator <= rightIterator)
			{
				swapTmp = highScores[leftIterator];
				highScores[leftIterator] = highScores[rightIterator];
				highScores[rightIterator] = swapTmp;
				++leftIterator;
				--rightIterator;				
			}
		}
		
		return leftIterator;
	}
}
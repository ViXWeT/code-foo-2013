import java.util.Queue;
import java.util.LinkedList;
import java.io.*;

public class Words
{
	private static Word[] words = new Word[1012];
	
	public static void populate()
	{
		BufferedReader fileInput = null;
		try 
		{
			fileInput = new BufferedReader(new FileReader("three-letter-words.txt"));
			for (int i = 0; i<1012; i++)
			{
				words[i] = new Word(fileInput.readLine().toLowerCase());
			}
			
			fileInput.close();
			
		}
		catch(IOException e)
		{
			System.out.println("Something went wrong with loading the file");
		}
	}
	
	public static void findPath(String first, String second) //expects 2 valid words - no validity check
	{
		Queue<Integer> oneStep = new LinkedList<Integer>(); //BFS queue
		int indexFirst=-1;
		int difference=0;
		boolean found = false;
		int parentWord;
		String outputPath;
		
		for(int i = 0; i < 1012; i++)
		{
			if(words[i].getWord().compareTo(first)==0)
				indexFirst=i;
		}
		oneStep.add(indexFirst);
		
		while(!found)
		{
			parentWord = oneStep.poll();
			for(int i = 0; i < 1012; i++)
			{
				for(int j = 0; j< 3; j++)
				{
					if(words[parentWord].getWord().charAt(j)!=words[i].getWord().charAt(j))
					{
						++difference;
					}	
				}
				if(difference==1)
				{
					if(words[i].getWord().compareTo(second)==0)
					{
						int moves = 0;
						System.out.println("Path found:");
						outputPath=words[i].getWord() + " -> ";
						if(parentWord!=0)
						while(parentWord!=indexFirst)
						{
							outputPath+=words[parentWord].getWord() + " -> ";
							parentWord = words[parentWord].getParent();
							++moves;
						}
						++moves;
						outputPath+=words[indexFirst].getWord() + "." + " " + moves + " moves.";
						System.out.println(outputPath);
						return;
					}
					if(words[i].getParent()==0)words[i].setParent(parentWord); //once set, .parent cannot be rewriten
					oneStep.add(i);
				}
				difference=0;
			}
		}
	}
	
}
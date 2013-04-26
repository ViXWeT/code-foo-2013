import java.io.*;

public class Data {
	
	private static char[][] grid = new char[25][20];
	private static  String[] words = new String[24];
	private static String output = "";
	private static int count;
	private final static int MAXX=19;
	private final static int MAXY=24;
	
	public static void populate()
	{
		BufferedReader fileInput = null;
		try 
		{
			fileInput = new BufferedReader(new FileReader("word-search.txt"));
			for(int y = 0; y<grid.length; y++)
				for(int x = 0; x<grid[y].length; x++)
				{
					grid[y][x] = (char)fileInput.read();
					fileInput.read();
				}
			fileInput.readLine(); fileInput.readLine();
			for(int j = 0; j<words.length ; j++)
			{
				words[j] = fileInput.readLine();
				words[j] = words[j].replaceAll(" ", "");
				words[j] = words[j].toLowerCase();
			}
			fileInput.close();
			
		}
		catch(IOException e)
		{
			System.out.println("Something went wrong with loading the file");
		}
	}
	public static void display()
	{
		//Display grid
		for(int y = 0; y<grid.length; y++)
		{
			for(int x = 0; x<grid[y].length; x++)
			{
				System.out.print(grid[y][x]);
			}
			System.out.print("\n");
		}
		//Display words
		/*for(int y = 0; y<words[index]s.length; y++)
			System.out.println(words[index]s[y]); */
	}
	public static void displayOutput()
	{
		System.out.println(output);
		System.out.println("Total words[index]s found: " + count);
	}
	
	public static void findWords()
	{
		for(int y = 0; y<grid.length; y++)
			for(int x = 0; x<grid[y].length; x++)
				for(int i = 0; i<words.length; i++)
					if(words[i]!="")
						if(grid[y][x]==words[i].charAt(0))
							if(checkForWord(x,y,i))
								break;
	}
	
	public static boolean checkEast(int x, int y, int index)
	{
		if(words[index].length()<=(MAXX-x))
		{
			for(int i = 1;i<words[index].length();i++)
				if(grid[y][x+i]!=words[index].charAt(i))
					return false;
					
			output+="words[index] " + words[index] + " found at X: " + x + " and Y: " + y + ". Direction east.\n";
			count++;
			words[index]="";
			return true;
		}
		return false;
	}
	
	public static boolean checkSouthEast(int x, int y, int index)
	{
		if(words[index].length()<=(MAXX-x)&&words[index].length()<=(MAXY-y))
		{
			for(int i = 1, j = 1;i<words[index].length();i++,j++)
				if(grid[y+j][x+i]!=words[index].charAt(i))
					return false;
			output+="words[index] " + words[index] + " found at X: " + x + " and Y: " + y + ". Direction southeast.\n";
			count++;
			words[index]="";
			return true;
		}
		return false;
	}
	
	public static boolean checkSouth(int x, int y, int index)
	{
		if(words[index].length()<=(MAXY-y))
		{
			for(int j = 1;j<words[index].length();j++)
				if(grid[y+j][x]!=words[index].charAt(j))
					return false;
			output+="words[index] " + words[index] + " found at X: " + x + " and Y: " + y + ". Direction south.\n";
			count++;
			words[index]="";
			return true;
		}
		return false;
	}
	
	public static boolean checkWest(int x, int y, int index)
	{
		if(words[index].length()<=(x+1))
		{
			for(int i = 1;i<words[index].length();i++)
				if(grid[y][x-i]!=words[index].charAt(i))
					return false;
			output+="words[index] " + words[index] + " found at X: " + x + " and Y: " + y + ". Direction west.\n";
			count++;
			words[index]="";
			return true;
		}
		return false;
	}
	
	public static boolean checkSouthWest(int x, int y, int index)
	{
		if(words[index].length()<=(x+1)&&words[index].length()<=(MAXY-y))
		{
			for(int i = 1, j = 1;i<words[index].length();i++,j++)
				if(grid[y+j][x-i]!=words[index].charAt(i))
					return false;
			output+="words[index] " + words[index] + " found at X: " + x + " and Y: " + y + ". Direction southwest.\n";
			count++;
			words[index]="";
			return true;
		}
		return false;
	}
	
	public static boolean checkNorth(int x, int y, int index)
	{
		if(words[index].length()<=(y+1))
		{
			for(int j = 1;j<words[index].length();j++)
				if(grid[y-j][x]!=words[index].charAt(j))
					return false;
			output+="words[index] " + words[index] + " found at X: " + x + " and Y: " + y + ". Direction north.\n";
			count++;
			words[index]="";
			return true;
		}
		return false;
	}
	
	public static boolean checkForWord(int x, int y, int index)
	{
		if(checkEast(x,y,index)||checkSouthEast(x,y,index)||checkSouth(x,y,index)||checkSouthWest(x,y,index)||checkWest(x,y,index)||checkNorth(x,y,index)) 
			return true;
		else
			return false;
	}
}

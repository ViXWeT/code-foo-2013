import java.util.ArrayList;
import java.util.Comparator;
public class Person

{
	private String name = "Name Surname";
	private ArrayList<String> children;
	private String[] parents = new String[2];
	private int generation;
	
	public Person(String name, int generation)
	{
		this.name = name;
		this.generation = generation;
	}
	
	public Person(String name, int generation, String mother, String father)
	{
		this.name = name;
		this.generation = generation;
		this.parents[0] = mother;
		this.parents[1] = father;
	}
	
	public Person(String name, int generation, ArrayList<String> children)
	{
		this.name = name;
		this.generation = generation;
		this.children = children;
	}
	
	public Person(String name, int generation, String mother, String father, ArrayList<String> children)
	{
		this.name = name;
		this.generation = generation;
		this.parents[0] = mother;
		this.parents[1] = father;
		this.children = children;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getGeneration()
	{
		return this.generation;
	}
}

class PersonComparator implements Comparator<Person>
{
	public int compare(Person p1, Person p2)
	{
		if(p1.getName().compareTo(p2.getName())<0)
    		return -1;
		else if(p1.getName().compareTo(p2.getName())==0)
			return 0;
		else
			return 1;
	}
}
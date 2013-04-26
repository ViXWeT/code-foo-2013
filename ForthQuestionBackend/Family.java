import java.util.ArrayList;
import java.util.Collections;

public class Family
{
	//static just for the purpose of this example
	public static ArrayList<ArrayList<Person> > familyTree = new ArrayList<ArrayList<Person> >();
	private static boolean sorted = false;
	
	public static Person insert(String name, int generation)
	{
		Person tmp = (new Person(name, generation));
		familyTree.get(generation).add(tmp);
		sorted = false;
		return tmp;
	}
	
	public static Person insert(String name, int generation, String mother, String father)
	{
		Person tmp = (new Person(name, generation, mother, father));
		familyTree.get(generation).add(tmp);
		sorted = false;
		return tmp;
	}
	
	public static Person insert(String name, int generation, ArrayList<String> children)
	{
		Person tmp = (new Person(name, generation, children));
		familyTree.get(generation).add(tmp);
		sorted = false;
		return tmp;
	}
	
	public static Person insert(String name, int generation, String mother, String father, ArrayList<String> children)
	{
		Person tmp = (new Person(name, generation, mother, father, children));
		familyTree.get(generation).add(tmp);
		sorted = false;
		return tmp;
	}
	
	public static void sort()
	{
		for(int i=0; i<familyTree.size();i++)
		Collections.sort(familyTree.get(i), new PersonComparator());
		//Initialise generation properties of Person objects
		sorted = true;
	}
	
	public static ArrayList<Person> searchByName(String name)
	{
		if(!sorted) sort();
		ArrayList<Person> output = new ArrayList<Person>();
		for(int j = 0; j < familyTree.size(); j++)
		{
			int index = Collections.binarySearch(familyTree.get(j), new Person(name,-1), new PersonComparator());
			if(index>=0)output.add(familyTree.get(j).get(index));
		}
		return output;
	}
	
	public static ArrayList<Person> searchByGeneration(int generation)
	{
		if(!sorted) sort();
		return familyTree.get(generation);
	}
	
	public static Person searchByNameAndGeneration(String name, int generation)
	{
		if(!sorted) sort();
		Person output = new Person("Not found", -1	);
		int index = Collections.binarySearch(familyTree.get(generation), new Person(name,-1), new PersonComparator());
		if(index>=0)output=familyTree.get(generation).get(index);
		return output;
	}
}
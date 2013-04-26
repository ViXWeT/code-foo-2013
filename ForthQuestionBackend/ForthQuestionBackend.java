import java.util.ArrayList;

public class ForthQuestionBackend
{
	private static int MAXGenerations=3; //for this test case
	
	public static void main(String[] args)
	{		
		sampleTestCase();
	}
	
	private static void sampleTestCase()
	{
		for(int i = 0; i < MAXGenerations; i++)
			//adding generations to our familyTree
			Family.familyTree.add(new ArrayList<Person>()); 
		//adding sample people
		Family.insert("Anna Vasilievna", 0);
		Family.insert("Peter Vasilievny", 0);
		Family.insert("Ivan Vasilievny", 1, "Anna Vasilievna", "Peter Vasilievny"); //mother father constructor sample
		Family.insert("Andrej Vasilievny", 1);
		Family.insert("Anna Vasilievna", 2);
		Family.insert("Ivanovic Vasilievny", 2);
		Family.insert("Peter Vasilievny", 2);
		Family.sort();
		ArrayList<Person> output = Family.searchByGeneration(0); //returns whole generation
		Person outputPerson;
		System.out.println("Results of Generation search:");
		for(Person person : output)
		{			
			System.out.println("Name: "+ person.getName() + " Generation: " + person.getGeneration());
		}
		System.out.println();
		
		output = Family.searchByName("Peter Vasilievny"); //returns Peters from 2 generations - wouldn't return 2 from the same	
		System.out.println("Results of Name search:");
		for(Person person : output)
		{
			System.out.println("Name: "+ person.getName() + " Generation: " + person.getGeneration());
		}
		System.out.println();
		
		outputPerson = Family.searchByNameAndGeneration("Anna Vasilievna", 2); //returns Anna from THE specified generation
		System.out.println("Results from Name and Generation search:");
		System.out.println("Name: "+ outputPerson.getName() + " Generation: " + outputPerson.getGeneration());
	}
}
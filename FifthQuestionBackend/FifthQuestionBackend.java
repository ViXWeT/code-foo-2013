public class FifthQuestionBackend
{
	public static void main(String[] args)
	{
		HighScores.setSize(10);
		
		HighScores.insert("Player 1", 110.342); //java automaticly consideres dot point value a double apparently - thus the double type(just on input)
		HighScores.insert("Player 2", 90.234);
		HighScores.insert("Player 3", 90.34284);
		HighScores.insert("Player 4", 90.3462);
		HighScores.insert("Player 5", 70.5);
		HighScores.insert("Player 6", 120.88); //java automaticly consideres dot point value a double apparently - thus the double type(just on input)
		HighScores.insert("Player 7", 54.44563);
		HighScores.insert("Player 8", 65.4564);
		HighScores.insert("Player 9", 120.89);
		HighScores.insert("Player 10", 119);
		
		HighScores.sort();
		HighScores.printScores();	
	}
}

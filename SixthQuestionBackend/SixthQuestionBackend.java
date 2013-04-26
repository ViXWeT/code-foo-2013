public class SixthQuestionBackend
{
	public static void main(String[] args)
	{
		Words.populate();
		Words.findPath("cat", "dog");
	}
}
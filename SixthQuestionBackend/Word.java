public class Word
{
	private String word;
	private int parent = 0;
	
	public Word(String word)
	{
		this.word = word;
	}
	
	public String getWord()
	{
		return word;
	}
	
	public int getParent()
	{
		return parent;
	}
	
	public void setParent(int parent)
	{
		this.parent = parent;
	}
}
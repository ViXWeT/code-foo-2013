public class Score
{
	private String name;
	private float score;
	
	public Score(String name, float score)
	{
		this.name = name;
		this.score = score;
	}
	
	public float getScore()
	{
		return this.score;
	}
	
	public void setScore(float score)
	{
		this.score = score;
	}
	
	public String getName()
	{
		return this.name;
	}
}


public interface Question {
	public final int MULTIPLE_CHOICE = 1;
	public final int TRUE_FALSE = 0;
	public final int YES_NO = 2;
	
	public void setQuestionText(String question);
	public void setType(int type);
	
	
	
	public int getType();
	
	
}



public interface Question {
	public final int MULTIPLE_CHOICE = 1;
	public final int TRUE_FALSE = 0;
	public final int YES_NO = 2;
	
	public void setQuestionText(String question); 
	
	
	public boolean addAnswer(int index, String id);
	public int getType();
	public void resetQuestion();
	public int[] getCurrentResults();
	public String[] getAnswerString();
	
}

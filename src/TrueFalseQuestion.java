import java.util.HashSet;
import java.util.Set;


public class TrueFalseQuestion implements Question{
	
	private int answerTrackingArray[] = {0,0};
	private Set<String> voterIDs = new HashSet<String>();
	private int type = Question.TRUE_FALSE;
	private String[] answers = {"True", "False"};
	
	
	@Override
	public void setQuestionText(String question) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int getType() {
		return TRUE_FALSE;
	}


	@Override
	public boolean addAnswer(int index, String id) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetQuestion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] getCurrentResults() {
		// TODO Auto-generated method stub
		return answerTrackingArray;
	}

	@Override
	public String[] getAnswerString() {
		// TODO Auto-generated method stub
		return answers;
	}

}

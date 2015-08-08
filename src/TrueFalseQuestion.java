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
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void addAnswer(int index, String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetQuestion() {
		// TODO Auto-generated method stub
		
	}

}

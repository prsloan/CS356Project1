import java.util.HashSet;
import java.util.Set;


/**
 * The multiple choice question is a question with 5 options, A-E.
 * The class will keep track of valid answers submitted through the Vote Service class.
 * 
 * @author prsloan
 *
 */
public class MultipleChoiceQuestion implements Question{

	//variable to track the number of answers to the question
	private int answerTrackingArray[] = {0,0,0,0,0} ;
	private Set<String> voterIDs = new HashSet<String>();
	private String answers[] = {"A", "B","C", "D", "E"};
	
	
	
	@Override
	public void setQuestionText(String question) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return MULTIPLE_CHOICE ;
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

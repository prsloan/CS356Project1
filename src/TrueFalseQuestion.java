import java.util.HashSet;
import java.util.Set;

/**
 * This class implements the Question interface for a True/False type question.
 * @author prsloan
 *
 */
public class TrueFalseQuestion implements Question{
	
	private int answerTrackingArray[] = {0,0};
	private Set<String> voterIDs = new HashSet<String>();
	private String[] answers = {"True", "False"};
	private String questionText;
	
	private TrueFalseQuestion(){
		
	}
	
	/**
	 * A static factory contstructor
	 * @return
	 */
	public static TrueFalseQuestion newTrueFalseQuestion(){
		return new TrueFalseQuestion();
	}
	
	
	@Override
	/**
	 * Sets the question text.
	 * 
	 */
	public void setQuestionText(String question) {
		this.questionText = question;
		
	}
	
	@Override
	public int getType() {
		return TRUE_FALSE;
	}


	@Override
	public boolean addAnswer(int index, String id) {
		//validate values
		if (voterIDs.contains(id)){
			return false;  //this user has voted on this question already
		}
		else if((index < 0)||(index>1)){
			return false; //answer out of range
		}
		else{
		answerTrackingArray[index]++;	
		return true;
		}
		
	}

	@Override
	public void resetQuestion() {
		voterIDs.clear();
		answerTrackingArray[0] = 0;
		answerTrackingArray[1] = 0;
	}

	@Override
	public int[] getCurrentResults() {
		return answerTrackingArray;
	}

	@Override
	public String[] getAnswerString() {
		return answers;
	}

	@Override
	public String toString(){
		return questionText + " ? (True / False ) \n";
	}
}

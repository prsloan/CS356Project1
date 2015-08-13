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
	private String questionText;
	
	private MultipleChoiceQuestion(){
		
	}
	
	/**
	 * A static factory constructor
	 * 
	 * @return a new MultipleChoiceQuestion
	 */
	public static MultipleChoiceQuestion newMultipleChoiceQuestion(){
		return new MultipleChoiceQuestion();
	}
	
	
	
	
	
	@Override
	public void setQuestionText(String question) {
		this.questionText = question;
		
	}


	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return MULTIPLE_CHOICE ;
	}


	@Override
	public boolean addAnswer(int index, String id) {
		//validate values
		if (voterIDs.contains(id)){
			return false;  //this user has voted on this question already
		}
		else if((index < 0)||(index>4)){
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
		for(int i=0; i< answerTrackingArray.length; i++){
			answerTrackingArray[i] = 0;
		}
		
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

	
	@Override
	public String toString(){
		return questionText + " ?\n [A]\n[B]\n[C]\n[D]\n[E]";
	
		
	}
}

import java.util.ArrayList;
import java.util.List;


/**
 * By using enum, this insures that only one instance of the service
 * can be active at a time.  
 * 
 * 
 * @author prsloan
 *
 */
public enum IVoteService {
INSTANCE;

private List<Question> questionPool = new ArrayList<Question>();
private int votesAttempted = 0;
private int votesSuccessful = 0;

public static IVoteService getInstance(){
	return INSTANCE;
}

/**
 * This method adds a question to the question pool.
 * 
 * @param questionType  the type (based on the question interface constants)
 * @param question (the text of the question to be added)
 */
public void addQuestion(int questionType , String question){
	Question newQuestion;
	if (questionType == Question.MULTIPLE_CHOICE){
		newQuestion = MultipleChoiceQuestion.newMultipleChoiceQuestion();
		newQuestion.setQuestionText(question);
		questionPool.add(newQuestion);
	}
	else if(questionType == Question.TRUE_FALSE){
		newQuestion = TrueFalseQuestion.newTrueFalseQuestion();
		newQuestion.setQuestionText(question);
		questionPool.add(newQuestion);
	}
}

/**
 * This method will return the type of question at a given index.
 * 
 * 
 * @param index the number of the question in the question pool
 * @return the type of question based on the constants in the question interface
 */
public int getQuestionTypeAtIndex(int index) throws IllegalArgumentException{
	if (questionPool.get(index)==null){
		throw new IllegalArgumentException("Invalid question number.");
	}
	else
		return questionPool.get(index).getType();
}	

/**
 * This method processes a vote by a student, throwing an exception if the vote fails.
 * 
 * 
 * @param questionIndex
 * @param vote
 * @param voterID
 * @throws IllegalArgumentException 
 */
public void submitVote(int questionIndex, int vote, String voterID)throws IllegalArgumentException {
	//check question index to make sure question exists
	if (questionPool.get(questionIndex)==null){
		throw new IllegalArgumentException("Invalid question number.");
	}
	//check that the vote is within the allowed range for the question type
	else if(questionPool.get(questionIndex).addAnswer(vote, voterID)){
		votesAttempted++;
		votesSuccessful++;
	}
	//otherwise means vote failed, throw an exception
	else{
		votesAttempted++;
		throw new IllegalArgumentException("Invalid vote.");
	}
}

/**
 * This method will return a formatted string that can be used to display results of a particular question.
 * 
 * 
 * @param questionIndex
 * @return
 * @throws IllegalArgumentException
 */
public String displayCurrentResultsForQuestionAtIndex(int questionIndex)throws IllegalArgumentException{
	StringBuilder resultString = new StringBuilder();
	String[] answerString;
	int[] results;
	
	//check question index to make sure question exists
	if (questionPool.get(questionIndex)==null){
			throw new IllegalArgumentException("Invalid question number.");
	}
	//question exists
	else{
		answerString = questionPool.get(questionIndex).getAnswerString();
		results = questionPool.get(questionIndex).getCurrentResults();
		resultString.append("Question #"+questionIndex+" results :");
		for(int i=0; i<results.length;i++){
			resultString.append("[ "+ answerString[i] + " ] :" + results[i] + "\t");
		}
		resultString.append("\n");
		return resultString.toString();
		
	}
}

/**
 * used for testing
 * 
 * @return
 */
public int getVoteAttempts(){
	return votesAttempted;
}

/**
 * used for testing
 * 
 * @return
 */
public int getSuccessfulVotes(){
	return votesSuccessful;
}



}

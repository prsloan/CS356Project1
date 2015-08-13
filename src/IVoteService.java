import java.util.ArrayList;
import java.util.List;



public enum IVoteService {
INSTANCE;

private List<Question> questionPool = new ArrayList<Question>();
private int votesAttempted = 0;
private int votesSuccessful = 0;

public static IVoteService getInstance(){
	return INSTANCE;
}


public void addQuestion(int questionType , String question){
	Question newQuestion;
	if (questionType == Question.MULTIPLE_CHOICE){
		newQuestion = new MultipleChoiceQuestion();
		newQuestion.setQuestionText(question);
		questionPool.add(newQuestion);
	}
	else if(questionType == Question.TRUE_FALSE){
		newQuestion = new TrueFalseQuestion();
		newQuestion.setQuestionText(question);
		questionPool.add(newQuestion);
	}
}




public int getQuestionTypeAtIndex(int index){
	return questionPool.get(index).getType();
}

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

public int getVoteAttempts(){
	return votesAttempted;
}

public int getSuccessfulVotes(){
	return votesSuccessful;
}



}

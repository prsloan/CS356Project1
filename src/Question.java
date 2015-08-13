
/**
 * This interface describes a general purpose object for a tally type question.
 * 
 * @author prsloan
 *
 */
public interface Question {
	public final int MULTIPLE_CHOICE = 1;
	public final int TRUE_FALSE = 0;
	public final int YES_NO = 2;
	
	/**
	 * Sets the question text
	 * 
	 * @param question
	 */
	public void setQuestionText(String question); 
	
	/**
	 * This method takes in the value of the answer and the id of the user submitting 
	 * the vote, and adds the vote to the current total.  It validates the answer is in
	 * the appropriate range and returns a boolean value if successfful.
	 * 
	 * @param index
	 * @param id
	 * @return true if the answer was successful
	 */
	public boolean addAnswer(int index, String id);
	/**
	 * 
	 * @return The type of the question, based on the constants defined.
	 */
	public int getType();
	/**
	 * Resets the values of the results and the id Table so another vote could be taken on the same question
	 */
	public void resetQuestion();
	/**
	 * 
	 * @return the current vote tally for the question
	 */
	public int[] getCurrentResults();
	/**
	 * 
	 * @return the string of the answers (ex. : A, B, C... or True/False)
	 */
	public String[] getAnswerString();
	
}

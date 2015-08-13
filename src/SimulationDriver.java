import java.util.Random;



public class SimulationDriver {

	public static void main(String[] args) {
		//Create 100 Students
		Student[] students = new Student[100];
		//voting service
		IVoteService iVote = IVoteService.INSTANCE;
		//new random number generator
		Random r = new Random();
		
		
		
		//First we Populate there service with 25 questions of a random type.
		//the random int (0 or 1) will decide if the question is true/false or multiple choice
		//for the simulation, question text will be left blank
		for (int i=0; i<25;i++){
			int type = r.nextInt(2); //random int, either 0 or 1
			iVote.addQuestion(type, "");
		}
		//for each student, they will vote on each question, at random
		for(Student s : students){
			//initialize the student
			s= Student.newStudent();
			//for each question
			for(int j=0; j<25;j++){
				int vote = -1; //initialize to an invalid answer
				int currentType = iVote.getQuestionTypeAtIndex(j);	
				//randomize the vote
				if (currentType == Question.MULTIPLE_CHOICE){
					vote = r.nextInt(5);
					}
				else if (currentType == Question.TRUE_FALSE){
					vote = r.nextInt(2);
				}
				iVote.submitVote(j, vote, s.getID()); //submit the vote			
			}
		}
		
		
		//print the results for each question
		for (int k=0; k<25;k++){
			System.out.println(iVote.displayCurrentResultsForQuestionAtIndex(k));
		}
		
		
	}

}

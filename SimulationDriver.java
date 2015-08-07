package CS356Project1;

public class SimulationDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] students = new Student[100];
		
		for (Student s: students){
			s = Student.newStudent();
			System.out.println(s.getID());
		}
		
		
		
		
	}

}

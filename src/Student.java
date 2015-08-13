

import java.util.UUID;


/**
 * 
 * A simple Student class that has a uniquely generated id.
 * 
 */
public class Student {

private String id;


private Student(){
 id = UUID.randomUUID().toString();	
}

/**
 * Static Factory Constructor method.  Trying this out.
 * 
 * @return
 */
public static Student newStudent(){
	return new Student();
}


/**
 * returns the id for the Student, a 128-bit random id
 * 
 * @return
 */
public String getID(){
	return id;
}
	
}

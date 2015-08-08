

import java.util.UUID;
public class Student {

private String id;

private Student(){
 id = UUID.randomUUID().toString();	
}

/**
 * Static Constructor method.  Trying this out.
 * 
 * @return
 */
public static Student newStudent(){
	return new Student();
}



public String getID(){
	return id;
}
	
}

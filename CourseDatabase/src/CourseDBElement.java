import java.util.LinkedList;

public class CourseDBElement implements Comparable<CourseDBElement> {
	
	private String id ;
	private int crn;
	private int credits ;
	private String roomNum ;
	private String instructor ;
	private CourseDBElement cde;
	private LinkedList <Integer> list;
	
	/**
	 * default constructor 
	 */
	public CourseDBElement(String id,int crn,int credits,String roomNum,String instructor) {
		this.id = id;
		this.crn = crn;
		this.credits =credits;
		this.roomNum = roomNum;
		this.instructor = insrtuctor; 
		list = new LinkedList<Integer>();
		
		
	}
	
	
	
	

}

package model;

public class Course
{
	/**************************************************
	 * variable declarations
	 *************************************************/
	
	private String number;
	private String name;
	private String section;
	private int numStudents;
	final private int MAX_ENROLLMENT = 25;

	
	/**
	 * Constructor
	 * @param courseNumber the course's number
	 * @param courseName the course's name
	 * @param courseSection the course's section
	 */
	public Course(String courseNumber, String courseName, String courseSection)
	{
		number = courseNumber;
		name = courseName;
		section = courseSection;
		numStudents = 0;
	}

	public String getName()
	{
		return name;
	}
	
	public String getNumber()
	{
		return number;
	}
	
	public String getSection()
	{
		return section;
	}
	
	
	/**
	 * Adds a student to the course, increasing the number of
	 * students enrolled by one
	 * @return true if the student was successfully added; false otherwise
	 */
	public boolean addStudent()
	{
		boolean success = true;
		if(numStudents < MAX_ENROLLMENT)
		{
			numStudents++;
		} 
		else 
		{
			success = false;
		}
		return success;
	}
	
	
	/**
	 * Drops a student from the course, decreasing the number of
	 * students enrolled by one
	 * @return true if the student was successfully dropped; false otherwise
	 */
	public boolean dropStudent()
	{
		boolean success = true;
		if(numStudents > 0)
		{
			numStudents--;
		} 
		else 
		{
			success = false;
		}
		return success;
	}

}

package model;

import java.util.HashMap;

public class Student
{
	/**************************************************
	 * variable declarations
	 *************************************************/
	
	// TO-DO: Your variables/constants go here
	int studentID;
	String firstName;
	String lastName;
	HashMap<String, Course> schedule = new HashMap<String, Course>();

	/**
	 * Constructs a Student object
	 * 
	 * @param id the student's id number
	 * @param firstName the student's first name
	 * @param lastName the student's last name
	 */
	public Student(int id, String firstName, String lastName)
	{
		// TO-DO: Your code goes here
		studentID = id;
		this.firstName = firstName;
		this.lastName = lastName;

	}

	
	/**
	 * Returns the student's ID
	 * @return the student's ID
	 */
	public int getStudentID()
	{
		// TO-DO: Your code goes here
		return studentID;

	}

	
	/**
	 * Returns the student's first name
	 * @return the student's first name
	 */
	public String getFirstName()
	{
		// TO-DO: Your code goes here
		return firstName;

	}

	
	/**
	 * Returns the student's last name
	 * @return the student's last name
	 */
	public String getLastName()
	{
		// TO-DO: Your code goes here
		return lastName;

	}

	/**
	 * Adds a course to the student's schedule
	 * @param newCourse the course to add the student's schedule
	 * @return true if course added successfully; otherwise, return false
	 */
	public boolean addCourse(Course newCourse)
	{
		// TO-DO: Your code goes here
		if (schedule.size() >= 7 || schedule.containsValue(newCourse))
		{
			return false;
			
		}
		else
		{
			schedule.put(newCourse.getNumber(), newCourse);
			return true;
		}

	}

	
	/**
	 * Drops a course from the student's schedule
	 * @param courseToDrop the course number of the course to drop
	 */
	public void dropCourse(String courseToDrop)
	{
		// TO-DO: Your code goes here
		if (schedule.containsKey(courseToDrop))
		{
			schedule.remove(courseToDrop);
		}
	}
	
	
	/**
	 * Returns the student's schedule
	 * @return the student's schedule as a Map
	 */
	public HashMap<String, Course> getSchedule()
	{
		// TO-DO: Your code goes here
		return schedule;
	}
}

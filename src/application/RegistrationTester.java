package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.Scanner;
import model.*;

import model.Course;

public class RegistrationTester
{

	public static void main(String[] args)
	{
		// variables for the reading the course file
		final String courseFilePath = "src/data/courses.txt";
		FileManager fileManager = null;
		
		
		try
		{
			// Open the data file
			fileManager = new FileManager(courseFilePath);
			Scanner scan = new Scanner(System.in);
			
			
			// Get Input
			System.out.println("Please enter a student ID: ");
			int newID = scan.nextInt();
			System.out.println("Please enter a First Name: ");
			String newFirstName = scan.next();
			System.out.println("Please enter a Last Name: ");
			String newLastName = scan.next();
			
			//Use input to make new student entry
			Student newStudent = new Student(newID, newFirstName, newLastName);
			HashMap<String, Course> newSchedule = newStudent.getSchedule();

			
			System.out.println("Please enter a Course Number (ex: AC220) or D to be done: ");
			String newCourseNumber = scan.next();
			
			HashMap <String, Course> masterSchedule = fileManager.getCourses();
			Course newCourse = masterSchedule.get(newCourseNumber);
			
			while (!newCourseNumber.equalsIgnoreCase("d"))
			{
				//Check if course number is valid
				if (!masterSchedule.containsKey(newCourseNumber))
				{
					System.out.println("That course is not available this semester. Please choose another");
					System.out.println("Please enter a Course Number (ex: AC220) or type 'd' to be done: ");
					newCourseNumber = scan.next();
				}
				else
				{
					newCourse = masterSchedule.get(newCourseNumber);
					if (hasTimeConflict(newCourse, newSchedule))
					{
						System.out.println("That course is already on your schedule. Please choose another");
					}
					
					else
					{
					
						if (newStudent.addCourse(newCourse) == true && newCourse.addStudent() == true)
						{
							//Not sure if i have to repeat code of adding student to course and course to schedule
							//or if it is actually done in the if statement when true.
							System.out.println("Enrolled successfully into: " + newCourseNumber + " " + newCourse.getName());
						
						}
						else
						{
							System.out.println("You were not enrolled into this course due to a full schedule. Please quit as you cannot add anymore courses.");
						}
					}
						
				}
					
				System.out.println("Please enter a Course Number (ex: AC220) or D to be done: ");
				newCourseNumber = scan.next();
						
				}
				
				
			
			scan.close();
			if (newCourse.getNumber() != null)
			{
				String droppedCourse = newCourse.getNumber();
				newStudent.dropCourse(droppedCourse);
				newCourse.dropStudent();
				
				System.out.println("Course: " + droppedCourse  + " has been dropped." + "\n");
			}
			System.out.println("Here is your schedule: ");
			
			if (newSchedule.values().isEmpty())
			{
				System.out.println("You have no classes!");
			}
			else
			{
				for(Course course: newSchedule.values())
				{
					System.out.println("\n" + course.getNumber() + " " + course.getSection() + " " + course.getName());
					
				}
				
			}
						
		}
		catch (FileNotFoundException fe)
		{
			System.out.println(fe.getMessage());
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static boolean hasTimeConflict(Course myCourse, HashMap<String, Course> schedule)
	{
		/*
		 * Variable Declarations
		 *    boolean conflict = FALSE
		 *    
		 *    Set<String> courseNumbers
		 *    Course otherCourse
		 *    String myCourseSection
		 *    String otherCourseSection
		 *    
		 *    Set myCourseSection = myCourse's section
		 *    Set courseNumbers = schedule's key set
		 *    
		 *    For each course number in courseNumbers
		 *       Set otherCourse = schedule.get(course number)
		 *       Set otherCourseSection = otherCourse's section
		 *       
		 *       If otherCourseSection equals myCourseSection
		 *       	Set conflict = TRUE
		 *       End-If
		 *    End-For
		 *    
		 *    return conflict
		 */
		boolean conflict = false;
		Course otherCourse;
		String myCourseSection;
		String otherCourseSection;
		Set<String> courseNumbers;
		
		myCourseSection = myCourse.getSection();
		courseNumbers = schedule.keySet();
		
		for (String number : courseNumbers)
		{
			otherCourse = schedule.get(number);
			otherCourseSection = otherCourse.getSection();
			
			if (otherCourseSection.equals(myCourseSection))
			{
				conflict = true;
			}
		}
		return conflict;
		
	}
	
}

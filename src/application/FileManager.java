package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import model.Course;

public class FileManager
{
	private HashMap<String, Course> courses;

	/**
	 * Constructor
	 * 
	 * @param filePath
	 *            the path of the file to read
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public FileManager(String filePath) throws FileNotFoundException, IOException
	{
		courses = new HashMap<String, Course>();
		this.readFile(filePath);
	}

	/**
	 * Opens and reads the file at the given file path
	 * 
	 * @param filePath
	 *            the path to the file to read
	 * @return the contents of the file
	 * @throws FileNotFoundException,
	 *             IOException
	 */
	public void readFile(String filePath) throws FileNotFoundException, IOException
	{

		// Open the file for reading
		BufferedReader reader = new BufferedReader(new FileReader(filePath));

		// To (temporarily) store each line of the file
		String line = null;

		// While there are still lines in the file to read
		while ((line = reader.readLine()) != null)
		{
			// Split the line of text on tabs
			String[] parts = line.split("\t");

			String courseNumber = parts[0];
			String courseName = parts[1];
			String section = parts[2];

			// Create a Course object, and add it to the schedule
			Course c = new Course(courseNumber, courseName, section);
			courses.put(courseNumber, c);
		}
		reader.close();
	}

	/**
	 * Writes the given text to the file at the given file path
	 * 
	 * @param text
	 *            the contents to write
	 * @param writePath
	 *            the path to the file in which to write
	 */
	public void writeFile(String text, String writePath)
	{
		// Open a FileWriter within a BufferedWriter
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(writePath)))
		{
			// Write 'text' to the file
			writer.write(text);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public HashMap<String, Course> getCourses()
	{
		return courses;
	}

}

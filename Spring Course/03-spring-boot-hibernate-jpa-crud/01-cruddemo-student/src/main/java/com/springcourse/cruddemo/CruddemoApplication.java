package com.springcourse.cruddemo;

import com.springcourse.cruddemo.dao.StudentDAO;
import com.springcourse.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	//This method will execute after the Spring beans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner -> {

			//createMultipleStudents(studentDAO);

			//findStudentById(studentDAO); 

			//findAllStudents(studentDAO);

			findStudentByLastName(studentDAO);
		};
	}


	//CREATE
	private void createMultipleStudents(StudentDAO studentDAO) {

		//create a new Student object
		System.out.println("Creating 3 new Students ...");
		Student newStudent1 = new Student("John", "turner", "john@gmail.com");
		Student newStudent2 = new Student("Jones", "blevins", "jones@gmail.com");
		Student newStudent3 = new Student("Rebecca", "hayden", "rebecca@gmail.com");
		//Save the student object
		System.out.println("Saving the students ...");
		studentDAO.save(newStudent1);
		studentDAO.save(newStudent2);
		studentDAO.save(newStudent3);

		//Print the saved student's ID
		System.out.println("Saved Student1's Id: " + newStudent1.getId());
		System.out.println("Saved Student2's Id: " + newStudent2.getId());
		System.out.println("Saved Student3's Id: " + newStudent3.getId());
	}

	//FIND
	private void findStudentById(StudentDAO studentDAO) {

		//create a new student object
		System.out.println("Creating the Student...");
		Student newStudent = new Student("Daffy", "Duck", "daffy@gmail.com");

		//save the student in the database
		System.out.println("Saving the student...");
		studentDAO.save(newStudent);

		//display the student's Id from the database
		int theId = newStudent.getId();
		System.out.println("Saved student Id is: " + theId);

		//Retrieve the student from the database by the given Id: primary key
		System.out.println("Finding the Student with Id: " + theId);
		Student foundStudent = studentDAO.findById(theId);

		//Display the Student found
		if(foundStudent != null)
		{
			System.out.println("Student with the given Id: " + theId + " found! : " +foundStudent);
		}
		else {
			System.out.println("Student with the given Id: " + theId + "not found!");
		}

	}

	//READ / QUERY
	private void findAllStudents(StudentDAO studentDAO) {
		//find all Students
		List<Student> allStudents = studentDAO.findAll();

		//Display the Students
		for(Student student: allStudents)
		{
			System.out.println(student);
		}
	}

	//QUERY by Parameter
	private void findStudentByLastName(StudentDAO studentDAO)
	{
		//find all Students
		List<Student> allStudents = studentDAO.findStudentByLastName("Duck");

		//Display the Students
		for(Student student: allStudents)
		{
			System.out.println(student);
		}
	}


}

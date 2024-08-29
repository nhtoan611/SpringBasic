package com.nhtoan611.cruddemo;

import com.nhtoan611.cruddemo.dao.StudentDAO;
import com.nhtoan611.cruddemo.entity.Student;
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

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudent(studentDAO);
//			readStudent(studentDAO);
//			readAllStudent(studentDAO);
//			findStudentByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		int deleteCount = studentDAO.deleteALl();
		System.out.println("Delete " + deleteCount + " rows");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		Integer studentId = 1;
		Student studentById = studentDAO.findById(studentId);
		studentById.setFirstName("toanpr0");
		studentDAO.update(studentById);
		System.out.println("Update success: " + studentById);
	}

	private void findStudentByLastName(StudentDAO studentDAO) {
		String filterLastName = "thu";
		List<Student> resultStudent = studentDAO.findByLastName(filterLastName);
		for (Student student: resultStudent) {
			System.out.println(student);
		}
	}

	private void readAllStudent(StudentDAO studentDAO) {
		List<Student> allStudents = studentDAO.findAll();
		for (Student student : allStudents) {
			System.out.println(student.toString());
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student insertStudent = new Student("trang", "thu", "tt@gmail.com");
		studentDAO.save(insertStudent);
		System.out.println("Insert success!");

		// Get student
		Student insertedStudent = studentDAO.findById(insertStudent.getId());
		System.out.println("Inserted student: " + insertedStudent.toString());

	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		for (int i = 0; i < 10; i++) {
			Student tempStudent = new Student("first name " + i, "last name " + i, "toan611 " + i + "@gmail.com");
			studentDAO.save(tempStudent);
		}
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Create student object");
		Student tempStudent = new Student("toan", "nguyen", "nhtoan611@gmail.com");

		studentDAO.save(tempStudent);

		System.out.println("Saved student: " + tempStudent.getId());
	}

}

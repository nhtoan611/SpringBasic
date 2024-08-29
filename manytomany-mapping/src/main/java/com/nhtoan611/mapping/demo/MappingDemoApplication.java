package com.nhtoan611.mapping.demo;

import com.nhtoan611.mapping.demo.dao.AppDAO;
import com.nhtoan611.mapping.demo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MappingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createCourseAndStudent(appDAO);
//			findCourseAndStudentById(appDAO);
//			findStudentAndCourseById(appDAO);
//			udpateCourseOfStudent(appDAO);
//			deteleCourse(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int studentId = 1;
		appDAO.deleteStudent(studentId);
	}

	private void udpateCourseOfStudent(AppDAO appDAO) {
		int id = 1;
		Student s1 = appDAO.findStudentAndCourseById(id);
		s1.addCourse(new Course("Travel around the world"));
		s1.addCourse(new Course("Namba cafe"));

		appDAO.updateStudent(s1);
		System.out.println("Saved!!!");
	}

	private void findStudentAndCourseById(AppDAO appDAO) {
		int id = 1;
		Student s1 = appDAO.findStudentAndCourseById(id);
		System.out.println(s1);
		s1.getCourses().forEach(data -> System.out.println(data));
	}

	private void findCourseAndStudentById(AppDAO appDAO) {
		int id = 10;
		Course course = appDAO.findCourseAndStudentById(id);
		System.out.println("Course: " + course);
		course.getStudents().forEach(data -> System.out.println(data));
	}

	private void createCourseAndStudent(AppDAO appDAO) {
		Course c1 = new Course("Hello worlld");
//		Course c2 = new Course("Travel around the worlld");
		Student s1 = new Student("toan", "nguyen", "nhtoan611@gmail.com");
		Student s2 = new Student("ha", "nguyen", "hant@gmail.com");

		c1.addStudent(s1);
		c1.addStudent(s2);

		appDAO.saveCourse(c1);

		System.out.println("Saved!!");
	}

	private void deteleCourseAndReview(AppDAO appDAO) {
		int id = 10;
		appDAO.deleteCourse(id);
	}

	private void getCourseAndReview(AppDAO appDAO) {
		int id = 10;
		Course course = appDAO.findCourseAndReviewById(id);
		System.out.println("Course: " + course);
		System.out.println("Review: ");
		course.getReviews().forEach(data -> {
			System.out.println(data);
		});
	}

	private void addCourseWithReview(AppDAO appDAO) {
		Course course = new Course("This is my new book");
		course.addReview(new Review("I fucken love this book"));
		course.addReview(new Review("amazing book"));
		course.addReview(new Review("rate me 5 stars"));

		appDAO.saveCourse(course);
		System.out.println("Saved!!");
	}

	private void deleteCourseBatch(AppDAO appDAO) {
		List<Integer> courseIds = Arrays.asList(11, 12);
		appDAO.deleteCourse(courseIds);
	}

	private void deteleCourse(AppDAO appDAO) {
		int id = 10;
		appDAO.deleteCourse(id);
	}

	private void updateCourse(AppDAO appDAO) {
		Course course = appDAO.findCourseById(10);
		course.setTitle("Enjoy happy day");
		appDAO.updateCourse(course);
	}

	private void updateInstructor(AppDAO appDAO) {
		Instructor instructor = appDAO.findById(1);
		instructor.setEmail("nhtoan611@gmail.com");
		appDAO.updateInstructor(instructor);
	}

	private void findInstructorWithJoinFetch(AppDAO appDAO) {
		int instructorId = 1;
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(instructorId);
		System.out.println("Instructor: " + instructor);
		System.out.println("Courses: " + instructor.getCourses());
		System.out.println("Instructor Detail: " + instructor.getInstructorDetail());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int instructorId = 1;
		Instructor instructor = appDAO.findById(instructorId);
		System.out.println("Instructor: " + instructor);
		List<Course> courses = appDAO.findCoursesByInstructorId(instructorId);
		instructor.setCourses(courses);
		System.out.println("Courses: " + instructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("toan", "nguyen", "nhtoan911@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("vl.youtube", "games, books");
		instructor.setInstructorDetail(instructorDetail);

		Course tmpCourse1 = new Course("Hello world");
		Course tmpCourse2 = new Course("Java Spring");
		Course tmpCourse3 = new Course("Hibernate");
		instructor.add(tmpCourse1);
		instructor.add(tmpCourse2);
		instructor.add(tmpCourse3);

		appDAO.save(instructor);
		System.out.println("Saved!!!");
	}

	private void deleteDetail(AppDAO appDAO) {
		int id= 4;
		appDAO.deleteDetail(id);
		System.out.println("Deleted!!!");
	}

	private void findDetailInstructor(AppDAO appDAO) {
		int id = 3;
		InstructorDetail instructorDetail = appDAO.findDetailById(id);
		System.out.println("Instructor: " + instructorDetail.getInstructor());
		System.out.println("Instructor detail " + instructorDetail);
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		appDAO.deleteInstructor(id);
		System.out.println("Delete data!!!");
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findById(id);
		System.out.println("Instructor: " + instructor);
		System.out.println("Instructor detail " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("ha", "nguyen", "hanh@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("hanh", "gym, girls");
		instructor.setInstructorDetail(instructorDetail);
		appDAO.save(instructor);
		System.out.println("Save data!!!");
	}

}

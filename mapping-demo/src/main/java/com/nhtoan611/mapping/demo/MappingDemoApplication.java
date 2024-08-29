package com.nhtoan611.mapping.demo;

import com.nhtoan611.mapping.demo.dao.AppDAO;
import com.nhtoan611.mapping.demo.entity.Instructor;
import com.nhtoan611.mapping.demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MappingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findDetailInstructor(appDAO);
			deleteDetail(appDAO);
		};
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
		int id = 2;
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

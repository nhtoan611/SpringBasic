package com.nhtoan611.mapping.demo.dao;

import com.nhtoan611.mapping.demo.entity.Course;
import com.nhtoan611.mapping.demo.entity.Instructor;
import com.nhtoan611.mapping.demo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findById(int id);

    void deleteInstructor(int id);

    InstructorDetail findDetailById(int id);

    void deleteDetail(int id);

    List<Course> findCoursesByInstructorId(int instructorId);

    Instructor findInstructorByIdJoinFetch(int isntructorId);

    void updateInstructor(Instructor instructor);

    void updateCourse(Course course);

    Course findCourseById(int courseId);

    void deleteCourse(int courseId);

    void deleteCourse(List<Integer> courseIds);

    void saveCourse(Course course);

    Course findCourseAndReviewById(int id);
}

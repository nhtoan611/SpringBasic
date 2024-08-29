package com.nhtoan611.mapping.demo.dao;

import com.nhtoan611.mapping.demo.entity.Course;
import com.nhtoan611.mapping.demo.entity.Instructor;
import com.nhtoan611.mapping.demo.entity.InstructorDetail;
import com.nhtoan611.mapping.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{
    private EntityManager entityManager;

    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructor(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);

        List<Course> list = instructor.getCourses();
        list.forEach(course -> {
            course.setInstructor(null);
        });

        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteDetail(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int instructorId) {
        TypedQuery typedQuery = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        typedQuery.setParameter("data", instructorId);
        return typedQuery.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int isntructorId) {
        TypedQuery<Instructor> typedQuery = entityManager.createQuery("select i from Instructor i " +
                        "JOIN FETCH i.courses " +
                        "where i.id = :data",
                Instructor.class);
        typedQuery.setParameter("data", isntructorId);
        return typedQuery.getSingleResult();
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int courseId) {
        return entityManager.find(Course.class, courseId);
    }

    @Override
    @Transactional
    public void deleteCourse(int courseId) {
        Course course = entityManager.find(Course.class, courseId);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void deleteCourse(List<Integer> courseIds) {
        courseIds.forEach(id -> {
            Course course = entityManager.find(Course.class, id);
            entityManager.remove(course);
        });
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewById(int id) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c " +
                "JOIN FETCH c.reviews " +
                "where c.id = :data", Course.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    public Course findCourseAndStudentById(int id) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c " +
                "JOIN FETCH c.students " +
                "where c.id = :data", Course.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    public Student findStudentAndCourseById(int id) {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s " +
                "JOIN FETCH s.courses " +
                "where s.id = :data", Student.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int studentId) {
        Student student = entityManager.find(Student.class, studentId);
        entityManager.remove(student);
    }
}

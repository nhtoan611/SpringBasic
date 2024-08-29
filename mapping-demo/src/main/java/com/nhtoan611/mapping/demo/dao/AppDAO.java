package com.nhtoan611.mapping.demo.dao;

import com.nhtoan611.mapping.demo.entity.Instructor;
import com.nhtoan611.mapping.demo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findById(int id);

    void deleteInstructor(int id);

    InstructorDetail findDetailById(int id);

    void deleteDetail(int id);
}

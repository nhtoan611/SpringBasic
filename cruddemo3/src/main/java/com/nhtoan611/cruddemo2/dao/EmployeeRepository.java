package com.nhtoan611.cruddemo2.dao;

import com.nhtoan611.cruddemo2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

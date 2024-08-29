package com.nhtoan611.cruddemo2.dao;

import com.nhtoan611.cruddemo2.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int employeeId);

    Employee save(Employee employee);

    void delete(int employeeId);
}

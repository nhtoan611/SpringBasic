package com.nhtoan611.cruddemo2.service;

import com.nhtoan611.cruddemo2.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int employeeId);

    Employee save(Employee employee);

    void delete(int employeeId);
}

package com.ubs.wcat.ms.service;

import com.ubs.wcat.ms.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAllEmployee();
    Employee newEmployee( Employee newEmployee);
    Optional<Employee>  findEmployeeById(Long id);
    Optional<Employee> replaceEmployee(Employee newEmployee,Long id);
    void deleteEmployee(Long id);
}

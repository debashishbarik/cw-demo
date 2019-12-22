package com.ubs.wcat.ms.rest.v1;

import com.ubs.wcat.ms.model.Employee;
import com.ubs.wcat.ms.rest.EmployeeResource;
import com.ubs.wcat.ms.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeResourceV1 implements EmployeeResource {

    EmployeeService employeeService;
    public EmployeeResourceV1(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Override
    public ResponseEntity<List<Employee>> findAllEmployee() {
        return ResponseEntity.ok(employeeService.findAllEmployee());
    }
    @Override
    public ResponseEntity<Employee> createEmployee(Employee newEmployee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.newEmployee(newEmployee));
    }
    @Override
    public ResponseEntity<Employee> findEmployeeById(Long id) {
        return ResponseEntity.ok(employeeService.findEmployeeById(id).get());
    }
    @Override
    public ResponseEntity<Employee> updateEmployee(Employee newEmployee, Long id) {
        return ResponseEntity.accepted().body(employeeService.replaceEmployee(newEmployee,id).get());
    }
    @Override
    public ResponseEntity deleteEmployee(Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.accepted().build();
    }
}

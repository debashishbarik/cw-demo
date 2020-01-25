package com.ubs.wcat.ms.rest;

import com.ubs.wcat.ms.model.Employee;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/v1/employees")
public interface EmployeeResource {
    @GetMapping
    ResponseEntity<List<Employee>> findAllEmployee();

    @PostMapping
    ResponseEntity<Employee> createEmployee(@RequestBody Employee newEmployee);

    @GetMapping("/{id}")
    ResponseEntity<Employee> findEmployeeById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<Employee> updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id);

    @DeleteMapping("/{id}")
    ResponseEntity deleteEmployee(@PathVariable Long id);

    @GetMapping("/date/{date}")
    public ResponseEntity<?> getOrdersByDate(
            @PathVariable(name = "date")
            @DateTimeFormat(pattern = "MM-dd-yyyy" ,iso = DateTimeFormat.ISO.DATE)
                    LocalDate date);
}

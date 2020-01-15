package com.ubs.wcat.ms.rest.v1;

import com.ubs.wcat.ms.model.Employee;
import com.ubs.wcat.ms.rest.EmployeeResource;
import com.ubs.wcat.ms.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
        Optional<Employee> employeeOptional = employeeService.findEmployeeById(id);
        if(employeeOptional.isPresent()) {
            return ResponseEntity.ok(employeeService.findEmployeeById(id).get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @Override
    public ResponseEntity<Employee> updateEmployee(Employee newEmployee, Long id) {
        return ResponseEntity.accepted().body(employeeService.replaceEmployee(newEmployee,id).get());
    }
    @Override
    public ResponseEntity deleteEmployee(Long id) {
        Optional<Employee> employeeOptional = employeeService.findEmployeeById(id);
        if(employeeOptional.isPresent()) {
            employeeService.deleteEmployee(id);
            return ResponseEntity.accepted().build();
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @Override
    public ResponseEntity<?> getOrdersByDate(LocalDate date) {
        if(date.isAfter(LocalDate.now())){
            System.out.println("Date is Future date");
        }
        LocalDate priortoCurrentDate = LocalDate.now().minusDays(1);
        LocalDate priortoPassedDate = date.minusDays(1);
        System.out.println(priortoCurrentDate);
        LocalDate updatedate = date;
        System.out.println("updatedate:"+updatedate);
        return  ResponseEntity.ok("OK");
    }
}

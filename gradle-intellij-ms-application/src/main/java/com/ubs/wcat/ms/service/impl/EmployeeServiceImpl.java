package com.ubs.wcat.ms.service.impl;

import com.ubs.wcat.ms.domain.EmployeeEntity;
import com.ubs.wcat.ms.exception.EmployeeNotFoundException;
import com.ubs.wcat.ms.model.Employee;
import com.ubs.wcat.ms.repo.EmployeeRepository;
import com.ubs.wcat.ms.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAllEmployee() {
        log.debug("Getting all employees..");
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
        List<Employee> employeeList =  new ArrayList<Employee>();
        for(EmployeeEntity eachEmployeeEntity : employeeEntityList){
            Employee employee = new Employee();
            BeanUtils.copyProperties(eachEmployeeEntity, employee);
            employeeList.add(employee);
        }
        return employeeList;
    }

    @Override
    public Employee newEmployee(Employee newEmployee) {
        log.debug("New employee..");
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(newEmployee , employeeEntity);
        EmployeeEntity newEmployeeEntity =  employeeRepository.save(employeeEntity);
        Employee updatedEmployee = new Employee();
        BeanUtils.copyProperties(newEmployeeEntity, updatedEmployee);
        return updatedEmployee;
    }

    @Override
    public Optional<Employee> findEmployeeById(Long id) {
        log.debug("Getting  an employees..");
       Optional<EmployeeEntity> employeeEntity = Optional.ofNullable(employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id)));
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity.get() , employee);
        return Optional.of(employee);
    }

    @Override
    public Optional<Employee> replaceEmployee(Employee newEmployee,Long id) {
        EmployeeEntity returnEmployeeEntity;
        Employee returnEmployee = new Employee();
        Optional<EmployeeEntity> employeeEntityOpt =  employeeRepository.findById(id)
                .map(employeeEnt->{
                    employeeEnt.setName(newEmployee.getName());
                    employeeEnt.setRole(newEmployee.getRole());
                    return employeeRepository.save(employeeEnt);
                });
        //check employee found or not
        if(employeeEntityOpt.isPresent()){
            log.debug("Employee details updated");
            returnEmployeeEntity = employeeEntityOpt.get();
        }else{
            log.debug("Employee not found , creating new employee");
            EmployeeEntity newEmployeeEntity = new EmployeeEntity();
            BeanUtils.copyProperties(newEmployee,newEmployeeEntity);
            returnEmployeeEntity = employeeRepository.save(newEmployeeEntity);
        }
        BeanUtils.copyProperties(returnEmployeeEntity,returnEmployee);
        return Optional.of(returnEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        log.debug("Employee :"+id+" removed");
    }
}

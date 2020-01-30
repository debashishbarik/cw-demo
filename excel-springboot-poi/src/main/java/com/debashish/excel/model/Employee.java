package com.debashish.excel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String name;
    private String email;
    private Date dateOfBirth;
    private double salary;

}

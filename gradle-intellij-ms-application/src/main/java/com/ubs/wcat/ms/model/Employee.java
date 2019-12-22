package com.ubs.wcat.ms.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Employee {
    private Long Id;
    private String name;
    private String role;
    public Employee() {
    }
    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

}

package com.ubs.wcat.ms.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//https://spring.io/guides/tutorials/rest/
@Data
@Entity(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.PRIVATE)
    Long Id;
    private String name;
    private String role;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String name, String role) {
        this.name = name;
        this.role = role;
    }
}

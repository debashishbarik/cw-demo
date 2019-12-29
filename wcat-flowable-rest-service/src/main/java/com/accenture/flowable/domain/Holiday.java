package com.accenture.flowable.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Holiday {
    private String id;
    private String employee;
    private String nrOfHolidays;
    private String description;

}

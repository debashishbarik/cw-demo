package com.accenture.flowable.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Approval {

    private String id;
    private boolean approved;
}

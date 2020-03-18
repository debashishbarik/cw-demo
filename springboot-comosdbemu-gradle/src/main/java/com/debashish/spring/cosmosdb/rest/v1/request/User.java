package com.debashish.spring.cosmosdb.rest.v1.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;
    private String firstName;

    private String lastName;
    private Address address;

    private String userType;

}

package com.debashish.spring.cosmosdb.rest.v1.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    String id;

    private String city;
    private String state;
    private String pincode;
    private String country;
}

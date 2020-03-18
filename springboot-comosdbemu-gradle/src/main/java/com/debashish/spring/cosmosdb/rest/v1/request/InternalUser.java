package com.debashish.spring.cosmosdb.rest.v1.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InternalUser extends User {

    private String salaryAccount;
    private String salaryAmount;
}

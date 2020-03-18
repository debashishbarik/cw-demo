package com.debashish.spring.cosmosdb.rest.v1.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalUser extends User {
    private String companyName;
    private String companyId;

}

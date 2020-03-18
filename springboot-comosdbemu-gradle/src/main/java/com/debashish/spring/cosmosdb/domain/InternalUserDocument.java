package com.debashish.spring.cosmosdb.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

@Document(collection = "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@TypeAlias("Internal")
public class InternalUserDocument extends UserDocument{

    private String salaryAccount;
    private String salaryAmount;

}

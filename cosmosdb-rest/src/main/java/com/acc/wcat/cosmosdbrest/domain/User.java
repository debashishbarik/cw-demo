package com.acc.wcat.cosmosdbrest.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;
import org.springframework.data.annotation.Id;

@Document(collection = "usercollection")
@JsonIgnoreProperties(ignoreUnknown=true)
public class User {

    @Id
    private String id;
    private String firstName;

    @PartitionKey
    private String lastName;
    private String address;

    public User(String id, String firstName, String lastName, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s", firstName, lastName, address);
    }
}
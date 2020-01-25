package com.example.cosmosdb.repository;

import com.example.cosmosdb.domain.User;
import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveCosmosRepository<User, String> {
    Flux<User> findByFirstName(String firstName);
}

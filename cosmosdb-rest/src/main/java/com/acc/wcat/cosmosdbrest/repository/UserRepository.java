package com.acc.wcat.cosmosdbrest.repository;

import com.acc.wcat.cosmosdbrest.domain.User;
import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveCosmosRepository<User, String> {
    Flux<User> findByFirstName(String firstName);
}

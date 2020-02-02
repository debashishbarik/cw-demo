package com.debashish.spring.cosmosdb.repository;

import com.debashish.spring.cosmosdb.domain.UserDocument;
import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveCosmosRepository<UserDocument, String> {
    Flux<UserDocument> findByFirstName(String firstName);
}

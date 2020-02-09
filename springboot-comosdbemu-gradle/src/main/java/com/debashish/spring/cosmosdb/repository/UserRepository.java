package com.debashish.spring.cosmosdb.repository;

import com.debashish.spring.cosmosdb.domain.ExternalUserDocument;
import com.debashish.spring.cosmosdb.domain.UserDocument;
import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.io.Serializable;

@Repository
public interface UserRepository<T extends UserDocument, ID extends Serializable> extends ReactiveCosmosRepository<T, ID> {
    Flux<UserDocument> findByFirstName(String firstName);
    Flux<ExternalUserDocument> findAllByUserType(String firstName);
}

package com.debashish.spring.cosmosdb.service;

import com.debashish.spring.cosmosdb.rest.v1.request.ExternalUser;
import com.debashish.spring.cosmosdb.rest.v1.request.InternalUser;
import com.debashish.spring.cosmosdb.rest.v1.request.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUser();
    User newUser( User user);
    Optional<User> findUserById(Long id);
    Optional<User> replaceUser(User user,Long id);
    void deleteUser(Long id);

    InternalUser newInternalUser(InternalUser internalUser);

    ExternalUser newExternalUser(ExternalUser externalUser);


    List<ExternalUser> findExternalUsersByType(String userType);
}

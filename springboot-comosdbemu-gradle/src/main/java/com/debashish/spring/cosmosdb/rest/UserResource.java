package com.debashish.spring.cosmosdb.rest;

import com.debashish.spring.cosmosdb.rest.v1.request.ExternalUser;
import com.debashish.spring.cosmosdb.rest.v1.request.InternalUser;
import com.debashish.spring.cosmosdb.rest.v1.request.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserResource {

    @GetMapping
    ResponseEntity<List<User>> findAllUser();

    @PostMapping
    ResponseEntity<User> createUser(@RequestBody User user);

    @PostMapping("/internal")
    ResponseEntity<InternalUser> createInternalUser(@RequestBody InternalUser internalUser);

    @PostMapping("/external")
    ResponseEntity<ExternalUser> createExternalUser(@RequestBody ExternalUser externalUser);


    @GetMapping("usertype/{userType}")
    ResponseEntity<List<ExternalUser>> findUsersByType(@PathVariable String userType);

    @GetMapping("/{id}")
    ResponseEntity<User> findUserById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id);

    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable Long id);
}

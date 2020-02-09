package com.debashish.spring.cosmosdb.service;

import com.debashish.spring.cosmosdb.domain.ExternalUserDocument;
import com.debashish.spring.cosmosdb.domain.InternalUserDocument;
import com.debashish.spring.cosmosdb.domain.UserDocument;
import com.debashish.spring.cosmosdb.repository.UserRepository;
import com.debashish.spring.cosmosdb.rest.v1.request.ExternalUser;
import com.debashish.spring.cosmosdb.rest.v1.request.InternalUser;
import com.debashish.spring.cosmosdb.rest.v1.request.User;
import com.debashish.spring.cosmosdb.util.DeepCopyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    UserRepository<UserDocument, String> userRepository;

    UserRepository<InternalUserDocument, String> internalUserRepository;

    UserRepository<ExternalUserDocument, String> externalUserRepository;

    public UserServiceImpl(UserRepository<UserDocument, String> userRepository, UserRepository<InternalUserDocument, String> internalUserRepository, UserRepository<ExternalUserDocument, String> externalUserRepository) {
        this.userRepository = userRepository;
        this.internalUserRepository = internalUserRepository;
        this.externalUserRepository = externalUserRepository;
    }

    @Override
    public List<User> findAllUser() {
        List<UserDocument> userDocumentList = userRepository.findAll().collectList().block();

        /*List<User> userList = userDocumentList.stream().map(userDoc ->
                {
                    User user = DeepCopyUtils.copyProperties(userDoc,User.class);
                    return user;
                }
        ).collect(Collectors.toList());*/

        List<User> userList = DeepCopyUtils.copyListOfObjects(userDocumentList, User.class);
        return userList;
    }

    @Override
    public User newUser(User user) {
        user.setId(UUID.randomUUID().toString());
        UserDocument userDocument = DeepCopyUtils.copyProperties(user, UserDocument.class);
        userDocument.getAddress().setId(UUID.randomUUID().toString());
        UserDocument userDocumentNew = userRepository.save(userDocument).block();
        User userNew = DeepCopyUtils.copyProperties(userDocumentNew, User.class);
        return userNew;
    }

    @Override
    public InternalUser newInternalUser(InternalUser internalUser) {

        InternalUserDocument userDocument = DeepCopyUtils.copyProperties(internalUser, InternalUserDocument.class);
        userDocument.setId(UUID.randomUUID().toString());
        userDocument.getAddress().setId(UUID.randomUUID().toString());
        InternalUserDocument userDocumentNew = internalUserRepository.save(userDocument).block();
        InternalUser userNew = DeepCopyUtils.copyProperties(userDocumentNew, InternalUser.class);
        return userNew;
    }

    @Override
    public ExternalUser newExternalUser(ExternalUser externalUser) {
        ExternalUserDocument userDocument = DeepCopyUtils.copyProperties(externalUser, ExternalUserDocument.class);
        userDocument.setId(UUID.randomUUID().toString());
        userDocument.getAddress().setId(UUID.randomUUID().toString());
        ExternalUserDocument userDocumentNew = externalUserRepository.save(userDocument).block();
        ExternalUser userNew = DeepCopyUtils.copyProperties(userDocumentNew, ExternalUser.class);
        return userNew;
    }

    @Override
    public List<ExternalUser> findExternalUsersByType(String userType) {

        List<ExternalUserDocument> userDocumentList = new ArrayList<>();

        userDocumentList = externalUserRepository.findAllByUserType(userType).collectList().block();

        List<ExternalUser> userList = DeepCopyUtils.copyListOfObjects(userDocumentList, ExternalUser.class);

        return userList;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> replaceUser(User user, Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteUser(Long id) {

    }

}

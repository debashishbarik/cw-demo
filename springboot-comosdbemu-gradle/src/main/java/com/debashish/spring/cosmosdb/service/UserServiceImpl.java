package com.debashish.spring.cosmosdb.service;

import com.debashish.spring.cosmosdb.domain.UserDocument;
import com.debashish.spring.cosmosdb.repository.UserRepository;
import com.debashish.spring.cosmosdb.rest.v1.request.User;
import com.debashish.spring.cosmosdb.util.DeepCopyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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

        List<User> userList = DeepCopyUtils.copyListOfObjects(userDocumentList,User.class);
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

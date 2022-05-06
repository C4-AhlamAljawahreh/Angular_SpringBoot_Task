package com.example.login_register.User;

import com.example.login_register.Tasks.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    User findUserById(String _id);
    List<User> findUserByUserName(String userName);
}
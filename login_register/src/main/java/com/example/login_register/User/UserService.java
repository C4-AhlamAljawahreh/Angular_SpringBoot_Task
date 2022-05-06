package com.example.login_register.User;


import java.util.List;

public class UserService {

    private UserRepository userRepository;


    public List<User> signUpUser(User user) {
        return userRepository
                .findUserByUserName(user.getUserName());

    }
}

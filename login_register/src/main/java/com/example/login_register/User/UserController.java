package com.example.login_register.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class UserController {
   private Object error ;
    private Logger logger =
            LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;
    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        logger.info("Getting all users.");
        return userRepository.findAll();
    }
    @GetMapping(value = "/user/{userId}")
    public User getUserById(@PathVariable String userId) {
        logger.info("Getting user with ID: {}", userId);
        return userRepository.findUserById(userId);
    }
    @PostMapping(value = "user/login")
    public Object signUpUser(@RequestBody User user) {
        String userName = user.getUserName();
        String password =user.getPassword();
        logger.info("login", userName);
       List<User> myUser =userRepository
                .findUserByUserName(userName);


       if(myUser.size() >0){
           if(password.equals(myUser.get(0).getPassword())){
               return userRepository
                       .findUserByUserName(userName).get(0);
           }

}
        return error ;
    }
    @PostMapping(value = "user/create")
    public User addUser(@RequestBody User user) {
        logger.info("Saving user.");
        return userRepository.save(user);
    }
    @PutMapping(value = "user/update/{userId}")
    public User updateUser(@PathVariable String userId, @RequestBody User user) {
        logger.info("Updating user with ID: {}", userId);
        return userRepository.save(user);
    }
    @DeleteMapping(value = "user/delete/{userId}")
    public void deleteUser(@PathVariable String userId) {
        logger.info("Deleting user with ID: {}", userId);
        userRepository.deleteById(userId);
    }
}


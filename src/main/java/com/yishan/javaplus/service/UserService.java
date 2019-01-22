package com.yishan.javaplus.service;

import com.yishan.javaplus.domain.User;
import com.yishan.javaplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
    public class UserService {
    @Autowired
    private UserRepository userRepository;

//    @Transactional
//    public User createUser(User newUser){
//
//    }




    public List<User> findAll() {
//        List<User> users = Lists.newArrayList(userRepository.findAll());
        return userRepository.findAll();
    }

    public User findById(Long Id) {
        return userRepository.findById(Id).get();
    }

    public User findByLastname(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    public User findByFirstname(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public User findByUsername(String username) {
        User result = userRepository.findByUsername(username);
        return result;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    public User createNewUser(User newUser) {
        String encodePassword = encoder.encode(newUser.getPassword());
        newUser.setPassword(encodePassword);
        return userRepository.save(newUser);}
 }

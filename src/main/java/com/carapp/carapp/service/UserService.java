package com.carapp.carapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.carapp.carapp.exception.userNotFoundException;
import com.carapp.carapp.model.User;
import com.carapp.carapp.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService( UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<User> getAllUsers(){
       return userRepository.findAll();
    }

    public User findById(String id){
        return userRepository.findById(id).orElseThrow(() -> new userNotFoundException(" not exists"));
    }
    
    public ResponseEntity<String>deleteUser(String id){
        Boolean existe = userRepository.existsById(id);
        if (existe) {
            userRepository.deleteById(id);
            return ResponseEntity.ok().body("User with id:"+id+ " deleted succussfuly");
        }
        return ResponseEntity.badRequest().body("User with id:"+id+" not found");
    }

    public ResponseEntity<String> modifyById(String id, User user) {
        boolean exists = userRepository.existsById(id);
        if (exists) {
            user.setId(id);
            userRepository.save(user);
            return ResponseEntity.ok("User with id: " + id + " updated successfully");
        }
        return ResponseEntity.badRequest().body("User with id: " + id + " not found");
    }
    

    public ResponseEntity<String> createUser(User user) {
        try {
            userRepository.save(user);
            return ResponseEntity.ok("User created successfully");
        } catch (Exception e) {  
            return ResponseEntity.badRequest().body("An error occurred: " + e.getMessage());
        }
    }
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email); // Calls the repository method
    }
    
}

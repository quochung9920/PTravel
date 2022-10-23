package com.ptravel.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptravel.pojos.User;
import com.ptravel.service.UserService;

@RestController
@RequestMapping("/api")
public class ApiUserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> listTours() {
        return new ResponseEntity<>(this.userService.getListUsers(), HttpStatus.OK);
    }

    @PutMapping(path = "/users/{userId}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<User> updateUser(@PathVariable(value = "userId") Integer userId, 
        @Valid @RequestBody Map<String, String> params) {
        
        try {
            User user = new User();
            user.setLastName(params.getOrDefault("lastName", ""));
            user.setFirstName(params.getOrDefault("firstName", ""));
            user.setEmail(params.getOrDefault("email", ""));
            user.setPhone(params.getOrDefault("phone", ""));
            user.setUsername(params.getOrDefault("username", ""));
            user.setPassword(params.getOrDefault("password", ""));
            
            User u = this.userService.updateUser(userId, user);
            return new ResponseEntity<User>(u, HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            System.out.println(e.getMessage());
            
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}

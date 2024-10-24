package com.user.service.controller;

import com.user.service.dto.UserDto;
import com.user.service.entity.User;
import com.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<Object> addUser(@RequestBody UserDto userDto) {
        User user = userService.addUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody UserDto userDto) {
        User updatedUser = userService.updateUser(id, userDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        User user = userService.getById(id);
        return new ResponseEntity<>(user.getUsername() + " " + user.getPassword(), HttpStatus.FOUND);

    }
    @GetMapping
    public ResponseEntity<Object> findAll() {
       List<User> user = userService.getAll();
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }
    @DeleteMapping("/id")
    public ResponseEntity<Object> delete(@RequestParam("id") Long id){
         userService.deleteUser(id);
         return new ResponseEntity<>("User deleted : " + id, HttpStatus.OK);
    }
    @GetMapping("/{username}")
    public ResponseEntity<Object> findByUserName(@RequestParam String username){
        List<User> user = userService.getByName(username);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }
}

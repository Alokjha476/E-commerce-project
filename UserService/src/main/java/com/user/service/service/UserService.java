package com.user.service.service;

import com.user.service.dto.UserDto;
import com.user.service.entity.User;

import java.util.List;


public interface UserService {

    User addUser(UserDto userDto);

    User updateUser(Long id, UserDto userDto);

    User getById(Long id);

    List<User> getAll();

    List<User> getByName(String username);

    void deleteUser(Long id);

}

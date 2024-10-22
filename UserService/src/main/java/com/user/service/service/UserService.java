package com.user.service.service;

import com.user.service.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {

    User addUser();

    User updateUser(Long id);

    User getById(long id);

    User getAll();

    User getByName(String username);

    void deleteUser(Long id);

}

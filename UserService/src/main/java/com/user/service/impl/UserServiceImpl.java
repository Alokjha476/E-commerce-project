package com.user.service.impl;

import com.user.service.dto.UserDto;
import com.user.service.entity.User;
import com.user.service.exception.UserNotFoundException;
import com.user.service.repository.UserRepository;
import com.user.service.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        user.setEnabled(userDto.isEnabled());
        user.setCreateDate(userDto.getCreateDate());
        user.setUpdateDate(userDto.getUpdateDate());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found " + id));
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Id not found " + id));
    }

    @Override
    public List<User> getAll() {
       return userRepository.findAll();
    }

    @Override
    public List<User> getByName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

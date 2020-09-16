package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserIsExistedException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserLoginException;
import com.thoughtworks.capacity.gtb.mvc.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user) {
        if(userRepository.isExisted(user)) {
            throw new UserIsExistedException("用户已存在");
        } else {
            user.setId(userRepository.count() + 1);
            userRepository.register(user);
        }
    }

    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if(user == null || !user.getPassword().equals(password)) {
            throw new UserLoginException("用户名或密码错误");
        }

        return user;
    }
}

package com.thoughtworks.capacity.gtb.mvc.api;

import com.thoughtworks.capacity.gtb.mvc.dto.UserDto;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody UserDto userDto) {
        userService.registerUser(userDto);
    }
}

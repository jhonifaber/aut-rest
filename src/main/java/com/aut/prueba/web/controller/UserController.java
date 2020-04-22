package com.aut.prueba.web.controller;

import com.aut.prueba.model.User;
import com.aut.prueba.service.UserService;
import com.aut.prueba.web.presentation.UserDto;
import com.aut.prueba.web.presentation.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/authentication")
    public void signUp(@RequestBody UserDto userDto) {
        User user = userMapper.convertToUser(userDto);
        userService.save(user);
    }
}

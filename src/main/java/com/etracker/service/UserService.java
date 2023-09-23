package com.etracker.service;

import com.etracker.dto.UserDto;
import com.etracker.model.User;

public interface UserService {

//    public User validateUser(String email, String password);
//
//    public User registerUser(User user);

    void saveUser(UserDto userDto);

    User findUserByEmail(String email);
}

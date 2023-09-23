package com.etracker.service;

import com.etracker.dto.UserDto;
import com.etracker.model.Role;
import com.etracker.model.User;
import com.etracker.repository.RoleRepository;
import com.etracker.repository.UserRepository;
import com.etracker.util.TbConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

//    @Override
//    public User validateUser(String email, String password) {
//        if(email == null || password == null)
//            throw new RuntimeException("Invalid Credentials");
//
//        email = email.toLowerCase();
//        User user = userRepository.findByEmail(email);
//
//        if(user == null)
//            throw new RuntimeException("Please check the email address provided");
//
//        if(!password.equals(user.getPassword())){
//            throw new RuntimeException("Incorrect Password");
//        }
//
//        return user;
//    }
//
//    @Override
//    public User registerUser(User user) {
//        return userRepository.save(user);
//    }

//    @Override
//    public User getUserById(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public User getUserByEmail(String email) {
//        User user = userRepository.findByEmail(email);
//
//        if(user == null)
//            throw new RuntimeException("User not found with email: " + email);
//
//        return new User(
//                user.getEmail(),
//                user.getPassword()
//        );
//    }

    @Override
    public void saveUser(UserDto userDto) {
        Role role = roleRepository.findByName(TbConstants.Roles.USER);

        if (role == null)
            role = roleRepository.save(new Role(TbConstants.Roles.USER));

        User user = new User(userDto.getName(), userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()),
                Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

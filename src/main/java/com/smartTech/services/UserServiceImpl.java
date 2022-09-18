package com.smartTech.services;

import com.smartTech.Domain.User;
import com.smartTech.exeception.EtAuthException;
import com.smartTech.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Pattern;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        if(email != null) email = email.toLowerCase();
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User registerUser(Integer userId, String Name, String email, String password) throws EtAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(email != null) email = email.toLowerCase();
        if(!pattern.matcher(email).matches())
            throw new EtAuthException("Invalid email format");
        Integer count = userRepository.getCountByEmail(email);
        if(count > 0)
            throw new EtAuthException("Email already in use");

        return userRepository.findById(userId);
}}

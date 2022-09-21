package com.smartTech.services;

import com.smartTech.Domain.User;
import com.smartTech.exeception.EtAuthException;
import com.smartTech.exeception.EtResourceNotFoundException;
import com.smartTech.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Pattern;
@Service
@Transactional
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        if(email != null) email = email.toLowerCase();
    return userRepository.findByUsernameAndEmail(email,password);
    }


 // test registration and check the email
    @Override
    public User registerUser(String Name, String email, String password) throws EtAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(email != null) email = email.toLowerCase();
        if(!pattern.matcher(email).matches()) throw new EtAuthException("Invalid email format");
        Integer count = userRepository.getCountByEmail(email);
        if(count > 0) throw new EtAuthException("Email already in use");
        Long userId = userRepository.create(Name,email,password);
        return  userRepository.findUserById(userId);

}

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteuserById(Long userId) {

    }

    public User addUser (User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User deleteuserById() {
        return null;
    }


    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Long userId)throws EtResourceNotFoundException {
        return userRepository.findUserById(userId);

    }

}


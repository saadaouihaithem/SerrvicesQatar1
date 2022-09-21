package com.smartTech.services;
import com.smartTech.Domain.User;
import com.smartTech.exeception.EtAuthException;

import java.util.List;
import java.util.Optional;

public interface UserService {


    /// user validation login

    User validateUser(String email, String password) throws EtAuthException;

    User registerUser(String Name, String email, String password) throws EtAuthException;

    User save(User user);
    void deleteuserById(Long userId);

    List<User> findAllUser();

    User deleteuserById();

    User findUserById(Long userId);
}


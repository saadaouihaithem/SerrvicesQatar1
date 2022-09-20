package com.smartTech.services;
import com.smartTech.Domain.User;
import com.smartTech.exeception.EtAuthException;

import java.util.List;
import java.util.Optional;

public interface UserService {
 /// user validation login

    List<User> validateUser(String email, String password) throws EtAuthException;

    Optional<User> registerUser(String Name, String email, String password) throws EtAuthException;
}


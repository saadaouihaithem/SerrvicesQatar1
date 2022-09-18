package com.smartTech.services;
import com.smartTech.Domain.User;
import com.smartTech.exeception.EtAuthException;

public interface UserService {

    User validateUser(String email, String password) throws EtAuthException;

    User registerUser(Integer userId, String Name, String email, String password) throws EtAuthException;

}


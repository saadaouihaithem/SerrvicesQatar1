package com.smartTech.repositories;

import com.smartTech.Domain.User;
import com.smartTech.exeception.EtAuthException;

public interface UserRepository {


        Integer create(Integer userId, String Name, String email, String password) throws EtAuthException;

        User findByEmailAndPassword(String email, String password) throws EtAuthException;

        Integer getCountByEmail(String email);

        User findById(Integer userId);


}

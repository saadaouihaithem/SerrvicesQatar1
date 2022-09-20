package com.smartTech.repositories;

import com.smartTech.Domain.User;
import com.smartTech.exeception.EtAuthException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    Long create( String Name, String Email, String Password);

    Optional<User> findByUsernameAndEmail( String email ,String password) throws EtAuthException;

    Integer getCountByEmail(String email);


    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    Boolean existsByEmail(String email);
}
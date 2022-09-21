package com.smartTech.Controller;
import com.smartTech.Constants;
import com.smartTech.Domain.User;
import com.smartTech.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.*;


@RestController
@RequestMapping("/user")

public class UserResource implements Serializable {


    private final UserService userService;

    private UserResource(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(path="/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, Object> userMap) {
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        User user =  userService.validateUser(email, password);
       return new ResponseEntity<>( generateJWTToken(user),HttpStatus.OK);
    }

    @PostMapping(path="/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> userMap) {
        String Name = (String) userMap.get("Name");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        User user = userService.registerUser(Name, email, password);
        return new ResponseEntity<>( generateJWTToken(user),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser () {
        List<User> user = userService.findAllUser();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/find/{userId}")
    public ResponseEntity<User> getUserById (@PathVariable("userId") Long userId) {
        User user =userService.findUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user ) {
        User newUser = userService.save(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updateUser = userService.save(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Long userid) {
        User deleteUser = userService.deleteuserById();
        return new ResponseEntity<>(HttpStatus.OK);
    }


    private Map<String,String> generateJWTToken(User user) {
        long timestamp = System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
                .claim("userId", user.getUserId())
                .claim("Name", user.getName())
                .claim("email", user.getEmail())
                .claim("password", user.getPassword())
                .compact();
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return map;
    }

}

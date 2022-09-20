package com.smartTech.Controller;
import com.smartTech.Constants;
import com.smartTech.Domain.User;
import com.smartTech.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController

@RequestMapping(path="api/user")

public class UserResource implements Serializable {


    private final UserService userService;
    @Autowired
    private UserResource(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(path="/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, Object> userMap) {
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        User user = userService.validateUser(email, password);
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

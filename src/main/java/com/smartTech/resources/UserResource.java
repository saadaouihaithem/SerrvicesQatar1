package com.smartTech.resources;
import com.smartTech.Constants;
import com.smartTech.Domain.User;
import com.smartTech.services.UserService;
import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.DoubleStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.DoubleStream;

@RestController
@RequestMapping("/api/user")

public class UserResource {

    @Autowired
    UserService userService;


    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, Object> userMap) {
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        User user = userService.validateUser(email, password);
       return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> userMap) {
        Integer userId=(Integer)userMap.get("userId");
        String Name = (String) userMap.get("Name");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");
        User user = userService.registerUser(userId,Name, email, password);
        return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
    }
 private Map<String, String> generateJWTToken(User user) {
        long timestamp = System.currentTimeMillis();
       String token = Jwts.builder().signWith(SignatureAlgorithm.registerDefaultAlgorithms(),Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
                .claim("userId", user.getUserId())
                .claim("email", user.getEmail())
                .claim("Name", user.getName())
                .claim("password", user.getPassword())
                .compact();
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return map;
    }

}

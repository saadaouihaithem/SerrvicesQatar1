package com.smartTech.Domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity

@Table(name = "User", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"Name"}),
        @UniqueConstraint(columnNames = {"password"})
})

public class User implements Serializable {



    private static final long serialVersionUID = -8080540494839892473L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private Long userId;
    @NotNull
    @Column(name="Name", nullable = false)
    private String Name;
    @NotNull
    @Column(name="email", nullable = false)
    private String email;
    @NotNull
    @Column(name="password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "User",
            joinColumns = {
                    @JoinColumn(name = "userId")},
            inverseJoinColumns = {
                    @JoinColumn(name = "operationId")})
    private List<User> user;



    public User() {
    }



    public User(Long userId, String Name,  String email, String password) {
        this.userId = userId;
        this.Name = Name;
        this.email = email;
        this.password = password;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void settName(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", Name='" + Name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

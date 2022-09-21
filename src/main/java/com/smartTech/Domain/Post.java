package com.smartTech.Domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Post {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "postId")
    private Long postId;
    private Long userId;
    @NotNull
    @Column(name = "title", nullable = false)
    private String title;
    @NotNull
    @Column(name = "description", nullable = false)
    private String description;
    @NotNull
    @Column(name = "serrvice", nullable = false)
    private String service;
    @NotNull
    @Column(name = "address", nullable = false)
    private String address;
    @NotNull
    @Column(name = "contact", nullable = false)
    private Integer contact;
    @NotNull
    @Column(name = "city", nullable = false)
    private String city;
    private Double price;
    private String type;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)

    private Set<Comment> comments = new HashSet<>();
    public Post(long postId, long userId, String title, String description, double price) {
    }





    public Post( Long userId, String title, String description, String service, String address, Integer contact, String city, Double price, String type) {
        this.postId = postId;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.service = service;
        this.address = address;
        this.contact = contact;
        this.city = city;
        this.price = price;
        this.type = type;
    }

    public Post() {

    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }





    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", service='" + service + '\'' +
                ", address='" + address + '\'' +
                ", contact=" + contact +
                ", city='" + city + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}
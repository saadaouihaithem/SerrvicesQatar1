package com.smartTech.Domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name="commentId")
    private long commentId;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    @NotNull

    private String email;
    @Column(name = "body")
    private String body;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private Post post ;
    public Comment(String name, String email, String body, Post post) {
        this.name = name;
        this.email = email;
        this.body = body;
        this.post = post;
    }

    public Comment() {

    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                ", post=" + post +
                '}';
    }



}

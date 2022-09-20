package com.smartTech.Domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comment")


public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;
    private String name;
    private String email;
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId", nullable = false)
    private Post post ;

}

package com.smartTech.repositories;


import com.smartTech.Domain.User;
import com.smartTech.exeception.EtResourceNotFoundException;
import com.smartTech.Domain.Post;
import com.smartTech.exeception.EtBadRequestException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

     public interface PostRepository extends JpaRepository<Post, Long> {

        List<Post>findAll(Long userId) throws EtResourceNotFoundException;

        Post findById(Long userId, Long postId) throws EtResourceNotFoundException;

        Integer create(Long  userId, String title, String description) throws EtBadRequestException;

        void update(Long userId, Long postId, Post category) throws EtBadRequestException;

        void removeById(Long userId, Long postId);
    }


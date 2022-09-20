package com.smartTech.services;

import com.smartTech.Domain.Post;
import com.smartTech.exeception.EtBadRequestException;
import com.smartTech.exeception.EtResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PostService {

    List<Post> fetchPostById(Long postId,Long userId);

    Post findById(Long userId, Long postId) throws EtResourceNotFoundException;

    Post addPost(Long userId, Long postId, String title, String description) throws EtBadRequestException;

    void updatePost(Long  userId, Long  categoryId, Post category) throws EtBadRequestException;

    void removeCategoryWithAllOperation(Long userId, Long  categoryId) throws EtResourceNotFoundException;

}
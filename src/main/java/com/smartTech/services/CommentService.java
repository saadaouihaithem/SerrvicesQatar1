package com.smartTech.services;


import com.smartTech.Domain.Comment;

import java.util.List;

public interface CommentService{
    Comment creatComment(Comment comment);
    List<Comment> getAllComment();
    Comment updateEmployee(Comment comment, long commentId);
    void deleteComment(long commentId);
}

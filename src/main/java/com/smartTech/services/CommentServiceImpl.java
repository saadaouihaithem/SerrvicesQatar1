package com.smartTech.services;

import com.smartTech.Domain.Comment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CommentServiceImpl  implements CommentService{


    @Override
    public Comment creatComment(Comment comment) {
        return null;
    }

    @Override
    public List<Comment> getAllComment() {
        return null;
    }

    @Override
    public Comment updateEmployee(Comment comment, long commentId) {
        return null;
    }

    @Override
    public void deleteComment(long commentId) {

    }
}

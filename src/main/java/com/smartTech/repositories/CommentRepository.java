package com.smartTech.repositories;

import com.smartTech.Domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository


public interface CommentRepository extends JpaRepository<CommentRepository,Long> {

    List<Comment> findBypostId(long postId);
}

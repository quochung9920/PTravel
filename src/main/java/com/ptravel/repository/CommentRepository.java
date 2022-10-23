package com.ptravel.repository;

import java.util.List;

import com.ptravel.pojos.Comment;

public interface CommentRepository {
    Comment addComment(Comment comment);
    List<Comment> getCommentByIdTour(int tourId);
}

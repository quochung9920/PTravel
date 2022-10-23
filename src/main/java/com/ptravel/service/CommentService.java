package com.ptravel.service;

import java.util.List;

import com.ptravel.pojos.Comment;

public interface CommentService {
    Comment addComment(String content, int tourId, int userId, int ratingTotal);
    List<Comment> getCommentsByProductId(int tourId);
}

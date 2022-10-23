package com.ptravel.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptravel.pojos.Comment;
import com.ptravel.pojos.TourDetail;
import com.ptravel.pojos.User;
import com.ptravel.repository.CommentRepository;
import com.ptravel.repository.TourRepository;
import com.ptravel.repository.UserRepository;
import com.ptravel.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment addComment(String content, int tourId, int userId, int ratingTotal) {
        TourDetail t = this.tourRepository.getTourById(tourId);
        User u = this.userRepository.getUserById(userId);

        Comment c = new Comment();
        c.setContent(content); 
        c.setTourId(t);
        c.setUser(u);
        c.setAvatarUser(u.getAvatar());
        c.setCreatedDate(new Date());
        c.setRating(ratingTotal);
        
        return this.commentRepository.addComment(c);
    }

    @Override
    public List<Comment> getCommentsByProductId(int tourId) {
        return this.commentRepository.getCommentByIdTour(tourId);
    }
}

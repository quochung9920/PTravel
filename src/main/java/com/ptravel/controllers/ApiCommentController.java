package com.ptravel.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ptravel.pojos.Comment;
import com.ptravel.pojos.User;
import com.ptravel.service.CommentService;
import com.ptravel.service.UserService;

@RestController
public class ApiCommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userDetailService;


    @PostMapping(path="/api/add-comment", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Comment> addComment( @RequestBody Map<String, String> params, Authentication authentication) {
        try {
            String content = params.getOrDefault("content", "");
            int tourId = Integer.parseInt(params.get("tourId"));
            int ratingTotal = Integer.parseInt(params.get("ratingTotal"));
            
            User user = this.userDetailService.getUsers(authentication.getName()).get(0);
            Comment comment = this.commentService.addComment(content, tourId, user.getId(), ratingTotal);
            return new ResponseEntity<Comment>(comment,HttpStatus.CREATED);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/api/comments/{tourId}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<Comment>> getCommentsByTourId(@PathVariable(value = "tourId") Integer tourId) {
        return new ResponseEntity<>(this.commentService.getCommentsByProductId(tourId), HttpStatus.OK);
    }
}

package com.example.springredditclone.controller;

import com.example.springredditclone.dto.CommentDto;
import com.example.springredditclone.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.CREATED;


@RestController
@RequestMapping("/api/comment")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Void> createComment(@RequestBody CommentDto commentDto) {
        commentService.save(commentDto);
        return new ResponseEntity<>(CREATED);
    }

    @GetMapping(params = "postId")
    public ResponseEntity<List<CommentDto>> getAllCommentsForPost(@RequestParam Long postId) {
        return ResponseEntity.status(OK)
                .body(commentService.getAllCommentsForPost(postId));
    }

    @GetMapping(params = "userName")
    public ResponseEntity<List<CommentDto>> getAllCommentsForUser(@RequestParam String userName){
        return ResponseEntity.status(OK)
                .body(commentService.getAllCommentsForUser(userName));
    }

}

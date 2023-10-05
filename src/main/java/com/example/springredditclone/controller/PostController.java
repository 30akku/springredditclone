package com.example.springredditclone.controller;

import com.example.springredditclone.dto.PostRequest;
import com.example.springredditclone.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody PostRequest postRequest) {
        postService.save(postRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getAllPosts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPost(@PathVariable Long id) {
        return status(HttpStatus.OK).body(postService.getPost(id));
    }

    @GetMapping(params = "subredditId")
    public ResponseEntity<Object> getPostsBySubreddit(@RequestParam Long subredditId) {
        return status(HttpStatus.OK).body(postService.getPostsBySubreddit(subredditId));
    }

    @GetMapping(params = "username")
    public ResponseEntity<Object> getPostsByUsername(@RequestParam String username) {
        return status(HttpStatus.OK).body(postService.getPostsByUsername(username));
    }
}

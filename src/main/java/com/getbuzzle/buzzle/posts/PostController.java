package com.getbuzzle.buzzle.posts;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController("/posts")
public class PostController {
    private final List<Post> posts = new ArrayList<>();

    private PostController() {
        this.posts.add(new Post(1, "Content 1", "https://www.imageurl.com"));
        this.posts.add(new Post(2, "Content 2", "https://www.imageurl.com"));
        this.posts.add(new Post(3, "Content 3", "https://www.imageurl.com"));
        this.posts.add(new Post(4, "Content 4", "https://www.imageurl.com"));
        this.posts.add(new Post(5, "Content 5", "https://www.imageurl.com"));
    }

    @GetMapping
    public ResponseEntity<List<Post>> getPosts(
            @RequestParam(defaultValue = "10") int limit
    ) {
        List<Post> response = this.posts
                .stream()
                .limit(Math.min(limit, posts.size()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> addPost(@RequestBody Post postData) {
        this.posts.add(postData);
        return new ResponseEntity<>(postData, HttpStatus.CREATED);
    }
}

package com.getbuzzle.buzzle.posts;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController("/posts")
public class PostController {
    public List<Post> posts = new ArrayList<>();

    public PostController() {
        this.posts.add(new Post(1, "Content 1", "https://www.imageurl.com"));
        this.posts.add(new Post(2, "Content 2", "https://www.imageurl.com"));
        this.posts.add(new Post(3, "Content 3", "https://www.imageurl.com"));
        this.posts.add(new Post(4, "Content 4", "https://www.imageurl.com"));
        this.posts.add(new Post(5, "Content 5", "https://www.imageurl.com"));
    }

    @GetMapping
    List<Post> getPosts(
            @RequestParam(defaultValue = "10") int limit
    ) {
        return this.posts.stream().limit(Math.min(limit, posts.size())).collect(Collectors.toList());
    }
}

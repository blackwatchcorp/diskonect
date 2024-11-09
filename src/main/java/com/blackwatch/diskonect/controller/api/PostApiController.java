package com.blackwatch.diskonect.controller.api;

import com.blackwatch.diskonect.exception.RestStatusException;
import com.blackwatch.diskonect.model.Post;
import com.blackwatch.diskonect.model.PostForm;
import com.blackwatch.diskonect.service.PostService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/posts")
@Validated
public class PostApiController {
  private final PostService postService;

  public PostApiController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping
  public List<Post> getPosts() {
    return postService.fetchAllPosts();
  }

  @GetMapping("/{slug}")
  public Post getPostBySlug(@PathVariable("slug") String slug) {
    return postService.fetchPostBySlug(slug);
  }

  @PostMapping
  public Post createPost(@Valid @RequestBody PostForm postForm) {
    Post newPost = new Post(postForm);
    int rows = postService.createNewPost(newPost);
    if (rows != 1) {
      log.error("Could not create post");
      throw new RestStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "could not create post");
    }
    return newPost;
  }
}

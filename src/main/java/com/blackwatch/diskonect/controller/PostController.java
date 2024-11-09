package com.blackwatch.diskonect.controller;

import com.blackwatch.diskonect.model.Post;
import com.blackwatch.diskonect.model.PostForm;
import com.blackwatch.diskonect.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostController {
  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/")
  public ModelAndView index() {
    List<Post> posts = postService.fetchAllPosts();

    ModelAndView modelAndView = new ModelAndView("index");
    modelAndView.addObject("posts", posts);

    return modelAndView;
  }

  @GetMapping("/create-post-btn")
  public String createPostBtn(){
    return "create-post-btn";
  }

  @GetMapping("/post-form")
  public String postForm(){
    return "post-form";
  }

  @PostMapping("/post")
  public ModelAndView createPost(@ModelAttribute PostForm postForm ){

    Post newPost = new Post(postForm);
    int rowAdded = postService.createNewPost(newPost);
    ModelAndView modelAndView = new ModelAndView("post");
    modelAndView.addObject("post",newPost);

    return modelAndView;
  }
}

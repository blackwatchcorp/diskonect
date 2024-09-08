package com.blackwatch.diskonect.controller;

import com.blackwatch.diskonect.model.Post;
import com.blackwatch.diskonect.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}

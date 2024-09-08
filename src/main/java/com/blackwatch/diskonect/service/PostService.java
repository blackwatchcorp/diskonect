package com.blackwatch.diskonect.service;

import com.blackwatch.diskonect.model.Post;
import com.blackwatch.diskonect.repository.PostDao;
import org.springframework.stereotype.Service;

import java.util.List;

/** Service bean for controllers to interact with posts. */
@Service
public class PostService {
  private final PostDao postDao;

  public PostService(PostDao postDao) {
    this.postDao = postDao;
  }

  /**
   * Return all posts.
   *
   * @return List of all posts.
   */
  public List<Post> fetchAllPosts() {
    return postDao.queryAllPosts();
  }
}

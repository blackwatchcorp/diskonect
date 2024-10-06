package com.blackwatch.diskonect.service;

import com.blackwatch.diskonect.model.Post;
import com.blackwatch.diskonect.repository.PostDao;
import java.util.List;
import org.springframework.stereotype.Service;

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

  public int createNewPost(Post post) {
    return postDao.createPost(post);
  }
}

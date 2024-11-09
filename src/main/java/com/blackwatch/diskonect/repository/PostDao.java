package com.blackwatch.diskonect.repository;

import com.blackwatch.diskonect.model.Post;
import com.blackwatch.diskonect.repository.mapper.PostRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostDao {
  private final JdbcTemplate jdbcTemplate;

  public PostDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  /**
   * Query all posts from database.
   *
   * @return List of all posts in database.
   */
  public List<Post> queryAllPosts() {
    String query = "select * from diskonect.post order by created_at desc";
    return jdbcTemplate.query(query, new PostRowMapper());
  }

  public int createPost(Post post) {
    String query =
        "INSERT INTO diskonect.post(slug, created_at, title, assets, content) VALUES ( ?, ?, ?, ?, ?)";
    return jdbcTemplate.update(
        query,
        post.slug(),
        post.createdAt(),
        post.title(),
        post.assets().toArray(new String[0]),
        post.content());
  }
}

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
    String query = "select * from diskonect.post";
    return jdbcTemplate.query(query, new PostRowMapper());
  }
}

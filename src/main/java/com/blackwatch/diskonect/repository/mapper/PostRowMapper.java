package com.blackwatch.diskonect.repository.mapper;

import com.blackwatch.diskonect.model.Post;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PostRowMapper implements RowMapper<Post> {
  @Override
  public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
    Long id = rs.getLong("id");
    String title = rs.getString("title");
    String content = rs.getString("content");
    Instant ins = rs.getTimestamp("created_at").toInstant();
    Date createdAt = Date.from(ins);
    String slug = rs.getString("slug");
    List<String> assets = Arrays.asList((String[]) rs.getArray("assets").getArray());

    return new Post(id, title, content, createdAt, slug, assets);
  }
}

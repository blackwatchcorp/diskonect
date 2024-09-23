package com.blackwatch.diskonect.model;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public record Post(
    @NonNull Long id,
    @NonNull String title,
    @NonNull String content,
    @NonNull Date createdAt,
    @NonNull String slug,
    @NonNull List<String> assets) {
    public Post(@NonNull Long id, @NonNull String title, @NonNull String content, @NonNull Date createdAt, @NonNull String slug, @NonNull List<String> assets) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.slug = slug;
        this.assets = assets;
    }

    public Post(PostForm postForm) {

        this(1L,postForm.title(),postForm.content(), new Date(),generateSlug(postForm.title()),new ArrayList<>());
    }

    private static String generateSlug(String title) {
        return title.toLowerCase()
                .substring(0, Math.min(title.length(), 100))
                .replace(" ", "-");
    }
}

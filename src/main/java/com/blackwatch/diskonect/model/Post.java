package com.blackwatch.diskonect.model;

import lombok.NonNull;

import java.util.Date;
import java.util.List;

public record Post(
    @NonNull Long id,
    @NonNull String title,
    @NonNull String content,
    @NonNull Date createdAt,
    @NonNull String slug,
    @NonNull List<String> assets) {}

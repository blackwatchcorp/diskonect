package com.blackwatch.diskonect.model;

import lombok.NonNull;

public record PostForm(@NonNull String title, @NonNull String content) {}

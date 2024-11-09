package com.blackwatch.diskonect.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PostForm(
    @NotBlank(message = "title is mandatory")
        @Size(max = TITLE_MAX_LENGTH, message = TITLE_MAX_LEN_MSG)
        String title,
    @NotBlank(message = "content cannot be empty")
        @Size(max = CONTENT_MAX_LENGTH, message = CONTENT_MAX_LEN_MSG)
        String content) {

  private static final int TITLE_MAX_LENGTH = 250;
  private static final int CONTENT_MAX_LENGTH = 3500;

  private static final String MAX_LENGTH_MESSAGE = "must be less than ";
  private static final String CHARACTERS = " characters";

  private static final String TITLE_MAX_LEN_MSG =
      MAX_LENGTH_MESSAGE + TITLE_MAX_LENGTH + CHARACTERS;
  private static final String CONTENT_MAX_LEN_MSG =
      MAX_LENGTH_MESSAGE + CONTENT_MAX_LENGTH + CHARACTERS;
}

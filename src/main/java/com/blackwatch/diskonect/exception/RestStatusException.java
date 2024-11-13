package com.blackwatch.diskonect.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class RestStatusException extends ResponseStatusException {
  public RestStatusException(HttpStatusCode status) {
    super(status);
  }

  public RestStatusException(HttpStatusCode status, String reason) {
    super(status, reason);
  }

  public RestStatusException(int rawStatusCode, String reason, Throwable cause) {
    super(rawStatusCode, reason, cause);
  }

  public RestStatusException(HttpStatusCode status, String reason, Throwable cause) {
    super(status, reason, cause);
  }

  protected RestStatusException(
      HttpStatusCode status,
      String reason,
      Throwable cause,
      String messageDetailCode,
      Object[] messageDetailArguments) {
    super(status, reason, cause, messageDetailCode, messageDetailArguments);
  }
}

package com.chenslee.gitlab.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientUtils {

  public WebClient.Builder newBuilder() {
    return WebClient.builder().baseUrl("https://gitlab.com/").
      defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
  }
}

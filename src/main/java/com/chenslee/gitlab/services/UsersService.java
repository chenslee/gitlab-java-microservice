package com.chenslee.gitlab.services;


import com.chenslee.gitlab.models.User;
import com.chenslee.gitlab.utils.WebClientUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UsersService {

  private final WebClientUtils webUtils;

  public Mono<User> getUser(String id) {

    var webClient  = webUtils.newBuilder().build();

    // GitLab API returns a list of users, so we'll use a flux and just return the first one back as
    // the exact user.
    return webClient.get().uri(uriBuilder -> uriBuilder.path("/api/v4/users").queryParam("username", id).build())
        .exchangeToFlux(response -> response.bodyToFlux(User.class))
        .next();
  }
}

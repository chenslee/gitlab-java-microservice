package com.chenslee.gitlab.services;


import com.chenslee.gitlab.models.Repository;
import com.chenslee.gitlab.utils.WebClientUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class RepositoriesService {
  private final WebClientUtils webUtils;
  private final UsersService usersService;

  public Flux<Repository> getRepositories(String id) {
    // Technically, the API can use either the NAME of user or the ID, and the ID would be more
    // intuitive, however, I want to show how you can use a previous result from a mono into
    // a subsequent query to obtain more flux data.
    return usersService.getUser(id).flatMapMany(
        user -> getRepositoriesById(user.id())
    );
  }

  private Flux<Repository> getRepositoriesById(Long id) {
    var webClient  = webUtils.newBuilder().build();

    // GitLab API returns a list of users, so we'll use a flux and just return the first one back as
    // the exact user.
    return webClient.get().uri(uriBuilder -> uriBuilder.path("/api/v4/users/{id}/projects").build(id))
        .exchangeToFlux(response -> response.bodyToFlux(Repository.class));
  }
}

package com.chenslee.gitlab.controllers;


import com.chenslee.gitlab.models.Repository;
import com.chenslee.gitlab.models.User;
import com.chenslee.gitlab.services.RepositoriesService;
import com.chenslee.gitlab.services.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Tag(name = "Users", description = "For obtaining information about users")
@RequiredArgsConstructor
public class UsersController {

  private final UsersService usersService;
  private final RepositoriesService reposService;

  @GetMapping(value = "/api/v1/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Fetch public information for the specified user.")
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "Successful retrieval of a user",
              content =
              @Content(
                  array = @ArraySchema(schema = @Schema(implementation = User.class)),
                  mediaType = "application/json"))
      })
  public Mono<User> getUsers(@PathVariable() String id) {
    return usersService.getUser(id);
  }

  @GetMapping(value = "/api/v1/users/{id}/repos", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Fetch public repositories for the specified user.")
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "Successful retrieval of repositories",
              content =
              @Content(
                  array = @ArraySchema(schema = @Schema(implementation = Repository.class)),
                  mediaType = "application/json"))
      })
  public Flux<Repository> getRepos(@PathVariable() String id) {
    return reposService.getRepositories(id);
  }
}

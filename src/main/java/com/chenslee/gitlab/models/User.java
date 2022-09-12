package com.chenslee.gitlab.models;


/**
 * Represents a single user in GitLab
 */
public record User(String name, String username, Long id, String email) {

}

package com.chenslee.gitlab.models;


import com.fasterxml.jackson.annotation.JsonProperty;

public record Repository(String name, Long id, @JsonProperty("ssh_url_to_repo") String ssh_url, @JsonProperty("http_url_to_repo") String http_url) {

}

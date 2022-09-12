# GitLab Java Microservice

This project is an example java microservice to showcase general java skills.  It provides a REST
API for obtaining public project information for a user from GitLab.  This project is extremely basic
and is only intended to give a brief overview of several functions.

[![Release](https://github.com/cta800/gitlab-java-microservice/actions/workflows/release.yaml/badge.svg)](https://github.com/cta800/gitlab-java-microservice/actions/workflows/release.yaml)

# Building
This project builds using `gradle`.  To build the project, simply run `./gradlew build`.

## Building with docker
Alternatively, you can build using docker using a command similar to:

```docker build . -t gitlab-java-microservice```

# Running

To run the project locally, you can use gradle and the command `./gradlew bootRun`.  

## Running with docker

Once the container image has been build, you can run it from docker manually using a command such
as:

```docker run -p 8080:8080 gitlab-java-microservice```

# Swagger Endpoint

Once running, you can access the swagger-ui page by going here: http://localhost:8080/swagger-ui/index.html 
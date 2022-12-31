package com.example.auth0m2mdemo.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record M2MAuth0Token(@JsonProperty("access_token") String accessToken, @JsonProperty("scope") String scope) {

}

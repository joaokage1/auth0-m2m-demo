package com.example.auth0m2mdemo.server.controller;

import com.example.auth0m2mdemo.server.client.Auth0Client;
import com.example.auth0m2mdemo.server.exception.Auth0TokenException;
import com.example.auth0m2mdemo.server.model.M2MAuth0Token;
import com.example.auth0m2mdemo.server.model.M2MTokenRequest;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@Slf4j
public class M2MTokenController {

    @Autowired
    private Auth0Client auth0Client;

    @PostMapping("/m2m-token")
    public M2MAuth0Token getM2MToken(@RequestBody M2MTokenRequest tokenRequest) {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "client_credentials");
        params.add("audience", tokenRequest.audience());
        params.add("client_id", tokenRequest.clientId());
        params.add("client_secret", tokenRequest.clientSecret());

        M2MAuth0Token auth0Token = null;
        try {
            auth0Token = auth0Client.getToken(params);
            log.info("Token {}", auth0Token);
        } catch (FeignException.FeignClientException e) {
            log.error(e.getMessage());
            throw new Auth0TokenException("Failed to get token from Auth0", e);
        }

        return auth0Token;
    }
}

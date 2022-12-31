package com.example.auth0m2mdemo.server.client;

import com.example.auth0m2mdemo.server.model.M2MAuth0Token;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "auth0", url = "${auth0.m2m.domain}")
public interface Auth0Client {

    @PostMapping(value = "/oauth/token")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    M2MAuth0Token getToken(@RequestBody MultiValueMap<String, String> authRequest);
}
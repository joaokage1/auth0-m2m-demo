package com.example.auth0m2mdemo.server.exception;

public class Auth0TokenException extends RuntimeException{

    public Auth0TokenException(String message, Throwable cause) {
        super(message, cause);
    }
}

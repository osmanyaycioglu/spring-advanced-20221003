package com.training.spring.advanced.security;

import org.springframework.security.core.AuthenticationException;

public class RestSecurityException extends AuthenticationException {

    private static final long serialVersionUID = 9107403484705820715L;


    public RestSecurityException(final String message) {
        super(message);
    }

}

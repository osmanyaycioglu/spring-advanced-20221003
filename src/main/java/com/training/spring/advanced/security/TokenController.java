package com.training.spring.advanced.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private JWTService            jwt;

    @Autowired
    private AuthenticationManager auth;

    @GetMapping("/get")
    public String getToken(@RequestParam("user") final String username,
                           @RequestParam("pass") final String password,
                           @RequestHeader("x-forwarded-for") final String ip) {

        final Authentication authenticate = this.auth.authenticate(new UsernamePasswordAuthenticationToken(username,
                                                                                                           password));
        //        User user = (User) authenticate.getPrincipal();

        String generateJwtTokenLoc = this.jwt.generateJwtToken((UsernamePasswordAuthenticationToken) authenticate,
                                                               ip);
        return generateJwtTokenLoc;
    }

    @GetMapping("/refresh")
    public String refreshToken(@RequestHeader("Authorization") final String token,
                               @RequestHeader("x-forwarded-for") final String ip) {
        // impl
        return "OK";
    }

}

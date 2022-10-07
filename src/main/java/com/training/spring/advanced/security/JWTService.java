package com.training.spring.advanced.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

    private final Key myKey;

    public JWTService() {
        this.myKey = Keys.hmacShaKeyFor("ILovejwttokens126347862387y28746283746823746".getBytes());
    }

    public String generateJwtToken(final UsernamePasswordAuthenticationToken up,
                                   final String ipParam) {
        User user = (User) up.getPrincipal();
        String usernameLoc = user.getUsername();


        Map<String, Object> claims = new HashMap<>();
        claims.put("oip",
                   ipParam);
        String tokenLoc = Jwts.builder()
                              .setSubject(usernameLoc)
                              .setIssuedAt(new Date())
                              .setExpiration(new Date(System.currentTimeMillis() + (60 * 60 * 1000)))
                              .addClaims(claims)
                              .signWith(this.myKey)
                              .compact();
        return tokenLoc;
    }

    public Jws<Claims> validate(final String token) {
        try {
            JwtParser parserLoc = Jwts.parserBuilder()
                                      .setSigningKey(this.myKey)
                                      .build();
            Jws<Claims> parseClaimsJwsLoc = parserLoc.parseClaimsJws(token);
            return parseClaimsJwsLoc;
        } catch (Exception eLoc) {
            eLoc.printStackTrace();
            return null;
        }

    }


}

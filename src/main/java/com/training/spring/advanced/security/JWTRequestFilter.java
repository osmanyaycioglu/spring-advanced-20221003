package com.training.spring.advanced.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

// @Component
public class JWTRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService          jwtService;

    @Autowired
    private MyUserDetailService detailService;

    @Override
    protected void doFilterInternal(final HttpServletRequest requestParam,
                                    final HttpServletResponse responseParam,
                                    final FilterChain filterChainParam) throws ServletException, IOException {

        String headerLoc = requestParam.getHeader("Authorization");
        // Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvc21hbnkiLCJpYXQiOjE2NDM4ODY2MzIsImV4cCI6MTY0Mzg5MDIzMiwib2lwIjoiMTI3LjAuMC4xIn0.7YnzKqAwFuiQs8GdaWLGBqCwzXIgHVSJjRcn8kxgUeI
        String pathTranslatedLoc = requestParam.getPathTranslated();
        System.out.println(pathTranslatedLoc);
        if (headerLoc != null) {
            if (!headerLoc.startsWith("Bearer ")) {
                throw new RestSecurityException("Authorization header ı yok");
            }
            String token = headerLoc.substring(7);
            Jws<Claims> validateLoc = this.jwtService.validate(token);
            if (validateLoc == null) {
                throw new RestSecurityException("not a valid token");
            }
            Claims bodyLoc = validateLoc.getBody();
            String oipLoc = bodyLoc.get("oip",
                                        String.class);
            String ipLoc = requestParam.getHeader("x-forwarded-for");
            if ((oipLoc == null) || (ipLoc == null)) {
                throw new RestSecurityException("ip header missing");
            }
            if (!ipLoc.equals(oipLoc)) {
                throw new RestSecurityException("not a valid ip for token");
            }
            String subjectLoc = bodyLoc.getSubject();
            User loadUserByUsernameLoc = (User) this.detailService.loadUserByUsername(subjectLoc);
            if (loadUserByUsernameLoc == null) {
                throw new RestSecurityException("not a valid user");

            }
            UsernamePasswordAuthenticationToken upa = new UsernamePasswordAuthenticationToken(loadUserByUsernameLoc,
                                                                                              null,
                                                                                              loadUserByUsernameLoc.getAuthorities());
            upa.setDetails(new WebAuthenticationDetailsSource().buildDetails(requestParam));
            SecurityContextHolder.getContext()
                                 .setAuthentication(upa);
        }
        filterChainParam.doFilter(requestParam,
                                  responseParam);

    }

}

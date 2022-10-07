package com.training.spring.advanced.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public class MyUserDetailService implements UserDetailsService {

    private BCryptPasswordEncoder encoder;
    @Autowired
    private IRestUserDao          restUserDao;

    public MyUserDetailService(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        RestUser restUser = restUserDao.findById(username)
                                       .orElse(null);
        if (restUser == null) {
            throw new UsernameNotFoundException("User yok");
        }
        return User.builder()
                   .username(restUser.getUsername())
                   .password(encoder.encode(restUser.getPassword()))
                   .roles(restUser.getRole())
                   .build();
    }

}

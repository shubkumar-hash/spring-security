package com.example.spring_security_stateless.service;

import com.example.spring_security_stateless.model.User;
import com.example.spring_security_stateless.model.UserPrincipal;
import com.example.spring_security_stateless.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("404 Not Found");
        }

        return new UserPrincipal(user);
    }
}

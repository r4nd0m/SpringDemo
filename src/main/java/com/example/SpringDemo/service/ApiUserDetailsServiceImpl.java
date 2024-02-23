package com.example.SpringDemo.service;

import com.example.SpringDemo.data.ApiUser;
import com.example.SpringDemo.data.ApiUserRepository;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApiUserDetailsServiceImpl implements UserDetailsService {
    private final ApiUserRepository apiUserRepository;

    public ApiUserDetailsServiceImpl(ApiUserRepository apiUserRepository) {
        this.apiUserRepository = apiUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ApiUser> user = apiUserRepository.findByUsername(username);

        UserBuilder builder;

        if (user.isPresent()) {
            ApiUser currentUser = user.get();
            builder = org.springframework.security.core.userdetails.User
                    .withUsername(currentUser.getUsername())
                    .password(currentUser.getPassword())
                    .roles(currentUser.getRole());
        } else {
            throw new UsernameNotFoundException("User not found");
        }

        return builder.build();
    }
}

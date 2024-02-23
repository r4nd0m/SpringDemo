package com.example.SpringDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Objects;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private final Environment environment;

    public SecurityConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.builder()
                                .username(
                                    Objects.requireNonNull(
                                        environment.getProperty("application.settings.user")
                                    )
                                )
                                .password(
                                    passwordEncoder().encode(
                                        Objects.requireNonNull(
                                            environment.getProperty("application.settings.password")
                                        )
                                    )
                                )
                                .roles("USER")
                                .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

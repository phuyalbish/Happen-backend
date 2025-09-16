package com.happen.happen_app.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
            .requestMatchers(HttpMethod.GET, "/api/events/**").permitAll()
            .requestMatchers(HttpMethod.POST, "/api/events/**").authenticated()
            .requestMatchers(HttpMethod.PUT, "/api/events/**").authenticated()
            .requestMatchers(HttpMethod.DELETE, "/api/events/**").authenticated()

            .requestMatchers(HttpMethod.GET, "/api/tickets/**").permitAll()
            .requestMatchers(HttpMethod.POST, "/api/tickets/**").authenticated()
            .requestMatchers(HttpMethod.PUT, "/api/tickets/**").authenticated()
            .requestMatchers(HttpMethod.DELETE, "/api/tickets/**").authenticated()

            .requestMatchers(HttpMethod.GET, "/api/venues/**").permitAll()
            .requestMatchers(HttpMethod.POST, "/api/venues/**").authenticated()
            .requestMatchers(HttpMethod.PUT, "/api/venues/**").authenticated()
            .requestMatchers(HttpMethod.DELETE, "/api/venues/**").authenticated()

            .requestMatchers(HttpMethod.GET, "/api/roles/**").authenticated()
            .requestMatchers(HttpMethod.POST, "/api/roles/**").authenticated()
            .requestMatchers(HttpMethod.PUT, "/api/roles/**").authenticated()
            .requestMatchers(HttpMethod.DELETE, "/api/roles/**").authenticated()

            .requestMatchers(HttpMethod.GET, "/api/users/**").authenticated()
            .requestMatchers(HttpMethod.POST, "/api/users/**").authenticated()
            .requestMatchers(HttpMethod.PUT, "/api/users/**").authenticated()
            .requestMatchers(HttpMethod.DELETE, "/api/users/**").authenticated()
            ).httpBasic(httpBasic -> {}) // Enable Basic Auth
            .formLogin(form -> form.disable());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Define an in-memory user for testing
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails user = User.withUsername("testuser")
                .password(encoder.encode("testpass"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
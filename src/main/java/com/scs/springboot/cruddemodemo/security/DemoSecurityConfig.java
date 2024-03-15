package com.scs.springboot.cruddemodemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {


  @Bean
  public InMemoryUserDetailsManager userDetailsManager() {

    UserDetails leslie = User.builder()
        .username("leslie")
        .password("{noop}leslie")
        .roles("EMPLOYEE")
        .build();

    UserDetails emma = User.builder()
        .username("emma")
        .password("{noop}emma")
        .roles("EMPLOYEE", "MANAGER")
        .build();

    UserDetails avani = User.builder()
        .username("avani")
        .password("{noop}avani")
        .roles("EMPLOYEE", "MANAGER", "ADMIN")
        .build();
    return new InMemoryUserDetailsManager(leslie, emma, avani);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(configurer -> {
      configurer.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
          .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
          .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
          .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
          .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN");
    });
    http.httpBasic(Customizer.withDefaults());
    http.csrf(csrf -> csrf.disable());
    return http.build();

  }
}

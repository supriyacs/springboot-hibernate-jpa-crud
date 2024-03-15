package com.scs.springboot.cruddemodemo.security;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {


  @Bean
  UserDetailsManager userDetailsManager(DataSource dataSource){
    JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager(dataSource);
    //define a query to retrieve by username
    jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=? ");
    //define a query to retrieve authorities/roles by username
    jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=? ");
    return  jdbcUserDetailsManager;
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

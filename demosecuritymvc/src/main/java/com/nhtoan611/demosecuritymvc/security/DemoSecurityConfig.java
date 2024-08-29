package com.nhtoan611.demosecuritymvc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager () {
        UserDetails john = User.builder().username("john").password("{noop}123").roles("EMPLOYEE").build();
        UserDetails mary = User.builder().username("mary").password("{noop}123").roles("EMPLOYEE", "MANAGER").build();
        UserDetails susan = User.builder().username("susan").password("{noop}123").roles("EMPLOYEE", "MANAGER", "ADMIN").build();
        return new InMemoryUserDetailsManager(john, mary, susan);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(config ->
                config.requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/showLoginPage") // Request mapping to show login form
                        .loginProcessingUrl("/authenticateUser") // Login form must be POST data to this URL
                        .permitAll() // everyone can see login form
                ).logout(logout -> logout.permitAll()) // logout support
                .exceptionHandling(config -> config.accessDeniedPage("/access-denied")); // For handling error page
        return httpSecurity.build();
    }
}

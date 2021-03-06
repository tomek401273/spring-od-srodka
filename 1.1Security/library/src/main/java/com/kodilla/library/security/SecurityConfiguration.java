package com.kodilla.library.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable();

        httpSecurity.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/books/**")
                .hasAnyRole("USER", "LIBRARIAN", "ADMIN")
                .mvcMatchers(HttpMethod.POST, "/**")
                .hasAnyRole("LIBRARIAN", "ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/**")
                .hasAnyRole("ADMIN")
                .anyRequest()
                .fullyAuthenticated()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.inMemoryAuthentication().withUser("user").password("user").roles("USER");
        authenticationManagerBuilder.inMemoryAuthentication().withUser("librarian").password("librarian").roles("LIBRARIAN");
        authenticationManagerBuilder.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder(){
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}

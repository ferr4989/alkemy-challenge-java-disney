package com.nesper.alkemy.springboot.disney.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder build) throws Exception{
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/auth/register/").permitAll()
                .antMatchers("/users/**", "/deleteUser/{id}", "/deleteMovie/{id}", "/updateMovie/{id}",
                        "/createMovie", "/createGenre", "/updateGenre/{id}", "/deleteGenre/{id}",
                        "/createCharacter", "/updateCharacter/{id}", "/deleteCharacter/{id}")
                .hasRole("ADMIN")
                .antMatchers("/characters/**", "/movies/**", "/genre/**")
                .hasAnyRole("USER","ADMIN")
                .and()
                .formLogin();
        }
}

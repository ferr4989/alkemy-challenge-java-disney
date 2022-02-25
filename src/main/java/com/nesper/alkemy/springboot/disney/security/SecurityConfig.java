package com.nesper.alkemy.springboot.disney.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotEmpty;

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
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests()
                .antMatchers("/auth/login/**", "/auth/register/**", "/sendEmail/**").permitAll()
                .antMatchers("/users/**", "/characters/**", "/movies/**", "/genre/**")
                .permitAll()
//                .hasRole("ADMIN")
                .antMatchers("/")
                .hasAnyRole("USER","ADMIN")
                .and()
                .formLogin()
                //.loginPage("/login")
        ;
    }

    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ConfigAutenticacionFilter configAutenticacionFilter = new ConfigAutenticacionFilter(authenticationManagerBean());
        configAutenticacionFilter.setFilterProcessesUrl("/auth/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().antMatchers("/auth/login/**", "/auth/register/**").permitAll();
//        FALTA IMPLEMENTAR ROLES:
//        http.authorizeRequests().antMatchers(GET, "/api/user/**").hasAnyAuthority("ROL_USUARIO");
//        http.authorizeRequests().antMatchers(POST, "/auth/usuarios", "/auth/rol/**").hasAnyAuthority("ROL_ADMIN");
//        http.authorizeRequests().antMatchers(GET, "/**").hasAnyAuthority("ROL_ADMIN");
        http.authorizeRequests().anyRequest()
                .authenticated();
//                .permitAll();
        http.addFilter(configAutenticacionFilter);
        http.addFilterBefore(new ConfigAutorizacionFilter(), UsernamePasswordAuthenticationFilter.class);
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
    */


}

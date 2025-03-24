package com.security;

// This is deprecated class use java 8 for use this is basic authentication
// Each time we have to pass user and password
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.security.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private MyService myService;
//    extends WebSecurityConfigurerAdapter
    //    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests()
//                .antMatchers("/member").authenticated()
//                .antMatchers("/admin").authenticated()
//                .anyRequest().permitAll()
//                .and()
//                .httpBasic();


    // For in memory Authentication
//        http.authorizeHttpRequests()
//                .antMatchers("/member").hasRole("MEMBER")
//                .antMatchers("/admin").hasRole("ADMIN")
//                .anyRequest().permitAll()
//                .and()
//                .httpBasic()
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/error/403"); // Controller mai error/403 page hona chahiye
//
//    }
//}

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin123")
//                .password(bCryptPasswordEncoder().encode("admin123"))
//                .roles("ADMIN")
//                .and()
//                .withUser("member123")
//                .password(bCryptPasswordEncoder().encode("member123"))
//                .roles("ADMIN");

        auth.userDetailsService(myService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


}



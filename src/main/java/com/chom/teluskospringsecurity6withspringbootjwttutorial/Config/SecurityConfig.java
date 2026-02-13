package com.chom.teluskospringsecurity6withspringbootjwttutorial.Config;


import com.chom.teluskospringsecurity6withspringbootjwttutorial.Models.User;
import com.chom.teluskospringsecurity6withspringbootjwttutorial.Repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    private final UserDetailsService userDetailsService;
//
//    public SecurityConfig(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
    @Autowired UserRep userRep;


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){

        return httpSecurity
                        .csrf(AbstractHttpConfigurer::disable)
                        .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                        .httpBasic(Customizer.withDefaults())
//                        .formLogin(Customizer.withDefaults())
                        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                        .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login"))
                        .build();
    }

//    @Bean
//    public AuthenticationProvider authenticationProvider(){
//
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//        return provider;
//
//    }

    @Bean
    UserDetailsService userDetailsService() throws Exception{
        return username ->{
            User user = userRep.findByUsername(username);
            System.out.println(user);
            if (user == null)
                throw new UsernameNotFoundException("user didn't exist");
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), List.of(new SimpleGrantedAuthority("USER")));
        };
    }

//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }

    @Bean
    PasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder(4);
    }

}

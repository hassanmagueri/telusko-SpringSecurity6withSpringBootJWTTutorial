package com.chom.teluskospringsecurity6withspringbootjwttutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.csrf.XorCsrfTokenRequestAttributeHandler;

@SpringBootApplication
public class TeluskoSpringSecurity6withSpringBootJwtTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeluskoSpringSecurity6withSpringBootJwtTutorialApplication.class, args);
    }

}

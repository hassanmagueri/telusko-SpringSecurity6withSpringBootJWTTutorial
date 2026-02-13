package com.chom.teluskospringsecurity6withspringbootjwttutorial.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello(HttpServletRequest request ){
        request.getSession().getId();
        request.getRemoteUser();
        return "Hello: " + request.getRemoteUser();
    }

    @GetMapping("/csrf-token")
    public CsrfToken cs(HttpServletRequest request){
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
//        return "token id: " + ((CsrfToken) request.getAttribute("_csrf")).getToken() + "\n-----------session id: " + request.getSession().getId();
    }
}

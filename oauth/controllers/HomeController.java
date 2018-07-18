package com.oauth.oauth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {



    @GetMapping("/")
    public String home(){
        return "Hello";
    }

    @GetMapping("/private")
    public String privateArea(){
        return "private";
    }

    @GetMapping("/admin")
    public String adminArea(){
        return "ONLY ADMIN";
    }

}

package com.oauth.oauth;

import com.oauth.oauth.entities.Role;
import com.oauth.oauth.entities.User;
import com.oauth.oauth.reporitories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;

@SpringBootApplication
public class OauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class, args);
    }


    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repo) throws Exception {

        if (repo.count() == 0){
            repo.save(new User("user","user", Arrays.asList(new Role("ROLE_USER"),new Role("ROLE_ACTURATOR"))));
            repo.save(new User("admin","admin", Arrays.asList(new Role("ROLE_ADMIN"),new Role("ROLE_ACTURATOR"))));
        }
        builder.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
               return new CostumUserDetails(repo.findByUsername(s));
            }
        });
    }
}

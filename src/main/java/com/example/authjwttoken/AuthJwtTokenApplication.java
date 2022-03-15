package com.example.authjwttoken;

import com.example.authjwttoken.domain.Role;
import com.example.authjwttoken.domain.User;
import com.example.authjwttoken.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;


@SpringBootApplication
public class AuthJwtTokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthJwtTokenApplication.class, args);

    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner runner (UserService userService){
        return args -> {
            userService.saveRole(new Role(null,"ROLE_USER"));
            userService.saveRole(new Role(null,"ROLE_MANAGER"));
            userService.saveRole(new Role(null,"ROLE_ADMIN"));
            userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null,"Danil", "Kyrgyzbaev","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"Aidar", "Bakirov","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"Nurgazy", "Sulaimanov","1234",new ArrayList<>()));
            userService.saveUser(new User(null,"Rustam", "Kanaev","1234",new ArrayList<>()));

            userService.adRoleToUser("Kyrgyzbaev","ROLE_SUPER_ADMIN");
            userService.adRoleToUser("Bakirov","ROLE_ADMIN");
            userService.adRoleToUser("Sulaimanov","ROLE_MANAGER");
            userService.adRoleToUser("Kanaev","ROLE_USER");
        };
    }
}

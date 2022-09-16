package com.learningstuff.springboottest;

import com.learningstuff.springboottest.models.User;
import com.learningstuff.springboottest.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class SpringBootTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    CommandLineRunner start(UserRepository userRepository) {
        return args -> {

            List<User> all = userRepository.findAll();

            if (all.isEmpty()) {
                userRepository.save(new User(1, "User1"));
                userRepository.save(new User(2, "User2"));
                userRepository.save(new User(3, "User3"));
                userRepository.save(new User(4, "User4"));
                userRepository.save(new User(5, "User5"));
                userRepository.save(new User(6, "User6"));
            }


        };
    }

}

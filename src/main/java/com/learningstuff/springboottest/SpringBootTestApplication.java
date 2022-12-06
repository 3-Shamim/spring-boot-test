package com.learningstuff.springboottest;

import com.learningstuff.springboottest.models.User;
import com.learningstuff.springboottest.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;

@Slf4j
@EnableScheduling
@SpringBootApplication
public class SpringBootTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestApplication.class, args);
    }

    @PostConstruct
    void started() {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        TimeZone.setDefault(timeZone);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    CommandLineRunner start(UserRepository userRepository) {
        return args -> {

            List<User> all = userRepository.findAll();

            LocalDate localDate = LocalDate.now();
            LocalDateTime localDateTime = LocalDateTime.parse("2022-12-06T00:00:00");

            log.info("Local Date: {}. Local Date Time: {}", localDate, localDateTime);

            if (all.isEmpty()) {
                userRepository.save(new User(1, "User1", localDate, localDateTime));
                userRepository.save(new User(2, "User2", localDate, localDateTime));
                userRepository.save(new User(3, "User3", localDate, localDateTime));
                userRepository.save(new User(4, "User4", localDate, localDateTime));
                userRepository.save(new User(5, "User5", localDate, localDateTime));
                userRepository.save(new User(6, "User6", localDate, localDateTime));
            }


        };
    }

}

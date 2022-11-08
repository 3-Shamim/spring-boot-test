package com.learningstuff.springboottest;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim Molla
 * Email: shamim.molla@vivasoftltd.com
 */

@Component
public class Schedule {

    @Scheduled(cron = "0 0/2 * * * ?")
//    @Scheduled(fixedRate = 1000)
    public void timer() {
        System.out.println(LocalDateTime.now());
    }

}

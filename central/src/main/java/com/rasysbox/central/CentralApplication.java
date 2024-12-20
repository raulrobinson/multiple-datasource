package com.rasysbox.central;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.rasysbox"})
@EnableFeignClients
public class CentralApplication {

    public static void main(String[] args) {
        SpringApplication.run(CentralApplication.class, args);
    }

}

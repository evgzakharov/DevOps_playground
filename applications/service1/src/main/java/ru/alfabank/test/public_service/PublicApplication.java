package ru.alfabank.test.public_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableFeignClients
@EnableEurekaClient
public class PublicApplication {

    private Integer increment;
    private MultiplyClient multiplyClient;

    public PublicApplication(@Value("${increment.value}") Integer increment, MultiplyClient multiplyClient) {
        this.increment = increment;
        this.multiplyClient = multiplyClient;
    }

    @GetMapping("/api")
    public Integer api(@RequestParam(name = "value") Integer value) {
        return multiplyClient.multiplyValue(value) + increment;
    }

    public static void main(String[] args) {
        SpringApplication.run(PublicApplication.class, args);
    }
}

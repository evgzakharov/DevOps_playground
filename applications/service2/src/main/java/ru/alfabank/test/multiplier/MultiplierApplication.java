package ru.alfabank.test.multiplier;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class MultiplierApplication {

    private Integer multiply;

    public MultiplierApplication(@Value("${multiply.value}") Integer multiply) {
        this.multiply = multiply;
    }

    @GetMapping("/multiply")
    public Integer multiplyValue(@RequestParam(name = "value") Integer value) {
        return value * multiply;
    }

    public static void main(String[] args) {
        SpringApplication.run(MultiplierApplication.class, args);
    }
}

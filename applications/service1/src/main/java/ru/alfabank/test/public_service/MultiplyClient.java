package ru.alfabank.test.public_service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "multiply")
public interface MultiplyClient {

    @RequestMapping(method = RequestMethod.GET, value = "/multiply")
    Integer multiplyValue(@RequestParam("value") Integer value);
}

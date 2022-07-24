package com.edu.usermsclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserClientResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserClientResource.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/users-client")
    @HystrixCommand(fallbackMethod = "getUsersFromFallback",
        commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
        })
    public List getUsersFromUserms() {
        LOGGER.info("**** calling userms ****");
        return restTemplate.getForObject("http://userms/users", List.class);
    }

    /*@HystrixCommand(fallbackMethod = "getsomeothermsFallback",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
            })*/
    private List getUsersFromFallback() {
       // return restTemplate.getForObject("http://someotherms/users", List.class);
        return Arrays.asList("A", "B", "C");
    }
}

package io.github.ji0610.deadlinetracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public HelloResponse hello(@RequestParam(defaultValue = "world.") String name) {
        return new HelloResponse("Hello, " + name);
    }
}

package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping
    public String hello() {
        return "Hello!";
    }

    @GetMapping(value = "hello2")
    public String hello2() {
        return "Hello2!";
    }

    @GetMapping("hello2/embedded")  // domyślnie value
    public String embeddedHello() {
        return "Hello from the inside!";
    }
}

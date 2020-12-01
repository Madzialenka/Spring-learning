package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("goodbye")
@RestController
public class GoodbyeController {

    @GetMapping
    public String goodbye() {
        return "Goodbye!";
    }

    @GetMapping("{name}")   // zmienna, parametr w ścieżce (w URL'u)
    public String goodbyeWithName(@PathVariable("name") String name) {
        return "Goodbye " + name + "!";
    }

    @GetMapping("smart/{name}")
    public String goodbyeSmartWithName(@PathVariable("name") String name) {
        return "Goodbye smart " + name + "!";
    }

    @GetMapping("{name}/{age}")
    public String goodbyeWithNameAndAge(@PathVariable("name") String name, @PathVariable("age") Integer age) {
        return "Goodbye " + age + " years old " + name + "!";
    }
}

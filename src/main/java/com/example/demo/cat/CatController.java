package com.example.demo.cat;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("cats")
@RestController
public class CatController {

    private final CatService catService;
    private final CatService catService2;

    public CatController(CatService catService,@Qualifier("catService2") CatService catService2) {
        this.catService = catService;
        this.catService2 = catService2;
    }

    @GetMapping
    public String getCats() {
        return catService.getCats();
    }

    @GetMapping("2")
    public String getCats2() {
        return catService2.getCats();
    }
}

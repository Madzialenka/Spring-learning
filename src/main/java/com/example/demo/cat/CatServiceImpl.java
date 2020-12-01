package com.example.demo.cat;

import java.util.Arrays;

public class CatServiceImpl implements CatService {

    @Override
    public String getCats() {
        return String.join(", ", Arrays.asList("Lili", "Puszek"));
    }
}

package com.example.apilab1.controller;

import com.example.apilab1.model.Cocktail;
import com.example.apilab1.model.Coffee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CocktailController {
    private final AtomicLong counter = new AtomicLong();
    @GetMapping(value = "/cocktailLover")
    public String cocktailLover(){
        return "I LOVE cocktails!";
    }
    @GetMapping("/cocktail")
    public Cocktail cocktail(@RequestParam(value = "name", defaultValue =
            "mojito") String name) {
        return new Cocktail(counter.incrementAndGet(), name);
    }
}
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("dogs")
@RestController
public class DogController {

    private final DogService dogService;

    @Autowired   // nad polem, metodą lub najlepiej nad konstruktorem - opcjonalne, gdy jest 1 konstruktor
                 // wskazanie miejsca wstrzyknięcia zależności
    public DogController(DogService dogService) { // dependency injection - wstrzyknięcie zależności - Spring przekazuje
        this.dogService = dogService;             // utworzone komponenty (Component - tu Service) danego typu do konstruktora
    }

    @GetMapping
    public String getDogs(@RequestParam(value = "prefix", required = false) String prefix) {
        return dogService.getDogs(prefix);
    }

    @PostMapping
    public void createDog(@RequestBody String dog) {
        dogService.createDog(dog);
    }

    @PutMapping("{oldDogName}")
    public void updateDog(@PathVariable String oldDogName, @RequestBody String newDogName) {
        dogService.updateDog(oldDogName, newDogName);
    }

    @DeleteMapping("{dog}")
    public void deleteDog(@PathVariable String dog) {
        dogService.deleteDog(dog);
    }
}

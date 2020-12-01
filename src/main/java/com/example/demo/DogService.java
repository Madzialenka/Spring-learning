package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DogService {

    private List<String> dogs = new ArrayList<>(Arrays.asList("Burek", "Bąbel", "Reksio", "Rosa"));

    public String getDogs(String prefix) {
        if (prefix == null) {
            return String.join(", ", dogs);
        }
        return dogs.stream()
                .filter((dog) -> dog.startsWith(prefix))
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
    }

    public void createDog(String dog) {
        dogs.add(dog);
    }

    public void updateDog(String oldDogName, String newDogName) {
        int index = dogs.indexOf(oldDogName);
        dogs.set(index, newDogName);
    }

    public void deleteDog(String dog) {
        dogs.remove(dog);
    }
}

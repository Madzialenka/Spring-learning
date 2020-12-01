package com.example.demo.flowers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FlowerServiceImpl implements FlowerService {
    private List<Flower> flowers = new ArrayList<>(Arrays.asList(
            new Flower(1, "Tulipan", Color.PINK, true, 20),
            new Flower(2, "Słonecznik", Color.YELLOW, false, 100)
    ));

    @Override
    public List<Flower> getFlowers() {
        return flowers;
    }

    @Override
    public void createFlower(Flower flower) {
        int id = flowers.stream()
                .map(Flower::getId)
                .max(Integer::compareTo)
                .orElse(0);
        flower.setId(id + 1);
        flowers.add(flower);
    }

    @Override
    public void updateFlower(int id, Flower flower) {
        flowers.stream()
                .filter(existingFlower -> existingFlower.getId() == id)
                .findFirst()
                .ifPresent(foundFlower -> {
                    foundFlower.setName(flower.getName());
                    foundFlower.setColor(flower.getColor());
                    foundFlower.setBeautiful(flower.isBeautiful());
                    foundFlower.setHeight(flower.getHeight());
                });
    }

    @Override
    public void deleteFlower(int id) {
        flowers.removeIf(flower -> flower.getId() == id);
    }
}

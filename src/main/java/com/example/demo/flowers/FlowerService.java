package com.example.demo.flowers;

import java.util.List;

public interface FlowerService {
    List<Flower> getFlowers();

    void createFlower(Flower flower);

    void updateFlower(int id, Flower flower);

    void deleteFlower(int id);
}

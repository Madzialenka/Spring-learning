package com.example.demo.flowers;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("flowers")
@RestController
public class FlowerController {

    private FlowerService flowerService;

    public FlowerController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @GetMapping
    public List<Flower> getFlowers() {
        return flowerService.getFlowers();
    }

    @PostMapping
    public void createFlower(@RequestBody Flower flower) {
        flowerService.createFlower(flower);
    }

    @PutMapping("{id}")
    public void updateFlower(@PathVariable("id") int id, @RequestBody Flower flower) {
        flowerService.updateFlower(id, flower);
    }

    @DeleteMapping("{id}")
    public void deleteFlower(@PathVariable("id") int id) {
        flowerService.deleteFlower(id);
    }
}

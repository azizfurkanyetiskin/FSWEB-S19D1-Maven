package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/fruit", "/workintech/fruits"})
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> getFruits() {
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Fruit> getFruitsDesc() {
        return fruitService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public Fruit getById(@PathVariable long id) {
        return fruitService.getById(id);
    }

    @PostMapping
    public Fruit save(@Valid @RequestBody Fruit fruit) {
        return fruitService.save(fruit);
    }

    @GetMapping("/name/{name}")
    public List<Fruit> getByName(@PathVariable String name) {
        return fruitService.searchByName(name);
    }

    @PostMapping("/{name}")
    public List<Fruit> searchByNamePost(@PathVariable String name) {
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable long id) {
        return fruitService.delete(id);
    }
}
package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/vegetable", "/workintech/vegetables"})
public class VegetableController {

    private final VegetableService vegetableService;

    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> getVegetables() {
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Vegetable> getVegetablesDesc() {
        return vegetableService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public Vegetable getById(@PathVariable long id) {
        return vegetableService.getById(id);
    }

    @PostMapping
    public Vegetable save(@Valid @RequestBody Vegetable vegetable) {
        return vegetableService.save(vegetable);
    }

    @GetMapping("/name/{name}")
    public List<Vegetable> getByName(@PathVariable String name) {
        return vegetableService.searchByName(name);
    }

    @PostMapping("/{name}")
    public List<Vegetable> searchByNamePost(@PathVariable String name) {
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable long id) {
        return vegetableService.delete(id);
    }
}
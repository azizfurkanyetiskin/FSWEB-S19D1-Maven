package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;

import java.util.List;

public interface FruitService {

    Fruit save(Fruit fruit);

    Fruit getById(long id);

    List<Fruit> getByPriceAsc();

    List<Fruit> getByPriceDesc();

    List<Fruit> searchByName(String name);

    Fruit delete(long id);

    List<Fruit> findAll();

    Fruit findById(Long id);

    Fruit deleteById(Long id);

    List<Fruit> findAllByOrderByPriceAsc();

    List<Fruit> findAllByOrderByPriceDesc();

    List<Fruit> findByNameContaining(String name);
}
package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableService {

    Vegetable save(Vegetable vegetable);

    Vegetable getById(long id);

    List<Vegetable> getByPriceAsc();

    List<Vegetable> getByPriceDesc();

    List<Vegetable> searchByName(String name);

    Vegetable delete(long id);

    List<Vegetable> findAll();

    Vegetable findById(Long id);

    Vegetable deleteById(Long id);

    List<Vegetable> findAllByOrderByPriceAsc();

    List<Vegetable> findAllByOrderByPriceDesc();

    List<Vegetable> findByNameContaining(String name);
}
package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.FruitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceImpl implements FruitService {

    private final FruitRepository fruitRepository;

    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }
    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit getById(long id) {
        validateId(id);

        return fruitRepository.findById(id)
                .orElseThrow(() ->
                        new PlantException(
                                "Fruit not found with id: " + id,
                                HttpStatus.NOT_FOUND
                        )
                );
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }

    @Override
    public Fruit delete(long id) {
        Fruit fruit = getById(id);
        fruitRepository.delete(fruit);
        return fruit;
    }

    @Override
    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit findById(Long id) {
        return getById(id);
    }

    @Override
    public Fruit deleteById(Long id) {
        return delete(id);
    }

    @Override
    public List<Fruit> findAllByOrderByPriceAsc() {
        return getByPriceAsc();
    }

    @Override
    public List<Fruit> findAllByOrderByPriceDesc() {
        return getByPriceDesc();
    }

    @Override
    public List<Fruit> findByNameContaining(String name) {
        return searchByName(name);
    }

    private void validateId(long id) {
        if (id < 0) {
            throw new PlantException(
                    "Id cannot be negative",
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
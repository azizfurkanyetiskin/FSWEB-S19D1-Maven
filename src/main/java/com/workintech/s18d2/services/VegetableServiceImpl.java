package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.VegetableRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VegetableServiceImpl implements VegetableService {

    private final VegetableRepository vegetableRepository;

    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        if (vegetable == null ||
                vegetable.getName() == null ||
                vegetable.getName().trim().isEmpty() ||
                vegetable.getPrice() == null ||
                vegetable.getIsGrownOnTree() == null) {

            throw new PlantException(
                    "Vegetable fields cannot be null",
                    HttpStatus.BAD_REQUEST
            );
        }

        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable getById(long id) {
        validateId(id);

        return vegetableRepository.findById(id)
                .orElseThrow(() ->
                        new PlantException(
                                "Vegetable not found with id: " + id,
                                HttpStatus.NOT_FOUND
                        )
                );
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }

    @Override
    public Vegetable delete(long id) {
        Vegetable vegetable = getById(id);
        vegetableRepository.delete(vegetable);
        return vegetable;
    }

    @Override
    public List<Vegetable> findAll() {
        return vegetableRepository.findAll();
    }

    @Override
    public Vegetable findById(Long id) {
        return getById(id);
    }

    @Override
    public Vegetable deleteById(Long id) {
        return delete(id);
    }

    @Override
    public List<Vegetable> findAllByOrderByPriceAsc() {
        return getByPriceAsc();
    }

    @Override
    public List<Vegetable> findAllByOrderByPriceDesc() {
        return getByPriceDesc();
    }

    @Override
    public List<Vegetable> findByNameContaining(String name) {
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
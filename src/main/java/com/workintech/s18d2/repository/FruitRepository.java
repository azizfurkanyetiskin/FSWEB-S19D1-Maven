package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {

    @Query("SELECT f FROM Fruit f ORDER BY f.price DESC")
    List<Fruit> getByPriceDesc();

    @Query("SELECT f FROM Fruit f ORDER BY f.price ASC")
    List<Fruit> getByPriceAsc();

    @Query("SELECT f FROM Fruit f WHERE LOWER(f.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Fruit> searchByName(@Param("name") String name);

    List<Fruit> findAllByOrderByPriceAsc();

    List<Fruit> findAllByOrderByPriceDesc();

    List<Fruit> findByNameContaining(String name);
}
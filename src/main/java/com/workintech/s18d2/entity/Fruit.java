package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fruit", schema = "fsweb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Fruit name cannot be empty")
    private String name;

    @NotNull(message = "Fruit price cannot be null")
    @Positive(message = "Fruit price must be greater than zero")
    private Double price;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Fruit type cannot be null")
    private FruitType fruitType;

    public Fruit(Integer id, String name, Double price, FruitType fruitType) {
        this.id = id == null ? null : id.longValue();
        this.name = name;
        this.price = price;
        this.fruitType = fruitType;
    }
}
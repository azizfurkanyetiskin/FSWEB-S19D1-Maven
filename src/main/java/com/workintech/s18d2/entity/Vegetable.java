package com.workintech.s18d2.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vegetable", schema = "fsweb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vegetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Vegetable name cannot be empty")
    private String name;

    @NotNull(message = "Vegetable price cannot be null")
    @Positive(message = "Vegetable price must be greater than zero")
    private Double price;

    @NotNull(message = "isGrownOnTree cannot be null")
    @JsonProperty("isGrownOnTree")
    @Column(name = "is_grown_on_tree")
    private Boolean isGrownOnTree;

    public Vegetable(Integer id, String name, Double price, Boolean isGrownOnTree) {
        this.id = id == null ? null : id.longValue();
        this.name = name;
        this.price = price;
        this.isGrownOnTree = isGrownOnTree;
    }

    public Boolean isGrownOnTree() {
        return isGrownOnTree;
    }

    public void setGrownOnTree(Boolean grownOnTree) {
        this.isGrownOnTree = grownOnTree;
    }
}
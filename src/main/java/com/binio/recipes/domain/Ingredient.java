package com.binio.recipes.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    public Ingredient(String description, BigDecimal amout, UnitOfMeasure unitMeasure, Recipe recipe) {
        this.description = description;
        this.amout = amout;
        this.unitMeasure = unitMeasure;
        this.recipe = recipe;
    }

    public Ingredient() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amout;
    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure unitMeasure;
    @ManyToOne
    private Recipe recipe;


}

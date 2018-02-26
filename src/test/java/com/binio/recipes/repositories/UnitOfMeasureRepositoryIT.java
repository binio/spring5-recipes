package com.binio.recipes.repositories;

import com.binio.recipes.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository repository;

    @Before
    public void setUp() {

    }
    @Test
    public void findByOum() {
        Optional<UnitOfMeasure> unit = repository.findByOum("Tablespoon");
        assertEquals("Tablespoon", unit.get().getOum());
    }

    @Test
    public void findByOumCup() {
        Optional<UnitOfMeasure> unit = repository.findByOum("Cup");
        assertEquals("Cup", unit.get().getOum());
    }
}
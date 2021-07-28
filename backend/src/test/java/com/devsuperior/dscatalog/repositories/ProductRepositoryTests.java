package com.devsuperior.dscatalog.repositories;

import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.tests.Factory;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class ProductRepositoryTests {

   private long exintingId;
   private long nonexintingId;
   private long countTotalProducts;

    @BeforeEach
    void setup() throws Exception{

        exintingId = 1L;
        nonexintingId = 1000L;
        countTotalProducts = 25L;
    }

    @Autowired
    private ProductRepository repository ;
    @Test
    public void saveShouldPersistWithAutoincrementWhenIdisNull(){

        Product product = Factory.createProduct();
        product.setId(null);

        product = repository.save(product);

        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals(countTotalProducts + 1, product.getId());
    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists(){



        repository.deleteById(exintingId);

        Optional<Product> result = repository.findById(exintingId);
        Assertions.assertFalse(result.isPresent());
    }
    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist(){


        Assertions.assertThrows(EmptyResultDataAccessException.class, () ->{
            repository.deleteById(nonexintingId);
        });
    }

    @Test
    public void findByIdShouldReturnNonEmptyOptionalWhenIdExists(){
        Optional<Product> result = repository.findById(exintingId);

        Assertions.assertTrue(result.isPresent());

    }

    @Test
    public void findByIdShouldReturnNonEmptyOptionalWhenIdDoesNotExists(){
        Optional<Product> result = repository.findById(nonexintingId);

        Assertions.assertTrue(result.isEmpty());

    }
}

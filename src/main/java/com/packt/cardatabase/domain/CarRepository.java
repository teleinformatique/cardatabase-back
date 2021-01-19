package com.packt.cardatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarRepository extends CrudRepository <Car, Long>{
    
    List<Car> findByBrand(@Param("brand") String brand);

    List<Car> findByColor(@Param("color") String color);

    List<Car> findByYear(@Param("year") String year);

    List<Car> findByBrandAndModel(@Param("brand") String brand, @Param("model") String model);

    @Query("select c from Car c where brand like %?1")
    List<Car> findByBrandEndWith(@Param("brand") String brand);
}

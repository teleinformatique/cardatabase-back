package com.packt.cardatabase;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CarRepositoryTest {
    
    //@Autowired
    //private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void saveCar(){
        
        Car car = new Car("Tesla", "RX3", "White", "TRX1209", 2021, 65000);
        carRepository.save(car);
        assertThat(car.getId()).isNotNull();
    }

    @Test
    public void deleteCars(){
        
        carRepository.save(new Car("Toyata", "Yaris", "Red", "TY001", 2020, 56000));
        carRepository.save(new Car("BMW", "RT8", "Blue", "BTY90", 2020, 67000));
        carRepository.deleteAll();
        assertThat(carRepository.findAll()).isEmpty();
    }
}

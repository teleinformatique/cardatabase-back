package com.packt.cardatabase;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import com.packt.cardatabase.domain.User;
import com.packt.cardatabase.domain.UserRepository;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class CardatabaseApplication {

	private static Logger logger = (Logger) LoggerFactory.getLogger(CardatabaseApplication.class);
	
	@Autowired
	private CarRepository carRepository;

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Hello world");
	}

	@Bean
	CommandLineRunner runner() {
		return args ->{
			Owner khadim = new Owner("Khadim", "Sarr");
			Owner diarra = new Owner("Mame Diarra", "Diop");
			ownerRepository.save(khadim);
			ownerRepository.save(diarra);
			carRepository.save(
				new Car("Ford", "Mustang", "Red", "FR-14", 2017, 59000,khadim)
			);
			carRepository.save(
				new Car("Nissan", "Leaf", "White", "AFR-14", 2014, 59000,khadim)
			);
			carRepository.save(
				new Car("Toyota", "Prius", "Silver", "KK-14", 2018, 59000,diarra)
			);

			userRepository.save(new User("user", "$2y$12$btDUgrfkKssRL2iSziT/vO6BD6nEvGE6YrmsfjdU/UcAX0yO70Bk2", "USER"));
			userRepository.save(new User("admin", "$2y$12$wFK3PkXxJ5RAsijaQB8tEuyIL4pmpY6IqmgDl9bb6rKq6i21/VPS6", "ADMIN"));

		};
	}

}

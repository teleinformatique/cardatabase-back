package com.packt.cardatabase;

import com.packt.cardatabase.web.CarController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class CardatabaseApplicationTests {

	@Autowired
	private CarController carController;
	@Test
	void contextLoads() {
		assertThat(carController).isNotNull();
	}

}

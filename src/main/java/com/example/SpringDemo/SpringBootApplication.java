package com.example.SpringDemo;

import com.example.SpringDemo.Data.CarOwnerRepository;
import com.example.SpringDemo.Data.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.builder.SpringApplicationBuilder;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication implements CommandLineRunner {
	private final CarRepository carRepository;
	private final CarOwnerRepository carOwnerRepository;

	public SpringBootApplication(CarRepository carRepository, CarOwnerRepository carOwnerRepository) {
		this.carRepository = carRepository;
        this.carOwnerRepository = carOwnerRepository;
    }

	private static final Logger logger = LoggerFactory.getLogger(SpringBootApplication.class);

	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.sources(SpringBootApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.run(args);

		logger.info("Application started!");
	}

    @Override
	public void run(String... args) {
		this.carRepository.initializeWithDummyData(this.carOwnerRepository.initializeWithDummyData());
	}
}
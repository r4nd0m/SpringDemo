package com.example.SpringDemo;

import com.example.SpringDemo.data.ApiUser;
import com.example.SpringDemo.data.ApiUserRepository;
import com.example.SpringDemo.data.CarOwnerRepository;
import com.example.SpringDemo.data.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;

import java.util.List;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication implements CommandLineRunner {
	private final CarRepository carRepository;
	private final CarOwnerRepository carOwnerRepository;
	private final ApiUserRepository apiUserRepository;
	private final Environment environment;
	private final SecurityConfig securityConfig;

	public SpringBootApplication(CarRepository carRepository, CarOwnerRepository carOwnerRepository, ApiUserRepository apiUserRepository, Environment environment, SecurityConfig securityConfig) {
		this.carRepository = carRepository;
        this.carOwnerRepository = carOwnerRepository;
        this.apiUserRepository = apiUserRepository;
        this.environment = environment;
        this.securityConfig = securityConfig;
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
		this.apiUserRepository.initializeWithDummyData(
				List.of(
						new ApiUser(
								environment.getProperty("application.settings.user"),
								securityConfig.passwordEncoder().encode(
										environment.getProperty("application.settings.password")
								),
								"USER"
						)
					)
				);
	}
}

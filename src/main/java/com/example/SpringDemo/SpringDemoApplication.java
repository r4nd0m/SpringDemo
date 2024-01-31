package com.example.SpringDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringDemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringDemoApplication.class);

	public static void main(String[] args) {
		new SpringApplicationBuilder()
				.sources(SpringDemoApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.run(args);

		logger.info("Application started!");
	}

}

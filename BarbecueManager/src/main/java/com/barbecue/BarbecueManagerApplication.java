package com.barbecue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BarbecueManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarbecueManagerApplication.class, args);
	}
}

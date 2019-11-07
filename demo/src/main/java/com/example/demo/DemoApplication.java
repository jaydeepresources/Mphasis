package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.posts")
@EntityScan(basePackages = "com.posts")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/posts/signin").allowedOrigins("http://localhost:4200");
                registry.addMapping("/posts/signin").allowCredentials(true);
                
                registry.addMapping("/posts/signup").allowedOrigins("http://localhost:4200");
                registry.addMapping("/posts/signup").allowCredentials(true);
                
                registry.addMapping("/posts/signout").allowedOrigins("http://localhost:4200");
                registry.addMapping("/posts/signout").allowCredentials(true);
            }
        };
	}

}
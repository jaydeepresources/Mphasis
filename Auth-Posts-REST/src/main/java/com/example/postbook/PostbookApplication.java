package com.example.postbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class PostbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostbookApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/signin").allowedOrigins("http://localhost:4200");
				registry.addMapping("/signin").allowCredentials(true);
				
				registry.addMapping("/signup").allowedOrigins("http://localhost:4200");
				registry.addMapping("/signup").allowCredentials(true);
				
//				registry.addMapping("/posts/signout").allowedOrigins("http://localhost:4200");
//				registry.addMapping("/posts/signout").allowCredentials(true);
				
				registry.addMapping("/posts").allowedOrigins("http://localhost:4200");
				registry.addMapping("/posts").allowCredentials(true);

				registry.addMapping("/posts/add").allowedOrigins("http://localhost:4200");
				registry.addMapping("/posts/add").allowCredentials(true);
				
				registry.addMapping("/posts/posts/update").allowedOrigins("http://localhost:4200");
				registry.addMapping("/posts/posts/update").allowCredentials(true);

				registry.addMapping("/posts/delete/*").allowedOrigins("http://localhost:4200");
				registry.addMapping("/posts/delete/*").allowCredentials(true);

//				registry.addMapping("/posts/comments/*").allowedOrigins("http://localhost:4200");
//				registry.addMapping("/posts/comments/*").allowCredentials(true);
//
//				registry.addMapping("/posts/comments/save").allowedOrigins("http://localhost:4200");
//				registry.addMapping("/posts/comments/save").allowCredentials(true);
//
//				registry.addMapping("/posts/comments/edit").allowedOrigins("http://localhost:4200");
//				registry.addMapping("/posts/comments/edit").allowCredentials(true);
//
//				registry.addMapping("/posts/comments/delete/*").allowedOrigins("http://localhost:4200");
//				registry.addMapping("/posts/comments/delete/*").allowCredentials(true);
			}
		};
	}

}
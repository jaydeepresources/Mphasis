package com.nested;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class NestedApplication {

	public static void main(String[] args) {
		SpringApplication.run(NestedApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/postbook/signin").allowedOrigins("http://localhost:4200");
				registry.addMapping("/postbook/signin").allowCredentials(true);
				
				registry.addMapping("/postbook/signup").allowedOrigins("http://localhost:4200");
				registry.addMapping("/postbook/signup").allowCredentials(true);
				
				registry.addMapping("/postbook/signout").allowedOrigins("http://localhost:4200");
				registry.addMapping("/postbook/signout").allowCredentials(true);
				
				registry.addMapping("/postbook/users/all").allowedOrigins("http://localhost:4200");
				registry.addMapping("/postbook/users/all").allowCredentials(true);
				
				registry.addMapping("/postbook/posts/all").allowedOrigins("http://localhost:4200");
				registry.addMapping("/postbook/posts/all").allowCredentials(true);

				registry.addMapping("/postbook/posts/save").allowedOrigins("http://localhost:4200");
				registry.addMapping("/postbook/posts/save").allowCredentials(true);
				
				registry.addMapping("/postbook/posts/edit").allowedOrigins("http://localhost:4200");
				registry.addMapping("/postbook/posts/edit").allowCredentials(true);

				registry.addMapping("/postbook/posts/delete/*").allowedOrigins("http://localhost:4200");
				registry.addMapping("/postbook/posts/delete/*").allowCredentials(true);

				registry.addMapping("/postbook/comments/*").allowedOrigins("http://localhost:4200");
				registry.addMapping("/postbook/comments/*").allowCredentials(true);

				registry.addMapping("/postbook/comments/save").allowedOrigins("http://localhost:4200");
				registry.addMapping("/postbook/comments/save").allowCredentials(true);

				registry.addMapping("/postbook/comments/edit").allowedOrigins("http://localhost:4200");
				registry.addMapping("/postbook/comments/edit").allowCredentials(true);

				registry.addMapping("/postbook/comments/delete/*").allowedOrigins("http://localhost:4200");
				registry.addMapping("/postbook/comments/delete/*").allowCredentials(true);
			}
		};
	}
}

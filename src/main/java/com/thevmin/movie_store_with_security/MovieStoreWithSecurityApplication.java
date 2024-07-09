package com.thevmin.movie_store_with_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
public class MovieStoreWithSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieStoreWithSecurityApplication.class, args);
	}

}

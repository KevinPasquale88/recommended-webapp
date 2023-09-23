package it.sysagent.recommended.recommendedwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RecommendedWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecommendedWebappApplication.class, args);
	}

}

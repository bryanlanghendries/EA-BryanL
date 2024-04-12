package com.bryanlanghendries.enterpriseapplicationsexamen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.bryanlanghendries")
@EntityScan("com.bryanlanghendries.repository.entities")
@PropertySource(value = "classpath:application.properties")
@ComponentScan("com.bryanlanghendries")
@EnableJpaRepositories("com.bryanlanghendries.repository")
public class EnterpriseApplicationsExamenApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnterpriseApplicationsExamenApplication.class, args);
	}

}

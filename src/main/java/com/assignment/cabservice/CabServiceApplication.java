package com.assignment.cabservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*insert into users (id,password,role,username) values (1,"$2a$12$q6uEwAQbTEat0.7VeRC8hOsFZCle66hRDHcYEyYQiBD1Oq8Ry5zwe","ADMIN","admin");
        insert into users (id,password,role,username) values (2,"$2a$12$iJOC0gB0HKAtHq6u93/HAOgWzcR5uudmg/8j5JeAamylycr/UxA7G" ,"USER","cust1");
        insert into users (id,password,role,username) values (3,"$2a$12$WWwVoIGPrIt7/KkEeb2os.ytO9LQdazZVXvNvDVXeSPj.5jzkork2","USER","cust2");*/
@SpringBootApplication
public class CabServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabServiceApplication.class, args);
	}

}

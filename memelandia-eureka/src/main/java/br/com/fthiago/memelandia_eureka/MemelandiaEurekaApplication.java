package br.com.fthiago.memelandia_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MemelandiaEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemelandiaEurekaApplication.class, args);
	}

}

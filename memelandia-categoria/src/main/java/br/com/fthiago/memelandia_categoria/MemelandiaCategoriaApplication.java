package br.com.fthiago.memelandia_categoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MemelandiaCategoriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemelandiaCategoriaApplication.class, args);
	}

}

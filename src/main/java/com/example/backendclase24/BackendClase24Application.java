package com.example.backendclase24;

import com.example.backendclase24.bd.BD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendClase24Application {

	public static void main(String[] args) throws Exception {
		BD.crearTablas();
		SpringApplication.run(BackendClase24Application.class, args);
	}

}

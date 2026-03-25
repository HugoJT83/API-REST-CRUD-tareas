package com.practica.crud_apirest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CrudApirestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudApirestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Aplicación iniciada correctamente");

		//crea una lista y obtiene las tareas del repositorio
		/* List<Tarea> tareas = repositorio_tareas.findAll();
		tareas.stream().forEach(tarea -> System.out.println(tarea)); */
	}

}

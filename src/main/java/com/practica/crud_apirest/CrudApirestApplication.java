package com.practica.crud_apirest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practica.crud_apirest.entity.Tarea;
import com.practica.crud_apirest.repository.Repo_Tareas;

@SpringBootApplication
public class CrudApirestApplication implements CommandLineRunner {

	@Autowired
	private Repo_Tareas repositorio_tareas;

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

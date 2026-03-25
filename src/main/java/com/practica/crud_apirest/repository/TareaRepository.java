package com.practica.crud_apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.crud_apirest.entity.Tarea;

public interface TareaRepository extends JpaRepository<Tarea,Long>{



}

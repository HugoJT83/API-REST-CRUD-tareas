package com.practica.crud_apirest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.crud_apirest.dto.TareaDTO;
import com.practica.crud_apirest.entity.Tarea;
import com.practica.crud_apirest.mapper.TareaMapper;
import com.practica.crud_apirest.repository.Repo_Tareas;
import com.practica.crud_apirest.service.TareaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService servicio_tarea;

    @GetMapping
    public List<TareaDTO> Listar(){

        return servicio_tarea.Consulta();
    }
    

}

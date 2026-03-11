package com.practica.crud_apirest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.crud_apirest.dto.TareaDTO;
import com.practica.crud_apirest.entity.Tarea;
import com.practica.crud_apirest.mapper.TareaMapper;
import com.practica.crud_apirest.repository.Repo_Tareas;
import com.practica.crud_apirest.service.TareaService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService servicio_tarea;

    @GetMapping
    public List<TareaDTO> Listar(){

        return servicio_tarea.service_ConsultaTareas();
    }

    @GetMapping("/{id_tarea}")
    public TareaDTO buscarTarea(@Valid @PathVariable Long id_tarea) {
        return servicio_tarea.service_buscaTarea(id_tarea);
    }
    

    @PostMapping
    public TareaDTO insertarTarea(@RequestBody TareaDTO dto) {
        
        return servicio_tarea.service_InsertaTarea(dto);
    }

    @PutMapping("/{id_tarea}")
    public TareaDTO actualizarTarea(@PathVariable Long id_tarea, @RequestBody TareaDTO dto) {
        
        return servicio_tarea.service_actualizaTarea(id_tarea, dto);
    }

    @DeleteMapping("/{id_tarea}")
    public String borrarTarea(@PathVariable Long id_tarea){

        return servicio_tarea.service_eliminaTarea(id_tarea);
    }

    @PatchMapping("/{id_tarea}/{campo}")
    public TareaDTO actualizarCampoTarea(@PathVariable Long id_tarea, @PathVariable String campo, @RequestBody String nuevoValor) {

        String valorLimpio = nuevoValor.replace("\"", "");
        return servicio_tarea.service_actualizaCampoTarea(id_tarea,campo,valorLimpio);
    }   
    
    

}

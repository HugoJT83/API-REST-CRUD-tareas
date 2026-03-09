package com.practica.crud_apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.practica.crud_apirest.service.TareaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @Autowired
    private TareaService servicio_tarea;

    @GetMapping("/")
    public String Listado(Model model) {
        model.addAttribute("tareas",servicio_tarea.service_ConsultaTareas());
        return "inicio";
    }
    
}

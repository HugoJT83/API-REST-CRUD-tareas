package com.practica.crud_apirest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.crud_apirest.dto.TareaDTO;
import com.practica.crud_apirest.mapper.TareaMapper;
import com.practica.crud_apirest.repository.Repo_Tareas;

@Service
public class TareaService {

    @Autowired
    private Repo_Tareas repo;

    public List<TareaDTO> Consulta(){

        return repo.findAll().stream().map(TareaMapper::toDTO)
                .collect(Collectors.toList());
    }

}

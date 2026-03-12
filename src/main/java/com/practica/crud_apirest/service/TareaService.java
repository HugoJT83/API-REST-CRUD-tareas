package com.practica.crud_apirest.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.text.html.parser.Entity;

import org.hibernate.type.descriptor.java.LocalDateTimeJavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.crud_apirest.dto.TareaDTO;
import com.practica.crud_apirest.entity.Estado;
import com.practica.crud_apirest.entity.Tarea;
import com.practica.crud_apirest.exceptions.TareaErrores;
import com.practica.crud_apirest.mapper.TareaMapper;
import com.practica.crud_apirest.repository.Repo_Tareas;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TareaService {

    @Autowired
    private Repo_Tareas repo;

    public List<TareaDTO> service_ConsultaTareas(){

        return repo.findAll().stream().map(TareaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TareaDTO service_buscaTarea(Long id_tarea){
        Optional<Tarea> existe = repo.findById(id_tarea);

        if(existe.isPresent()){
            Tarea tarea = existe.get();
            return TareaMapper.toDTO(tarea);
        }
        else{
            throw new EntityNotFoundException("Tarea no encontrada con id: "+ id_tarea);
        }
    }

    public TareaDTO service_InsertaTarea(TareaDTO dto){
        //Convertimos a Entidad
        Tarea tarea = TareaMapper.toEntity(dto);
        tarea.setUltima_mod(LocalDateTime.now());

        //insercion a BD (insert y si existe update)
        Tarea insercion = repo.save(tarea);
        return TareaMapper.toDTO(insercion);
    }

    public TareaDTO service_actualizaTarea(Long id_tarea, TareaDTO dto){
        Optional<Tarea> existe = repo.findById(id_tarea);
        
        if(existe.isPresent()){
            Tarea tarea = existe.get();

            tarea.setTitulo(dto.getTitulo());
            tarea.setDescripcion(dto.getDescripcion());
            tarea.setEstado(dto.getEstado());
            tarea.setFecha_fin(dto.getFecha_fin());
            tarea.setUltima_mod(LocalDateTime.now());

            Tarea actualizado = repo.save(tarea);

            return TareaMapper.toDTO(actualizado);
        }
        else{
            throw new RuntimeException("Tarea no encontrada con id:"+id_tarea);
        }
    }

    public String service_eliminaTarea (Long id_tarea){
        if(repo.existsById(id_tarea)){
            repo.deleteById(id_tarea);
            return "Tarea borrada correctamente";
        }
        else{
            return "Tarea: "+id_tarea+" no encontrada";
        }
    }

    public TareaDTO service_actualizaCampoTarea(Long id_tarea, String campo, String valor) {
        
        Optional<Tarea> existe = repo.findById(id_tarea);

        if(existe.isPresent()){

            Tarea tarea = existe.get();

            switch (campo) {
                case "titulo":
                    tarea.setTitulo(valor);
                    break;
                case "descripcion":
                    tarea.setDescripcion(valor);
                    break;
                case "estado":
                    tarea.setEstado(Estado.valueOf(valor.toUpperCase()));
                    break;
                case "fecha_fin":
                    tarea.setFecha_fin(LocalDateTime.parse(valor));
                    break;
            }

            tarea.setUltima_mod(LocalDateTime.now());
            Tarea actualizado = repo.save(tarea);
            return TareaMapper.toDTO(actualizado);
        }
        else{
            throw new RuntimeException("Tarea no encontrada con id:"+id_tarea);
        }
    }
}

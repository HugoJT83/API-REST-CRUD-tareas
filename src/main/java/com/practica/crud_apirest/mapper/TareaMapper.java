package com.practica.crud_apirest.mapper;

import com.practica.crud_apirest.dto.TareaDTO;
import com.practica.crud_apirest.entity.Tarea;

public class TareaMapper {

    public static TareaDTO toDTO(Tarea tarea){
        return new TareaDTO(
                tarea.getIdTarea(),
                tarea.getTitulo(),
                tarea.getDescripcion(),
                tarea.getEstado(),
                tarea.getFechaCreacion(),
                tarea.getFechaFin(),
                tarea.getUltimaMod()
        );        
    };

    public static Tarea toEntity(TareaDTO dto){

        Tarea tarea = new Tarea();
        tarea.setIdTarea(dto.getIdTarea());
        tarea.setTitulo(dto.getTitulo());
        tarea.setDescripcion(dto.getDescripcion());
        tarea.setEstado(dto.getEstado());
        tarea.setFechaCreacion(dto.getFechaCreacion());
        tarea.setFechaFin(dto.getFechaFin());
        tarea.setUltimaMod(dto.getUltimaMod());
        return tarea;
    }
}

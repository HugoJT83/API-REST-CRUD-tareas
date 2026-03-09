package com.practica.crud_apirest.mapper;

import com.practica.crud_apirest.dto.TareaDTO;
import com.practica.crud_apirest.entity.Tarea;

public class TareaMapper {

    public static TareaDTO toDTO(Tarea tarea){
        return new TareaDTO(
                tarea.getId_tarea(),
                tarea.getTitulo(),
                tarea.getDescripcion(),
                tarea.getEstado(),
                tarea.getFecha_creacion(),
                tarea.getFecha_fin(),
                tarea.getUltima_mod()
        );        
    };

    public static Tarea toEntity(TareaDTO dto){

        Tarea tarea = new Tarea();
        tarea.setId_tarea(dto.getId_tarea());
        tarea.setTitulo(dto.getTitulo());
        tarea.setDescripcion(dto.getDescripcion());
        tarea.setEstado(dto.getEstado());
        tarea.setFecha_creacion(dto.getFecha_creacion());
        tarea.setFecha_fin(dto.getFecha_fin());
        tarea.setUltima_mod(dto.getUltima_mod());
        return tarea;
    }
}

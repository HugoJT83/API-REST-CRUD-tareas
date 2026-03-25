package com.practica.crud_apirest.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.practica.crud_apirest.dto.TareaDTO;
import com.practica.crud_apirest.entity.Estado;
import com.practica.crud_apirest.entity.Tarea;
import com.practica.crud_apirest.mapper.TareaMapper;
import com.practica.crud_apirest.repository.TareaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TareaService {

    @Autowired
    private TareaRepository repo;

    public List<TareaDTO> serviceListTareas(){

        return repo.findAll().stream().map(TareaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TareaDTO serviceGetTarea(Long idTarea){
        Optional<Tarea> existe = repo.findById(idTarea);

        if(existe.isPresent()){
            Tarea tarea = existe.get();
            return TareaMapper.toDTO(tarea);
        }
        else{
            throw new EntityNotFoundException("Tarea no encontrada con id: "+ idTarea);
        }
    }

    public TareaDTO serviceAddTarea(TareaDTO dto){
        //Convertimos a Entidad
        Tarea tarea = TareaMapper.toEntity(dto);
        tarea.setUltimaMod(LocalDateTime.now());

        //insercion a BD (insert y si existe update)
        Tarea insercion = repo.save(tarea);
        return TareaMapper.toDTO(insercion);
    }

    public TareaDTO serviceUpdateTarea(Long idTarea, TareaDTO dto){
        Optional<Tarea> existe = repo.findById(idTarea);
        
        if(existe.isPresent()){
            Tarea tarea = existe.get();

            tarea.setTitulo(dto.getTitulo());
            tarea.setDescripcion(dto.getDescripcion());
            tarea.setEstado(dto.getEstado());
            tarea.setFechaFin(dto.getFechaFin());
            tarea.setUltimaMod(LocalDateTime.now());

            Tarea actualizado = repo.save(tarea);

            return TareaMapper.toDTO(actualizado);
        }
        else{
            throw new RuntimeException("Tarea no encontrada con id:"+idTarea);
        }
    }

    public String serviceDeleteTarea (Long idTarea){
        if(repo.existsById(idTarea)){
            repo.deleteById(idTarea);
            return "Tarea borrada correctamente";
        }
        else{
            return "Tarea: "+idTarea+" no encontrada";
        }
    }

    public TareaDTO serviceUpdateFieldTarea(Long idTarea, String campo, String valor) {
        
        Optional<Tarea> existe = repo.findById(idTarea);

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
                    tarea.setFechaFin(LocalDateTime.parse(valor));
                    break;
            }

            tarea.setUltimaMod(LocalDateTime.now());
            Tarea actualizado = repo.save(tarea);
            return TareaMapper.toDTO(actualizado);
        }
        else{
            throw new RuntimeException("Tarea no encontrada con id:"+idTarea);
        }
    }
}

package com.practica.crud_apirest.dto;

import java.time.LocalDateTime;

import com.practica.crud_apirest.entity.Estado;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TareaDTO {


    private Long idTarea;

    @NotBlank(message = "el titulo es obligatorio")
    @Size(min = 5, message = "el titulo tiene que tener más de 5 caracteres")
    @Size(max = 45, message = "el titulo no puede tener más de 45 caracteres")
    private String titulo;

    @NotBlank(message = "la descripcion es obligatoria")
    @Size(min = 5,max = 200, message = "la descripcion no puede tener más de 200 caracteres")
    private String descripcion;

    @NotNull(message = "el estado es obligatorio")
    private Estado estado;

    @FutureOrPresent(message = "la fecha tiene que ser de hoy en adelante.")
    private LocalDateTime fechaCreacion;

    @FutureOrPresent(message = "la fecha tiene que ser de hoy en adelante.")
    private LocalDateTime fechaFin;

    @FutureOrPresent(message = "la fecha tiene que ser de hoy en adelante.")
    private LocalDateTime ultimaMod;
    
}

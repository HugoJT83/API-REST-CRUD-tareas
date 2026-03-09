package com.practica.crud_apirest.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tareas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tarea")
    private Long id_tarea;

    @Column(name="titulo")
    private String titulo;

    @Column(name="descripcion")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;

    @Column(name = "fecha_creacion")
    private LocalDateTime fecha_creacion;

    @Column(name = "fecha_fin")
    private LocalDateTime fecha_fin;

    @Column(name = "ultima_mod")
    private LocalDateTime ultima_mod;
    
    @Override
    public String toString(){
        return "Tarea{"+
            "id: " + this.id_tarea +
            ", titulo: "+ this.titulo +
            ", descripcion: "+ this.descripcion +
            ", estado: "+ this.estado +
            ", fecha_creacion: "+this.fecha_creacion +
            ", fecha_fin: " + this.fecha_fin +
            ", ultima_mod: " + this.ultima_mod +
            "}";
    }; 
    
}





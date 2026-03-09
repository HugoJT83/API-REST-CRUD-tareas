package com.practica.crud_apirest.dto;

import java.time.LocalDateTime;

import com.practica.crud_apirest.entity.Estado;

public class TareaDTO {
    private Long id_tarea;
    private String titulo;
    private String descripcion;
    private Estado estado;
    private LocalDateTime fecha_creacion;
    private LocalDateTime fecha_fin;
    private LocalDateTime ultima_mod;


    public TareaDTO(Long id_tarea, String titulo, String descripcion, Estado estado, LocalDateTime fecha_creacion,
            LocalDateTime fecha_fin, LocalDateTime ultima_mod) {
        this.id_tarea = id_tarea;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecha_creacion = fecha_creacion;
        this.fecha_fin = fecha_fin;
        this.ultima_mod = ultima_mod;
    }


    public Long getId_tarea() {
        return id_tarea;
    }


    public void setId_tarea(Long id_tarea) {
        this.id_tarea = id_tarea;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Estado getEstado() {
        return estado;
    }


    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }


    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }


    public LocalDateTime getFecha_fin() {
        return fecha_fin;
    }


    public void setFecha_fin(LocalDateTime fecha_fin) {
        this.fecha_fin = fecha_fin;
    }


    public LocalDateTime getUltima_mod() {
        return ultima_mod;
    }


    public void setUltima_mod(LocalDateTime ultima_mod) {
        this.ultima_mod = ultima_mod;
    }


    @Override
    public String toString() {
        return "TareaDTO [id_tarea=" + id_tarea + ", titulo=" + titulo + ", descripcion=" + descripcion + ", estado="
                + estado + ", fecha_creacion=" + fecha_creacion + ", fecha_fin=" + fecha_fin + ", ultima_mod="
                + ultima_mod + "]";
    }
    
    
    
}

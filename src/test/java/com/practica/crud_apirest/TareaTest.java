package com.practica.crud_apirest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.practica.crud_apirest.dto.TareaDTO;
import com.practica.crud_apirest.entity.Estado;
import com.practica.crud_apirest.entity.Tarea;
import com.practica.crud_apirest.repository.TareaRepository;
import com.practica.crud_apirest.service.TareaService;

import jakarta.persistence.EntityNotFoundException;

@ExtendWith(MockitoExtension.class)
public class TareaTest {

    @Mock
    private TareaRepository tareaRepo;

    @InjectMocks
    private TareaService tareaService;

    private TareaDTO tareaDTO;
    
    private Tarea tareaEntidad;

    @BeforeEach
    void setUp(){

        tareaEntidad = new Tarea();
        tareaEntidad.setIdTarea(1L);
        tareaEntidad.setTitulo("titulo");
        tareaEntidad.setDescripcion("Test unitario");
        tareaEntidad.setEstado(Estado.POR_HACER);
        tareaEntidad.setFechaCreacion(LocalDateTime.now());
        tareaEntidad.setFechaFin(LocalDateTime.now());
        tareaEntidad.setUltimaMod(LocalDateTime.now());

        tareaDTO = new TareaDTO();;
        tareaDTO.setIdTarea(1L);
        tareaDTO.setTitulo("titulo");
        tareaDTO.setDescripcion("Test unitario");
        tareaDTO.setEstado(Estado.POR_HACER);
        tareaDTO.setFechaCreacion(LocalDateTime.now());
        tareaDTO.setFechaFin(LocalDateTime.now());
        tareaDTO.setUltimaMod(LocalDateTime.now());
    }
    

    //eliminar tareas

    //actualizar un campo de una tarea

    //Consulta Tareas (todas)
    @Test 
    void consulta_devuelveLista() {
        List<Tarea> listaEntidades = List.of(tareaEntidad);
        Mockito.when(tareaRepo.findAll()).thenReturn(listaEntidades);

        List<TareaDTO> resultado = tareaService.serviceListTareas();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("titulo", resultado.get(0).getTitulo());
        Mockito.verify(tareaRepo, Mockito.times(1)).findAll();

    }

    //buscar por id (caso exito)
    @Test
    void buscaTarea_devuelveTareaDTO(){
        Mockito.when(tareaRepo.findById(1L)).thenReturn(Optional.of(tareaEntidad));

        TareaDTO resultado = tareaService.serviceGetTarea(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getIdTarea());
        assertEquals("titulo", resultado.getTitulo());

    }

    //buscar por id (caso error)
    @Test
    void buscaTarea_noExiste_devuelveExcepcion(){
        Mockito.when(tareaRepo.findById(99L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, ()->{
            tareaService.serviceGetTarea(99L);
        });

        Mockito.verify(tareaRepo).findById(99L);
    }

    //----


    //inserta tarea
    @Test
    void insertaTarea_guardaCorrectamente(){

        Mockito.when(tareaRepo.save(Mockito.any(Tarea.class))).thenReturn(tareaEntidad);

        TareaDTO resultado = tareaService.serviceAddTarea(tareaDTO);
        assertNotNull(resultado);
        assertEquals(1L, resultado.getIdTarea());
        Mockito.verify(tareaRepo,Mockito.times(1)).save(Mockito.any(Tarea.class));
    }

    //actualiza tarea (campo "estado")
    @Test
    void actualizaCampoTarea_campoEstado(){

        Mockito.when(tareaRepo.findById(1L)).thenReturn(Optional.of(tareaEntidad));
        Mockito.when(tareaRepo.save(Mockito.any(Tarea.class))).thenAnswer(i -> {
            return (Tarea) i.getArguments()[0];
        });


        TareaDTO resultado = tareaService.serviceUpdateFieldTarea(1L,"estado","HECHO");
        
        assertEquals(Estado.HECHO, resultado.getEstado());
        Mockito.verify(tareaRepo).save(tareaEntidad);
    }

    //borra tarea (exito)
    @Test
    void borraTarea_devuelveMensajeExito(){

        Mockito.when(tareaRepo.existsById(1L)).thenReturn(true);
        Mockito.doNothing().when(tareaRepo).deleteById(1L);

        String resultado = tareaService.serviceDeleteTarea(1L);

        assertEquals("Tarea borrada correctamente", resultado);
        Mockito.verify(tareaRepo, Mockito.times(1)).existsById(1L);
        Mockito.verify(tareaRepo, Mockito.times(1)).deleteById(1L);
    }

    //borra tarea (error)
    @Test
    void borraTarea_casoError(){

        Long idInexistente = 99L;
        Mockito.when(tareaRepo.existsById(idInexistente)).thenReturn(false);

        String resultado = tareaService.serviceDeleteTarea(idInexistente);

        assertEquals("Tarea: 99 no encontrada", resultado);

        Mockito.verify(tareaRepo, Mockito.never()).deleteById(anyLong());

    }


}

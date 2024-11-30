/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Crud.CrudSpringboot.Servicio;
import com.Crud.CrudSpringboot.Modelo.Estudiante;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
/**
 *
 * @author arman
 */
public class EstudianteServicio {
    
    private List<Estudiante> estudiantes = new ArrayList<>();
    private Long nextId =  1L;
    
    public List<Estudiante> getEstudiantes(){
        return estudiantes;
    }
    
    public Optional<Estudiante> getEstudianteById(Long id){
        return estudiantes.stream().filter(estudiante -> estudiante.getId().equals(id)).findFirst();
    }
    
    public Estudiante createEstudiante(Estudiante estudiante){
        estudiante.setId(nextId++);
        estudiantes.add(estudiante);
        return estudiante;
    }
    
    public Optional<Estudiante> updateEstudiante(Long id, Estudiante estudianteDetalls){
        return getEstudianteById(id).map(estudiante ->{
            estudiante.setNombre(estudianteDetalls.getNombre());
            estudiante.setSemestre(estudianteDetalls.getSemestre());
            return estudiante;
        });
    }
    
    public boolean eliminarEstudiante(Long id){
        return estudiantes.removeIf(estudiante -> estudiante.getId().equals(id));
    
    }
    
}

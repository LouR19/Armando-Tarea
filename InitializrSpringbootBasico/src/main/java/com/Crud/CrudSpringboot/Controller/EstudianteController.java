/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Crud.CrudSpringboot.Controller;
import com.Crud.CrudSpringboot.Modelo.Estudiante;
import com.Crud.CrudSpringboot.Servicio.EstudianteServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.ok;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.servlet.function.ServerResponse.ok;

@RequestMapping("/api/estudiante")
@RestController
/**
 *
 * @author arman
 */
public class EstudianteController {
    
    private final EstudianteServicio estudianteServicio;
    
    @Autowired
    public EstudianteController(EstudianteServicio estudianteServicio){
        this.estudianteServicio = estudianteServicio;
    }
    
    @GetMapping
    public List<Estudiante> getAllEstudiantes(){
        return estudianteServicio.getEstudiantes();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getEstudianteById(@PathVariable Long id){
        Optional<Estudiante> estudiante = estudianteServicio.getEstudianteById(id);
        return estudiante.map(ResponseEntity : : ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Estudiante createEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteServicio.createEstudiante(estudiante);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable Long id, @RequestBody Estudiante estudianteDetalls){
        Optional<Estudiante> estudiante = estudianteServicio.updateEstudiante(id, estudianteDetalls);
        return estudiante.map(ResponseEntity : : ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Long id){
        if(estudianteServicio.eliminarEstudiante(id)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudjava;
import java.io.Serializable;
/**
 *
 * @author arman
 */
public class Persona extends Estudiante implements Evaluable, Serializable{
    
    Float nota;
    public Persona(String nombre, String Apellido, float nota) {
        super(nombre, Apellido);
        this.nota = nota;
    }

        @Override
        public String toString() {
            return "Nombre: " + Nombre + "\nApellido:"+Apellido+ "\nNota: " + nota+"\n------------";
        }
        @Override
    public boolean esAprobado() {
        return this.nota >= 10;
    }
    
}

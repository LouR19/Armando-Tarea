/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crudjava;
/**
 *
 * @author arman
 */
public class CrudJava {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Funciones.cargarDatos();
        while (true){
            System.out.println("--MENU-- \n1.Guardar\n2.Mostrar\n3.Eliminar\n4.Actualizar\n5.Buscar\n6.Reporte\n7.Salir");
            int r = 0;
            r=ValidacionTry.Opciones(r);
            switch (r){
                case 1 -> Funciones.agregar();
                case 2 -> Funciones.mostrar();
                case 3 -> Funciones.eliminar();
                case 4 -> Funciones.actualizar();
                case 5 -> Funciones.buscar();
                case 6 -> Funciones.generarReporte();
                case 7 -> {
                    
                    Funciones.guardarDatos();
                    return;
                }
                    
                default -> {
                    System.out.println("Ingrese una opcion que este en el menu");
                    Funciones.pausar();
                }
            }
        }
    }
    
}

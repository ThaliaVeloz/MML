/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import encabezado_proyecto.clases.Proyecto;
import encabezado_proyecto.funciones.FProyecto;
import java.util.ArrayList;

/**
 *
 * @author WinUser
 */
public class TestProyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            ArrayList<Proyecto> proyectolist = FProyecto.obtenerProyectoDadoCodigoUsuario(2455);
            System.out.println("Total "+proyectolist.size());
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
    
}

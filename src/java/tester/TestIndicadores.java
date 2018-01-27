/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import encabezado_proyecto.clases.Indicadores_proposito;
import encabezado_proyecto.funciones.FIndicadores_proposito;
import java.util.ArrayList;

/**
 *
 * @author WinUser
 */
public class TestIndicadores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            ArrayList<Indicadores_proposito> lst = FIndicadores_proposito.obtenerIndicadorDadoCodigoProposito(1);
            System.out.println("Total "+lst.size());
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
    }
    
}

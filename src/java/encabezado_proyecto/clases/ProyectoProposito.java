/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encabezado_proyecto.clases;

/**
 *
 * @author WinUser
 */
public class ProyectoProposito {

    private Proyecto proyecto;
    private Proposito proposito;

    public ProyectoProposito() {
        proyecto = new Proyecto();
        proposito = new Proposito();

    }

    /**
     * @return the proyecto
     */
    public Proyecto getProyecto() {
        return proyecto;
    }

    /**
     * @param proyecto the proyecto to set
     */
    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    /**
     * @return the proposito
     */
    public Proposito getProposito() {
        return proposito;
    }

    /**
     * @param proposito the proposito to set
     */
    public void setProposito(Proposito proposito) {
        this.proposito = proposito;
    }

}

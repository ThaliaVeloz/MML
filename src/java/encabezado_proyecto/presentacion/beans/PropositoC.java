/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encabezado_proyecto.presentacion.beans;

import encabezado_proyecto.clases.Proposito;
import encabezado_proyecto.funciones.FProposito;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

@ManagedBean
@ViewScoped
public class PropositoC implements Serializable {

    private ArrayList<Proposito> propositolist;
    private Proposito propositoSel;
    private Proposito proposito;

    public PropositoC() {
        propositoSel = new Proposito();
        proposito = new Proposito();
        cargarProposito();

    }

    public void cargarProposito() {
        try {

        //    setPropositolist(FProposito.obtenerPropositoDadoCodigoProyecto(0));

        } catch (Exception e) {
            System.out.println("public void cargarProyecto() dice: " + e.getMessage());
        }
    }

    public void ingresarProposito() {
        try {

            String respuesta = FProposito.ingresarProposito(proposito);
            Util.addSuccessMessage(respuesta);
            cargarProposito();
            // resetearFitrosTabla("frmAcciones:tblAcciones");
            proposito = new Proposito();
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgRegistrar').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void registrar() dice: " + e.getMessage());
        }
    }

    public void actualizarProposito() {
        try {
            String respuesta = FProposito.actualizarProposito(propositoSel);
            Util.addSuccessMessage(respuesta);
            cargarProposito();
            //resetearFitrosTabla("frmAcciones:tblAcciones");
            propositoSel = new Proposito();
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgActualizar').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void actualizar() dice: " + e.getMessage());
        }
    }

    public void eliminarProposito() {
        try {
            String respuesta = FProposito.eliminarProposito(propositoSel);
            Util.addSuccessMessage(respuesta);
            cargarProposito();
            // resetearFitrosTabla("frmAcciones:tblAcciones");
            propositoSel = new Proposito();
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEliminar').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void eliminar() dice: " + e.getMessage());
        }
    }

    /**
     * @return the propositolist
     */
    public ArrayList<Proposito> getPropositolist() {
        return propositolist;
    }

    /**
     * @param propositolist the propositolist to set
     */
    public void setPropositolist(ArrayList<Proposito> propositolist) {
        this.propositolist = propositolist;
    }

    /**
     * @return the propositoSel
     */
    public Proposito getPropositoSel() {
        return propositoSel;
    }

    /**
     * @param propositoSel the propositoSel to set
     */
    public void setPropositoSel(Proposito propositoSel) {
        this.propositoSel = propositoSel;
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

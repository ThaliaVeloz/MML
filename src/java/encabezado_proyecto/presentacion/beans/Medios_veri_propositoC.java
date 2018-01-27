/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encabezado_proyecto.presentacion.beans;

import encabezado_proyecto.clases.Medios_veri_proposito;
import encabezado_proyecto.funciones.FMedios_veri_proposito;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

@ManagedBean
@ViewScoped
public class Medios_veri_propositoC implements Serializable {

    private ArrayList<Medios_veri_proposito> medpropositolist;
    private Medios_veri_proposito medpropositoSel;
    private Medios_veri_proposito medproposito;

    public Medios_veri_propositoC() {
        medpropositoSel = new Medios_veri_proposito();
        medproposito = new Medios_veri_proposito();
        cargarMedios_veri_proposito();

    }

    public void cargarMedios_veri_proposito() {
        try {

            setMedpropositolist(FMedios_veri_proposito.obtenerMediosDadoCodigoIndicadorProp(0));

        } catch (Exception e) {
            System.out.println("public void cargarProyecto() dice: " + e.getMessage());
        }
    }

    public void ingresarMedios_veri_proposito() {
        try {

            String respuesta = FMedios_veri_proposito.ingresarMedios_veri_proposito(medproposito);
            Util.addSuccessMessage(respuesta);
            cargarMedios_veri_proposito();
            // resetearFitrosTabla("frmAcciones:tblAcciones");
            medproposito = new Medios_veri_proposito();
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgRegistrar').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void registrar() dice: " + e.getMessage());
        }
    }

    public void actualizarMedios_veri_proposito() {
        try {
            String respuesta = FMedios_veri_proposito.actualizarMedios_veri_proposito(medpropositoSel);
            Util.addSuccessMessage(respuesta);
            cargarMedios_veri_proposito();
            //resetearFitrosTabla("frmAcciones:tblAcciones");
            medpropositoSel = new Medios_veri_proposito();
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgActualizar').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void actualizar() dice: " + e.getMessage());
        }
    }

    public void eliminarMedios_veri_proposito() {
        try {
            String respuesta = FMedios_veri_proposito.eliminarMedios_veri_proposito(medpropositoSel);
            Util.addSuccessMessage(respuesta);
            cargarMedios_veri_proposito();
            // resetearFitrosTabla("frmAcciones:tblAcciones");
            medpropositoSel = new Medios_veri_proposito();
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEliminar').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void eliminar() dice: " + e.getMessage());
        }
    }

    /**
     * @return the medpropositolist
     */
    public ArrayList<Medios_veri_proposito> getMedpropositolist() {
        return medpropositolist;
    }

    /**
     * @param medpropositolist the medpropositolist to set
     */
    public void setMedpropositolist(ArrayList<Medios_veri_proposito> medpropositolist) {
        this.medpropositolist = medpropositolist;
    }

    /**
     * @return the medpropositoSel
     */
    public Medios_veri_proposito getMedpropositoSel() {
        return medpropositoSel;
    }

    /**
     * @param medpropositoSel the medpropositoSel to set
     */
    public void setMedpropositoSel(Medios_veri_proposito medpropositoSel) {
        this.medpropositoSel = medpropositoSel;
    }

    /**
     * @return the medproposito
     */
    public Medios_veri_proposito getMedproposito() {
        return medproposito;
    }

    /**
     * @param medproposito the medproposito to set
     */
    public void setMedproposito(Medios_veri_proposito medproposito) {
        this.medproposito = medproposito;
    }

}

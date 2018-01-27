/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes_proyecto.presentacion.beans;

import componentes_proyecto.clases.Medios_veri_componentes;
import componentes_proyecto.funciones.FMedios_veri_componentes;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;
@ManagedBean
@ViewScoped
public class Medios_veri_componentesC implements Serializable{
    private ArrayList<Medios_veri_componentes> medcomponentelist;
    private Medios_veri_componentes medcomponenteSel;
    private Medios_veri_componentes medcomponente;

    public Medios_veri_componentesC() {
        medcomponenteSel = new Medios_veri_componentes();
        medcomponente = new Medios_veri_componentes();
        cargarMedios_veri_componentes();

    }

    public void cargarMedios_veri_componentes() {
        try {           
            setMedcomponentelist(FMedios_veri_componentes.obtenerMediosDadoCodigoIndicadorCompo(0));

        } catch (Exception e) {
            System.out.println("public void cargarProyecto() dice: " + e.getMessage());
        }
    }
/*
  public void ingresarMedios_veri_componentes() {
        try {

            String respuesta =FMedios_veri_componentes.ingresarMedios_veri_componentes(medcomponente);
            Util.addSuccessMessage(respuesta);
            cargarComponentes();
            // resetearFitrosTabla("frmAcciones:tblAcciones");
            componente = new Medios_veri_componentes();
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgRegistrar').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void registrar() dice: " + e.getMessage());
        }
    }

    public void actualizarMedios_veri_componentes() {
        try {
            String respuesta = FComponentes.actualizarComponentes(componenteSel);
            Util.addSuccessMessage(respuesta);
            cargarComponentes();
            //resetearFitrosTabla("frmAcciones:tblAcciones");
            componenteSel = new Medios_veri_componentes();
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgActualizar').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void actualizar() dice: " + e.getMessage());
        }
    }

    public void eliminarMedios_veri_componentes() {
        try {
            String respuesta = FComponentes.eliminarComponentes(componenteSel);
            Util.addSuccessMessage(respuesta);
            cargarComponentes();
            // resetearFitrosTabla("frmAcciones:tblAcciones");
            componenteSel = new Medios_veri_componentes();
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEliminar').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void eliminar() dice: " + e.getMessage());
        }
    }

    /**
     * @return the medcomponentelist
     */
    public ArrayList<Medios_veri_componentes> getMedcomponentelist() {
        return medcomponentelist;
    }

    /**
     * @param medcomponentelist the medcomponentelist to set
     */
    public void setMedcomponentelist(ArrayList<Medios_veri_componentes> medcomponentelist) {
        this.medcomponentelist = medcomponentelist;
    }

    /**
     * @return the medcomponenteSel
     */
    public Medios_veri_componentes getMedcomponenteSel() {
        return medcomponenteSel;
    }

    /**
     * @param medcomponenteSel the medcomponenteSel to set
     */
    public void setMedcomponenteSel(Medios_veri_componentes medcomponenteSel) {
        this.medcomponenteSel = medcomponenteSel;
    }

    /**
     * @return the medcomponente
     */
    public Medios_veri_componentes getMedcomponente() {
        return medcomponente;
    }

    /**
     * @param medcomponente the medcomponente to set
     */
    public void setMedcomponente(Medios_veri_componentes medcomponente) {
        this.medcomponente = medcomponente;
    }
    
}

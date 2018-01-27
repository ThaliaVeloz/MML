/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes_proyecto.presentacion.beans;
import componentes_proyecto.clases.Indicadores_componentes;
import componentes_proyecto.funciones.FIndicadores_componentes;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;
@ManagedBean
@ViewScoped
public class Indicadores_componentesC implements Serializable{
    private ArrayList<Indicadores_componentes> incomponentelist;
    private Indicadores_componentes incomponenteSel;
    private Indicadores_componentes incomponente;

    public Indicadores_componentesC() {
        incomponenteSel = new Indicadores_componentes();
        incomponente = new Indicadores_componentes();
        cargarIndicadores_componentes();

    }

    public void cargarIndicadores_componentes() {
        try {           
            setIncomponentelist(FIndicadores_componentes.obtenerIndicadorDadoCodigoComponente(0));

        } catch (Exception e) {
            System.out.println("public void cargarProyecto() dice: " + e.getMessage());
        }
    }

    public void ingresarIndicadores_componentes() {
        try {

            String respuesta = FIndicadores_componentes.ingresarIndicadores_componentes(incomponente);
            Util.addSuccessMessage(respuesta);
            cargarIndicadores_componentes();
            // resetearFitrosTabla("frmAcciones:tblAcciones");
            incomponente = new Indicadores_componentes();
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgRegistrar').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void registrar() dice: " + e.getMessage());
        }
    }

    public void actualizarIndicadores_componentes() {
        try {
            String respuesta = FIndicadores_componentes.actualizarIndicadores_componentes(incomponenteSel);
            Util.addSuccessMessage(respuesta);
            cargarIndicadores_componentes();
            //resetearFitrosTabla("frmAcciones:tblAcciones");
            incomponenteSel = new Indicadores_componentes();
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgActualizar').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void actualizar() dice: " + e.getMessage());
        }
    }

    public void eliminarIndicadores_componentes() {
        try {
            String respuesta = FIndicadores_componentes.eliminarIndicadores_componentes(incomponenteSel);
            Util.addSuccessMessage(respuesta);
            cargarIndicadores_componentes();
            // resetearFitrosTabla("frmAcciones:tblAcciones");
            incomponenteSel = new Indicadores_componentes();
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEliminar').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void eliminar() dice: " + e.getMessage());
        }
    }

    /**
     * @return the incomponentelist
     */
    public ArrayList<Indicadores_componentes> getIncomponentelist() {
        return incomponentelist;
    }

    /**
     * @param incomponentelist the incomponentelist to set
     */
    public void setIncomponentelist(ArrayList<Indicadores_componentes> incomponentelist) {
        this.incomponentelist = incomponentelist;
    }

    /**
     * @return the incomponenteSel
     */
    public Indicadores_componentes getIncomponenteSel() {
        return incomponenteSel;
    }

    /**
     * @param incomponenteSel the incomponenteSel to set
     */
    public void setIncomponenteSel(Indicadores_componentes incomponenteSel) {
        this.incomponenteSel = incomponenteSel;
    }

    /**
     * @return the incomponente
     */
    public Indicadores_componentes getIncomponente() {
        return incomponente;
    }

    /**
     * @param incomponente the incomponente to set
     */
    public void setIncomponente(Indicadores_componentes incomponente) {
        this.incomponente = incomponente;
    }
    
}

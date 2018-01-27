/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes_proyecto.presentacion.beans;

import componentes_proyecto.clases.Componentes;
import componentes_proyecto.clases.Indicadores_componentes;
import componentes_proyecto.clases.Medios_veri_componentes;
import componentes_proyecto.funciones.FComponentes;
import componentes_proyecto.funciones.FIndicadores_componentes;
import componentes_proyecto.funciones.FMedios_veri_componentes;
import encabezado_proyecto.clases.Indicadores_proposito;
import encabezado_proyecto.clases.Proyecto;
import encabezado_proyecto.funciones.FProyecto;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import master.logica.entidades.Usuario;
import master.logica.servicios.ServiciosUsuario;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

@ManagedBean
@ViewScoped
public class ComponentesC implements Serializable {

    private ArrayList<Componentes> componentelist;
    private Componentes componenteSel;
    private Componentes componente;
    private Proyecto proyectoSel;
    private ArrayList<Proyecto> proyectolist;
    private Indicadores_proposito indicadorSel;
    private HttpServletRequest httpServletRequest;
    private FacesContext faceContext;
    private Usuario sessionUsuario;
    private ArrayList<Indicadores_componentes> incomponentelist;
    private Indicadores_componentes incomponenteSel;
    private Indicadores_componentes incomponente;
    private ArrayList<Medios_veri_componentes> medcomponentelist;
    private Medios_veri_componentes medcomponenteSel;
    private Medios_veri_componentes medcomponente;

    public ComponentesC() {
        componenteSel = new Componentes();
        componente = new Componentes();
        proyectoSel = new Proyecto();
        sessionUsuario = new Usuario();
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        incomponenteSel = new Indicadores_componentes();
        incomponente = new Indicadores_componentes();
        medcomponenteSel = new Medios_veri_componentes();
        medcomponente = new Medios_veri_componentes();
        obtenerProyecto();

    }

    @PostConstruct
    public void init() {
        obtenerSesion();
    }

    public void obtenerProyecto() {
        try {
            int intIdUsuario = (int) getHttpServletRequest().getSession().getAttribute("idUsuario");
            setProyectolist(FProyecto.obtenerProyectoDadoCodigoUsuario(intIdUsuario));
        } catch (Exception e) {
            System.out.println("public void obtenerProyecto() dice: " + e.getMessage());
        }
    }

    public void obtenerSesion() {
        try {

            int intIdUsuario = (int) getHttpServletRequest().getSession().getAttribute("idUsuario");
            setSessionUsuario(ServiciosUsuario.buscarUsuarioDadoId(intIdUsuario));
            System.out.println("Usuario logeado: " + getSessionUsuario().getApellidos());
            System.out.println("Id Usuario: " + intIdUsuario);
        } catch (Exception e) {
            System.out.println("public void obtenerSesion() dice: " + e.getMessage());
        }
    }

    public void cargarComponentes() {
        try {
            setComponentelist(FComponentes.obtenerComponenteDadoCodigoProyecto(getProyectoSel().getCod_proyecto()));

        } catch (Exception e) {
            System.out.println("public void cargarProyecto() dice: " + e.getMessage());
        }
    }

    public void cargarIndicadores_componentes() {
        try {
            System.out.println("Codigo indicador " + getComponenteSel().getCod_componentes());
            setIncomponentelist(FIndicadores_componentes.obtenerIndicadorDadoCodigoComponente(getComponenteSel().getCod_componentes()));

        } catch (Exception e) {
            System.out.println("public void cargarProyecto() dice: " + e.getMessage());
        }
    }

    public void cargarMedios_veri_componentes() {
        try {
            setMedcomponentelist(FMedios_veri_componentes.obtenerMediosDadoCodigoIndicadorCompo(getIncomponenteSel().getCod_in_componentes()));

        } catch (Exception e) {
            System.out.println("public void cargarProyecto() dice: " + e.getMessage());
        }
    }

    public void ingresarComponentes() {
        try {

            componente.setCod_proposito(proyectoSel.getCod_proyecto());
            String respuesta = FComponentes.ingresarComponentes(getComponente());
            Util.addSuccessMessage(respuesta);
            cargarComponentes();
            resetearDataTable("frmPrincipal:tblComponentes");
            setComponente(new Componentes());
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgNuevoComponente').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void registrar() dice: " + e.getMessage());
        }
    }

    public void actualizarComponentes() {
        try {
            String respuesta = FComponentes.actualizarComponentes(componenteSel);
            Util.addSuccessMessage(respuesta);
            cargarComponentes();
            //resetearFitrosTabla("frmAcciones:tblAcciones");
            componenteSel = new Componentes();
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgActualizar').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void actualizar() dice: " + e.getMessage());
        }
    }

    public void eliminarComponentes() {
        try {
            String respuesta = FComponentes.eliminarComponentes(componenteSel);
            Util.addSuccessMessage(respuesta);
            cargarComponentes();
            // resetearFitrosTabla("frmAcciones:tblAcciones");
            componenteSel = new Componentes();
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEliminar').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void eliminar() dice: " + e.getMessage());
        }
    }

   /* public void ingresarIndicadores_componentes() {
        try {

            incomponente.setCod_componentes(componenteSel.getCod_componentes());
            String respuesta = FIndicadores_componentes.ingresarIndicadores_componentes(getIncomponente());
            System.out.println("public void ingresarIndicadores_componentes() dice: " + respuesta);
            Util.addSuccessMessage(respuesta);
            cargarIndicadores_componentes();
            resetearDataTable("frmPrincipal:tblIndicadores");
            setIncomponente(new Indicadores_componentes());
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgNuevoIndicador').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void registrar() dice: " + e.getMessage());
        }
    }*/
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

    public void resetearDataTable(String id) {
        DataTable table = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
        table.reset();
    }

    /**
     * @return the componentelist
     */
    public ArrayList<Componentes> getComponentelist() {
        return componentelist;
    }

    /**
     * @param componentelist the componentelist to set
     */
    public void setComponentelist(ArrayList<Componentes> componentelist) {
        this.componentelist = componentelist;
    }

    /**
     * @return the componenteSel
     */
    public Componentes getComponenteSel() {
        return componenteSel;
    }

    /**
     * @param componenteSel the componenteSel to set
     */
    public void setComponenteSel(Componentes componenteSel) {
        this.componenteSel = componenteSel;
    }

    /**
     * @return the componente
     */
    public Componentes getComponente() {
        return componente;
    }

    /**
     * @param componente the componente to set
     */
    public void setComponente(Componentes componente) {
        this.componente = componente;
    }

    public Proyecto getProyectoSel() {
        return proyectoSel;
    }

    public void setProyectoSel(Proyecto proyectoSel) {
        this.proyectoSel = proyectoSel;
    }

    public ArrayList<Proyecto> getProyectolist() {
        return proyectolist;
    }

    public void setProyectolist(ArrayList<Proyecto> proyectolist) {
        this.proyectolist = proyectolist;
    }

    public Indicadores_proposito getIndicadorSel() {
        return indicadorSel;
    }

    public void setIndicadorSel(Indicadores_proposito indicadorSel) {
        this.indicadorSel = indicadorSel;
    }

    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public FacesContext getFaceContext() {
        return faceContext;
    }

    public void setFaceContext(FacesContext faceContext) {
        this.faceContext = faceContext;
    }

    public Usuario getSessionUsuario() {
        return sessionUsuario;
    }

    public void setSessionUsuario(Usuario sessionUsuario) {
        this.sessionUsuario = sessionUsuario;
    }

    public ArrayList<Indicadores_componentes> getIncomponentelist() {
        return incomponentelist;
    }

    public void setIncomponentelist(ArrayList<Indicadores_componentes> incomponentelist) {
        this.incomponentelist = incomponentelist;
    }

    public Indicadores_componentes getIncomponenteSel() {
        return incomponenteSel;
    }

    public void setIncomponenteSel(Indicadores_componentes incomponenteSel) {
        this.incomponenteSel = incomponenteSel;
    }

    public Indicadores_componentes getIncomponente() {
        return incomponente;
    }

    public void setIncomponente(Indicadores_componentes incomponente) {
        this.incomponente = incomponente;
    }

    public ArrayList<Medios_veri_componentes> getMedcomponentelist() {
        return medcomponentelist;
    }

    public void setMedcomponentelist(ArrayList<Medios_veri_componentes> medcomponentelist) {
        this.medcomponentelist = medcomponentelist;
    }

    public Medios_veri_componentes getMedcomponenteSel() {
        return medcomponenteSel;
    }

    public void setMedcomponenteSel(Medios_veri_componentes medcomponenteSel) {
        this.medcomponenteSel = medcomponenteSel;
    }

    public Medios_veri_componentes getMedcomponente() {
        return medcomponente;
    }

    public void setMedcomponente(Medios_veri_componentes medcomponente) {
        this.medcomponente = medcomponente;
    }

}

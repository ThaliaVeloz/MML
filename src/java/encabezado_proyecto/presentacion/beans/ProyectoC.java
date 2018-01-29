/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encabezado_proyecto.presentacion.beans;

import encabezado_proyecto.clases.Proposito;
import encabezado_proyecto.clases.Proyecto;
import encabezado_proyecto.funciones.FProposito;
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
public class ProyectoC implements Serializable {

    private ArrayList<Proyecto> proyectolist;
    private ArrayList<Proposito> propositolist;
    private Proyecto proyectoSel;
    private Proyecto proyecto;
    private Proposito proposito;
    private HttpServletRequest httpServletRequest;
    private FacesContext faceContext;
    private Usuario sessionUsuario;
    private String habilitar;

    public ProyectoC() {

        proyectoSel = new Proyecto();
        proyecto = new Proyecto();
        proposito = new Proposito();
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
        cargarProyecto();
        //  cargarProposito();

    }

    @PostConstruct
    public void init() {
        obtenerSesion();
    }

    public void cargarProyecto() {
        try {
            int idUsuario = (int) getHttpServletRequest().getSession().getAttribute("idUsuario");
            setProyectolist(FProyecto.obtenerProyectoDadoCodigoUsuario(idUsuario));

            // System.out.println("Total de proyectos: " + proyectolist.size());
        } catch (Exception e) {
            System.out.println("public void cargarProyecto() dice: " + e.getMessage());
        }
    }

    public void cargarProposito() {
        try {
            setProposito(FProposito.obtenerPropositoDadoCodigoProyecto(proyectoSel.getCod_proyecto()));
            if (proposito.getCod_proposito() 
                    != null) {
                habilitar = "true";
            } else {
                habilitar = "false";
            }
        } catch (Exception e) {
            System.out.println("public void cargarProyecto() dice: " + e.getMessage());
        }
    }

    public void obtenerSesion() {
        try {

            int intIdUsuario = (int) httpServletRequest.getSession().getAttribute("idUsuario");
            setSessionUsuario(ServiciosUsuario.buscarUsuarioDadoId(intIdUsuario));
            System.out.println("Usuario logeado: " + getSessionUsuario().getApellidos());
            System.out.println("Id Usuario: " + intIdUsuario);
        } catch (Exception e) {
            System.out.println("public void obtenerSesion() dice: " + e.getMessage());
        }
    }

    public void ingresarProyecto() {
        try {

            proyecto.setInt_id_usuario(sessionUsuario.getIdPersona());
            String respuesta = FProyecto.ingresarProyecto(proyecto);
            proyecto = new Proyecto();
            Util.addSuccessMessage(respuesta);
            cargarProyecto();
            resetearFitrosTabla("frmUsuarios:tblUsuarios");

            DefaultRequestContext.getCurrentInstance().execute("PF('dlgRegistrar').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void registrar() dice: " + e.getMessage());
        }
    }

    public void actualizarProyecto() {
        try {
            proyectoSel.setInt_id_usuario(sessionUsuario.getIdPersona());
            String respuesta = FProyecto.actualizarProyecto(proyectoSel);

            Util.addSuccessMessage(respuesta);
            cargarProyecto();
            resetearFitrosTabla("frmUsuarios:tblUsuarios");
            proyectoSel = new Proyecto();
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgActualizarProyecto').hide()");
        } catch (Exception e) {
            System.out.println("public void actualizar() dice: " + e.getMessage());
            Util.addErrorMessage("public void actualizar() dice: " + e.getMessage());
        }
    }

    public void eliminarProyecto() {
        try {
            String respuesta = FProyecto.eliminarProyecto(proyectoSel);
            Util.addSuccessMessage(respuesta);
            cargarProyecto();
            resetearFitrosTabla("frmUsuarios:tblUsuarios");
            proyectoSel = new Proyecto();
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEliminar').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void eliminar() dice: " + e.getMessage());
        }
    }

    public void ingresarProposito() {
        try {

            //  proyecto.setInt_id_usuario(sessionUsuario.getIdPersona()); 
            System.out.println("Codigo del yecto " + proyectoSel.getCod_proyecto());
            proposito.setCod_proposito(proyectoSel.getCod_proyecto());
            String respuesta = FProposito.ingresarProposito(proposito);
            proposito = new Proposito();
            Util.addSuccessMessage(respuesta);
            cargarProposito();
            resetearFitrosTabla("frmUsuarios:tblUsuarios");

            DefaultRequestContext.getCurrentInstance().execute("PF('dlgproposito').hide()");
        } catch (Exception e) {
            System.out.println("public void ingresarProposito() dice: " + e.getMessage());
            Util.addErrorMessage("public void registrar proposito() dice: " + e.getMessage());
        }
    }

    public void actualizarProposito() {
        try {

            String respuesta = FProposito.actualizarProposito(proposito);
            Util.addSuccessMessage(respuesta);
            //cargarProposito();
            //resetearFitrosTabla("frmAcciones:tblAcciones");
            proposito = new Proposito();
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgproposito').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void actualizar() dice: " + e.getMessage());
        }
    }

    public void resetearFitrosTabla(String id) {
        DataTable table = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
        table.reset();
    }

    public String getHabilitar() {
        return habilitar;
    }

    public void setHabilitar(String habilitar) {
        this.habilitar = habilitar;
    }

    public ArrayList<Proposito> getPropositolist() {
        return propositolist;
    }

    public void setPropositolist(ArrayList<Proposito> propositolist) {
        this.propositolist = propositolist;
    }

    /**
     * @return the httpServletRequest
     */
    public HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    /**
     * @param httpServletRequest the httpServletRequest to set
     */
    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    /**
     * @return the faceContext
     */
    public FacesContext getFaceContext() {
        return faceContext;
    }

    /**
     * @param faceContext the faceContext to set
     */
    public void setFaceContext(FacesContext faceContext) {
        this.faceContext = faceContext;
    }

    /**
     * @return the sessionUsuario
     */
    public Usuario getSessionUsuario() {
        return sessionUsuario;
    }

    /**
     * @param sessionUsuario the sessionUsuario to set
     */
    public void setSessionUsuario(Usuario sessionUsuario) {
        this.sessionUsuario = sessionUsuario;
    }

    /**
     * @return the proyectolist
     */
    public ArrayList<Proyecto> getProyectolist() {
        return proyectolist;
    }

    /**
     * @param proyectolist the proyectolist to set
     */
    public void setProyectolist(ArrayList<Proyecto> proyectolist) {
        this.proyectolist = proyectolist;
    }

    /**
     * @return the proyectoSel
     */
    public Proyecto getProyectoSel() {
        return proyectoSel;
    }

    /**
     * @param proyectoSel the proyectoSel to set
     */
    public void setProyectoSel(Proyecto proyectoSel) {
        this.proyectoSel = proyectoSel;
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

    public Proposito getProposito() {
        return proposito;
    }

    public void setProposito(Proposito proposito) {
        this.proposito = proposito;
    }

}

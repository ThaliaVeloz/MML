package master.presentacion.beans;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import master.logica.entidades.Rol;
import master.logica.entidades.RolUsuario;
import master.logica.entidades.Usuario;
import master.logica.servicios.ServiciosRolUsuario;
import master.logica.servicios.ServiciosRoles;
import master.logica.servicios.ServiciosUsuario;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.DefaultRequestContext;
import recursos.Util;

@ManagedBean
@ViewScoped
public class UsuarioCtrl implements Serializable {

    private ArrayList<Usuario> lstUsuarios;
    private Usuario usuario;
    private Usuario usuarioSel;
    private RolUsuario rolUsuario;
    private int idRol;
    private ArrayList<Rol> lstRoles;

    public UsuarioCtrl() {
        usuario = new Usuario();
        usuarioSel = new Usuario();
        rolUsuario = new RolUsuario();
    }

    @PostConstruct
    public void init() {
        obtenerUsuarios();
        obtenerRoles();
    }

    public void obtenerUsuarios() {
        try {
            lstUsuarios = ServiciosUsuario.obtenerUsuariosDadoEstado("A");
        } catch (Exception e) {
            Util.addErrorMessage("public void obtenerUsuarios() dice: " + e.getMessage());
        }
    }

    public void insertarUsuario() {
        try {
            String msg = ServiciosUsuario.registrarUsuario(usuario);
            Util.addSuccessMessage(msg);
            obtenerUsuarios();
            resetearFitrosTabla("frmUsuarios:tblUsuarios");
            usuario = new Usuario();
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgRegistrar').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void insertarUsuario() dice: " + e.getMessage());
        }
    }

    public void insertarUsuarioDadoRol() {
        try {
            rolUsuario.setIdRol(ServiciosRoles.obtenerRolDadoCodigo(idRol));            
            String msg = ServiciosRolUsuario.registrarUsuarioDadoRol(rolUsuario);
            rolUsuario = new RolUsuario();
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserción Exitosa", msg);
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgRegistrarUsuario').hide()");
            obtenerUsuarios();
            resetearFitrosTabla("frmUsuarios:tblUsuarios");
        } catch (Exception e) {
            System.out.println("ublic void insertarUsuarioDadoRol()  dice: "+e.getMessage());
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
    }

    public void obtenerRoles() {
        try {
            this.setLstRoles(ServiciosRoles.obtenerRolesDadoEstado("A"));
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Getters y Setter">  
    public ArrayList<Usuario> getLstUsuarios() {
        return lstUsuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioSel() {
        return usuarioSel;
    }

    public void setUsuarioSel(Usuario usuarioSel) {
        this.usuarioSel = usuarioSel;
    }

    public void setLstUsuarios(ArrayList<Usuario> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo para resetear el datatable">    
    public void resetearFitrosTabla(String id) {
        DataTable table = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
        table.reset();
    }
    //</editor-fold>

    /**
     * @return the rolUsuario
     */
    public RolUsuario getRolUsuario() {
        return rolUsuario;
    }

    /**
     * @param rolUsuario the rolUsuario to set
     */
    public void setRolUsuario(RolUsuario rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    /**
     * @return the idRol
     */
    public int getIdRol() {
        return idRol;
    }

    /**
     * @param idRol the idRol to set
     */
    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    /**
     * @return the lstRoles
     */
    public ArrayList<Rol> getLstRoles() {
        return lstRoles;
    }

    /**
     * @param lstRoles the lstRoles to set
     */
    public void setLstRoles(ArrayList<Rol> lstRoles) {
        this.lstRoles = lstRoles;
    }
}

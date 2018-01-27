package master.logica.controladores;

import auditoria.logica.servicios.ServiciosAccesosUsuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import master.logica.entidades.RolUsuario;
import master.logica.entidades.Usuario;
import master.logica.servicios.ServiciosLogin;
import master.logica.servicios.ServiciosRolUsuario;
import recursos.Util;

@RequestScoped
@ManagedBean
public class ControladorLogin {

    private Usuario usuario;
    private RolUsuario rolUsuario;
    private ArrayList<RolUsuario> lstRoles;
    private HttpServletRequest httpServletRequest;
    private FacesContext faceContext;
    private FacesMessage facesMessage;

    public ControladorLogin() {
        usuario = new Usuario();
        rolUsuario = new RolUsuario();
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
    }

    public void iniciarSession() throws IOException {
        try {
            Usuario usuarioLogueado = ServiciosLogin.loginUsuario(usuario.getMail(), usuario.getPassword());

            faceContext.getExternalContext().getSessionMap().put("sessionUsuario", usuarioLogueado);
            
            httpServletRequest.getSession().setAttribute("idUsuarioLog", usuarioLogueado.getIdPersona());
            httpServletRequest.getSession().setAttribute("fotoUsuario", usuarioLogueado.getFoto());
            httpServletRequest.getSession().setAttribute("nombre", usuarioLogueado.getNombres().toUpperCase() + " " + usuarioLogueado.getApellidos().toUpperCase());
            httpServletRequest.getSession().setAttribute("idUsuario", usuarioLogueado.getIdPersona());
            httpServletRequest.getSession().setAttribute("usuarioLogueado", usuarioLogueado);
            
            int intIdUsuario = (int) httpServletRequest.getSession().getAttribute("idUsuario");
            lstRoles = ServiciosRolUsuario.listarRolesUsuario(intIdUsuario);
            
            System.out.println("Codigo Usuario: "+intIdUsuario);
            Util.addSuccessMessage("total de roles: " + lstRoles.size());            
            System.out.println("total de roles: " + lstRoles.size());
        
            if (lstRoles.size() >= 1) {
                faceContext.getExternalContext().redirect("seguridad/selectRol.xhtml");
                registarAcceso();
            } else {

            }
        } catch (Exception ex) {
            Util.addErrorMessage(ex.getMessage().replace("\n", "").replace("Hint:", ""));
        }
    }

    public void iniciarSesionRol() {
        try {
            int intIdRol = rolUsuario.getIdRol().getIdRol();
            httpServletRequest.getSession().setAttribute("idRol", intIdRol);
            faceContext.getExternalContext().redirect("test.xhtml");
        } catch (Exception ex) {
            Util.addErrorMessage(ex.getMessage().replace("\n", "").replace("Hint:", ""));
        }
    }

    
    public void cerrarSesion() throws Exception {
        try {
            int intIdUsuario = (int) httpServletRequest.getSession().getAttribute("idUsuarioLog");
            String registro = ServiciosAccesosUsuario.registrarSalidaSistema(intIdUsuario);
            System.out.println(registro);
            httpServletRequest.getSession().removeAttribute("usLogueado");
            httpServletRequest.getSession().removeAttribute("nombre");
            httpServletRequest.getSession().removeAttribute("ultimaIp");
            httpServletRequest.getSession().removeAttribute("ultimoAcceso");

            System.gc();  //limpiar todo
            FacesContext fc = FacesContext.getCurrentInstance();

            Util.addSuccessMessage("Sesión cerrada");
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.invalidate();

            fc.getExternalContext().redirect("/WebAppMunicipio");
            fc.getExternalContext().invalidateSession();
        } catch (Exception ex) {
            Util.addErrorMessage(ex.getMessage().replace("\n", "").replace("Hint:", ""));
        }
    }

    public void cambiarRol() throws Exception {
        try {
            faceContext.getExternalContext().redirect("/WebAppMunicipio/faces/seguridad/selectRol.xhtml");
        } catch (Exception ex) {
            Util.addErrorMessage(ex.getMessage().replace("\n", "").replace("Hint:", ""));
        }
    }

    public void registarAcceso() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            String ipLocal = request.getRemoteAddr();
            String hostname = request.getRemoteHost();
            int intIdUsuario = (int) httpServletRequest.getSession().getAttribute("idUsuarioLog");
            String registro = ServiciosAccesosUsuario.registrarAccesoSistema(intIdUsuario, ipLocal, ipLocal, hostname);
            System.out.println(registro);

        } catch (Exception e) {
            System.out.println("public void registarAcceso() dice: " + e.getMessage());
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public FacesMessage getFacesMessage() {
        return facesMessage;
    }

    public void setFacesMessage(FacesMessage facesMessage) {
        this.facesMessage = facesMessage;
    }

    public ArrayList<RolUsuario> getLstRoles() {
        return lstRoles;
    }

    public void setLstRoles(ArrayList<RolUsuario> lstRoles) {
        this.lstRoles = lstRoles;
    }

    public RolUsuario getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(RolUsuario rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

}
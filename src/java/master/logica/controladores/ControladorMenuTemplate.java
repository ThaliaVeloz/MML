package master.logica.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import master.logica.entidades.Funcion;
import master.logica.entidades.Menu;
import master.logica.entidades.NodoMenu;
import master.logica.entidades.RolUsuario;
import master.logica.servicios.ServiciosFuncion;
import master.logica.servicios.ServiciosNodoMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import recursos.Util;

@ManagedBean
@ViewScoped
public class ControladorMenuTemplate implements Serializable {

    private RolUsuario rolUsuario;
    private HttpServletRequest httpServletRequest;
    private FacesContext faceContext;
    private MenuModel menu;
    private DefaultMenuModel menuModel;
    private ArrayList<Menu> submenus;
    private ArrayList<NodoMenu> lstMenus;
    private String paginaActual;

    public ControladorMenuTemplate() {
        menuModel = new DefaultMenuModel();
        menu = new DefaultMenuModel();
        rolUsuario = new RolUsuario();
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
    }

    @PostConstruct
    public void init() {
        crearMenu();
    }

    public void crearMenu() {
        try {
            //obtengo los menus correspondientes al rol
            int idRol = (int) httpServletRequest.getSession().getAttribute("idRol");
            System.out.println("idRol: " + idRol);
            lstMenus = ServiciosNodoMenu.generarMenu(idRol);
            System.out.println("Total de submenus: " + lstMenus.size());
            //recorro la lista de menús
            ///-- empiezo a recorrer submenus   
            DefaultSubMenu subMenu;
            DefaultMenuItem item;
            for (int s = 0; s < lstMenus.size(); s++) {
                //agrego el submenu al modelo              
                subMenu = new DefaultSubMenu(lstMenus.get(s).getSubmenu().getNombre());
                subMenu.setStyleClass("jsId" + lstMenus.get(s).getSubmenu().getIdMenu());
                subMenu.setId(String.valueOf(lstMenus.get(s).getSubmenu().getIdMenu()));
                subMenu.setIcon(lstMenus.get(s).getSubmenu().getIcono());
                // recorro los items                                   
                for (int i = 0; i < lstMenus.get(s).getItems().size(); i++) {
                    //System.out.println("item: "+lst.get(i).getItems().get(j).getNombre());                    
                    item = new DefaultMenuItem(lstMenus.get(s).getItems().get(i).getNombre());
                    item.setIcon(lstMenus.get(s).getItems().get(i).getIcono());
                    item.setCommand("#{controladorMenuTemplate.obtenerUrlDadoItem(" + lstMenus.get(s).getItems().get(i).getIdMenu() + ")}");
                    //item.setUrl(paginaActual);                    
                    subMenu.addElement(item);
                }
                menu.addElement(subMenu);
            }
            //paginaActual = "home.xhtml";
            //redirecciono a la parte interna segura del sistema
            //faceContext.getExternalContext().redirect("index.xhtml");
        } catch (Exception e) {
            Util.addErrorMessage("public void crearMenu() dice: " + e.getMessage());
        }
    }

    public void obtenerUrlDadoItem(int idMenuSel) {        
        try {
            FacesContext fc = FacesContext.getCurrentInstance();            
            Funcion funcion = ServiciosFuncion.obtenerFuncionDadoIdMenu(idMenuSel);
            System.out.println("Página seleccionada: " + funcion.getCodigoAccion().getUrl());
            paginaActual = funcion.getCodigoAccion().getUrl();              
            fc.getExternalContext().redirect(paginaActual);                        
//            context.update("paginas");
        } catch (Exception e) {
            //Util.addErrorMessage("public void obtenerUrlDadoItem() dice: " + e.getMessage());
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Este item no tiene URL asociada", "Consulte con el administrador");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }
        
    }

    public RolUsuario getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(RolUsuario rolUsuario) {
        this.rolUsuario = rolUsuario;
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

    public MenuModel getMenu() {
        return menu;
    }

    public void setMenu(MenuModel menu) {
        this.menu = menu;
    }

    public DefaultMenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(DefaultMenuModel menuModel) {
        this.menuModel = menuModel;
    }

    public ArrayList<Menu> getSubmenus() {
        return submenus;
    }

    public void setSubmenus(ArrayList<Menu> submenus) {
        this.submenus = submenus;
    }

    public ArrayList<NodoMenu> getLstMenus() {
        return lstMenus;
    }

    public String getPaginaActual() {
        return paginaActual;
    }

    public void setPaginaActual(String paginaActual) {
        this.paginaActual = paginaActual;
    }

    public void setLstMenus(ArrayList<NodoMenu> lstMenus) {
        this.lstMenus = lstMenus;
    }

}

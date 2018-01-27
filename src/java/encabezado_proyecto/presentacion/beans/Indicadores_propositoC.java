/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encabezado_proyecto.presentacion.beans;

import encabezado_proyecto.clases.Indicadores_proposito;
import encabezado_proyecto.clases.Medios_veri_proposito;
import encabezado_proyecto.clases.Proyecto;
import encabezado_proyecto.funciones.FIndicadores_proposito;
import encabezado_proyecto.funciones.FMedios_veri_proposito;
import encabezado_proyecto.funciones.FProyecto;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import master.logica.entidades.Usuario;
import master.logica.servicios.ServiciosUsuario;
import org.apache.taglibs.standard.functions.Functions;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.DefaultRequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import recursos.Util;

@ManagedBean
@ViewScoped
public class Indicadores_propositoC implements Serializable {

    private ArrayList<Indicadores_proposito> inpropositolist;
    private Indicadores_proposito inpropositoSel;
    private Indicadores_proposito inproposito;
    private ArrayList<Proyecto> proyectolist;
    private Proyecto proyecto;
    private Proyecto proyectoSel;
    private Indicadores_proposito indicadorSel;
    private HttpServletRequest httpServletRequest;
    private FacesContext faceContext;
    private Usuario sessionUsuario;
    private int codigoProyecto;
    private ArrayList<Medios_veri_proposito> lstMedios;
    private Medios_veri_proposito medioSel;
    private Medios_veri_proposito objMedio;

    //manejo de archivos
    private String nombreDocumento;
    private UploadedFile archivoDocumento;
    //cargar configuracion del  path
    private java.util.ResourceBundle Configuracion = java.util.ResourceBundle.getBundle("recursos.rutasMedia");

    public Indicadores_propositoC() {
        objMedio = new Medios_veri_proposito();
        sessionUsuario = new Usuario();
        indicadorSel = new Indicadores_proposito();
        medioSel = new Medios_veri_proposito();
        proyectoSel = new Proyecto();
        proyecto = new Proyecto();
        inpropositoSel = new Indicadores_proposito();
        inproposito = new Indicadores_proposito();
        faceContext = FacesContext.getCurrentInstance();
        httpServletRequest = (HttpServletRequest) faceContext.getExternalContext().getRequest();
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

    public void cargarIndicadores_proposito() {
        try {

            System.out.println("Codigo proyecto " + getCodigoProyecto());
            setInpropositolist(FIndicadores_proposito.obtenerIndicadorDadoCodigoProposito(getCodigoProyecto()));
            //setInpropositolist(FIndicadores_proposito.obtenerIndicadorDadoCodigoProposito(1));
        } catch (Exception e) {
            System.out.println("public void cargarProyecto() dice: " + e.getMessage());
        }
    }

    public void obtenerMedios() {
        try {
            System.out.println("Seleccion " + getIndicadorSel().getCod_in_proposito());
            setLstMedios(FMedios_veri_proposito.obtenerMediosDadoCodigoIndicadorProp(getIndicadorSel().getCod_in_proposito()));
        } catch (Exception e) {
            System.out.println("public void obtenerMedios() dice: " + e.getMessage());
        }
    }

    public void ingresarIndicadores_proposito() {
        try {
            getInproposito().setCod_proposito(getProyectoSel().getCod_proyecto());
            String respuesta = FIndicadores_proposito.ingresarIndicadores_proposito(getInproposito());
            System.out.println("public void ingresarIndicadores_proposito() dice: " + respuesta);
            Util.addSuccessMessage(respuesta);
            cargarIndicadores_proposito();
            resetearDataTable("frmPrincipal:tblIndicadores");
            setInproposito(new Indicadores_proposito());
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgNuevoIndicador').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void registrar() dice: " + e.getMessage());
        }
    }

    public void actualizarIndicadores_proposito() {
        try {
            System.out.println("idnicador " + getIndicadorSel().getDes_in_proposito()
                    + " tipo " + getIndicadorSel().getTipo_cantidad_proposito()
                    + " cantidad: " + getIndicadorSel().getCantidad_in_proposito());

            String respuesta = FIndicadores_proposito.actualizarIndicadores_proposito(getIndicadorSel());
            Util.addSuccessMessage(respuesta);
            cargarIndicadores_proposito();
            resetearDataTable("frmPrincipal:tblIndicadores");
            setInpropositoSel(new Indicadores_proposito());
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEditarIndicador').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void actualizar() dice: " + e.getMessage());
        }
    }

    public void eliminarIndicadores_proposito() {
        try {
            String respuesta = FIndicadores_proposito.eliminarIndicadoresProposito(getIndicadorSel().getCod_in_proposito());
            Util.addSuccessMessage(respuesta);
            cargarIndicadores_proposito();
            obtenerMedios();
            resetearDataTable("frmPrincipal:tblIndicadores");
            resetearDataTable("frmPrincipal:tblMedios");
            setInpropositoSel(new Indicadores_proposito());
            DefaultRequestContext.getCurrentInstance().execute("PF('dlgEliminarIndicador').hide()");
        } catch (Exception e) {
            Util.addErrorMessage("public void eliminar() dice: " + e.getMessage());
        }
    }

    public void cargarArchivoDocumento(FileUploadEvent e) {
        System.out.println("Entra al método cargar documento");
        UploadedFile file = e.getFile();
        this.setArchivoDocumento(file);
        System.out.println(file.getContentType());
        // getObjDocumento().setTipo(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.getFileName());
        setNombreDocumento(file.getFileName());
        //byte[] contenido = file.getContents();
        byte[] contenido;
        try {
            contenido = this.getFileContents(e.getFile().getInputstream());
            if (guardarArchivo(file.getFileName(), contenido)) {
                Util.addSuccessMessage("Documento guardado con éxito!!");
            } else {
                Util.addErrorMessage("Error al cargar el Documento");
            }
        } catch (IOException ex) {
            Logger.getLogger(Indicadores_propositoC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean guardarArchivo(String nombre, byte[] contenido) {
        String rutaImagenes = getConfiguracion().getString("rutaMedios");
        int longitudRelativa = Integer.valueOf(getConfiguracion().getString("logitudRelativa"));
        File f = new File(rutaImagenes + nombre);
        try {
            System.out.println("PATH: " + f.getAbsolutePath());
            System.out.println("Ruta a guardar: " + Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length()));
            // getObjCliente().setPathCedula(Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length()));
            // getObjDocumento().setTitulo(nombre);

            String rutaTemp = Functions.substring(f.getAbsolutePath(), longitudRelativa, f.getAbsolutePath().length());

            getObjMedio().setArchivo_medios_veri_prop(rutaTemp.replace('\\', '/'));

            System.out.println("cargar objeto fos ");
            FileOutputStream fos = new FileOutputStream(f);
            System.out.println("escribir fos ");
            fos.write(contenido);

            return true;
        } catch (Exception e) {
            Util.mostrarMensaje(e.getMessage());
            return false;
        }
    }

    private byte[] getFileContents(InputStream in) {
        byte[] bytes = null;
        try {
            // write the inputStream to a FileOutputStream            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int read = 0;
            bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                bos.write(bytes, 0, read);
            }
            bytes = bos.toByteArray();
            in.close();
            in = null;
            bos.flush();
            bos.close();
            bos = null;
            System.out.println("New file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return bytes;
    }

    public void resetearDataTable(String id) {
        DataTable table = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
        table.reset();
    }

    /**
     * @return the inpropositolist
     */
    public ArrayList<Indicadores_proposito> getInpropositolist() {
        return inpropositolist;
    }

    /**
     * @param inpropositolist the inpropositolist to set
     */
    public void setInpropositolist(ArrayList<Indicadores_proposito> inpropositolist) {
        this.inpropositolist = inpropositolist;
    }

    /**
     * @return the inpropositoSel
     */
    public Indicadores_proposito getInpropositoSel() {
        return inpropositoSel;
    }

    /**
     * @param inpropositoSel the inpropositoSel to set
     */
    public void setInpropositoSel(Indicadores_proposito inpropositoSel) {
        this.inpropositoSel = inpropositoSel;
    }

    /**
     * @return the inproposito
     */
    public Indicadores_proposito getInproposito() {
        return inproposito;
    }

    /**
     * @param inproposito the inproposito to set
     */
    public void setInproposito(Indicadores_proposito inproposito) {
        this.inproposito = inproposito;
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
     * @return the codigoProyecto
     */
    public int getCodigoProyecto() {
        return codigoProyecto;
    }

    /**
     * @param codigoProyecto the codigoProyecto to set
     */
    public void setCodigoProyecto(int codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
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
     * @return the indicadorSel
     */
    public Indicadores_proposito getIndicadorSel() {
        return indicadorSel;
    }

    /**
     * @param indicadorSel the indicadorSel to set
     */
    public void setIndicadorSel(Indicadores_proposito indicadorSel) {
        this.indicadorSel = indicadorSel;
    }

    /**
     * @return the lstMedios
     */
    public ArrayList<Medios_veri_proposito> getLstMedios() {
        return lstMedios;
    }

    /**
     * @param lstMedios the lstMedios to set
     */
    public void setLstMedios(ArrayList<Medios_veri_proposito> lstMedios) {
        this.lstMedios = lstMedios;
    }

    /**
     * @return the medioSel
     */
    public Medios_veri_proposito getMedioSel() {
        return medioSel;
    }

    /**
     * @param medioSel the medioSel to set
     */
    public void setMedioSel(Medios_veri_proposito medioSel) {
        this.medioSel = medioSel;
    }

    /**
     * @return the objMedio
     */
    public Medios_veri_proposito getObjMedio() {
        return objMedio;
    }

    /**
     * @param objMedio the objMedio to set
     */
    public void setObjMedio(Medios_veri_proposito objMedio) {
        this.objMedio = objMedio;
    }

    /**
     * @return the nombreDocumento
     */
    public String getNombreDocumento() {
        return nombreDocumento;
    }

    /**
     * @param nombreDocumento the nombreDocumento to set
     */
    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    /**
     * @return the archivoDocumento
     */
    public UploadedFile getArchivoDocumento() {
        return archivoDocumento;
    }

    /**
     * @param archivoDocumento the archivoDocumento to set
     */
    public void setArchivoDocumento(UploadedFile archivoDocumento) {
        this.archivoDocumento = archivoDocumento;
    }

    /**
     * @return the Configuracion
     */
    public java.util.ResourceBundle getConfiguracion() {
        return Configuracion;
    }

    /**
     * @param Configuracion the Configuracion to set
     */
    public void setConfiguracion(java.util.ResourceBundle Configuracion) {
        this.Configuracion = Configuracion;
    }

}

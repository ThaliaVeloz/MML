package encabezado_proyecto.clases;

public class Proyecto {

    private String nombre_proyecto;
    private String descripcion_proyecto;
    private String fin_proyecto;
    private int cod_proyecto;
    private int int_id_usuario;

    public Proyecto() {
    }

    public Proyecto(String nombre_proyecto, String descripcion_proyecto, String fin_proyecto, int cod_proyecto, int int_id_usuario) {
        this.nombre_proyecto = nombre_proyecto;
        this.descripcion_proyecto = descripcion_proyecto;
        this.fin_proyecto = fin_proyecto;
        this.cod_proyecto = cod_proyecto;
        this.int_id_usuario = int_id_usuario;
    }

    /**
     * @return the nombre_proyecto
     */
    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    /**
     * @param nombre_proyecto the nombre_proyecto to set
     */
    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }

    /**
     * @return the descripcion_proyecto
     */
    public String getDescripcion_proyecto() {
        return descripcion_proyecto;
    }

    /**
     * @param descripcion_proyecto the descripcion_proyecto to set
     */
    public void setDescripcion_proyecto(String descripcion_proyecto) {
        this.descripcion_proyecto = descripcion_proyecto;
    }

    /**
     * @return the fin_proyecto
     */
    public String getFin_proyecto() {
        return fin_proyecto;
    }

    /**
     * @param fin_proyecto the fin_proyecto to set
     */
    public void setFin_proyecto(String fin_proyecto) {
        this.fin_proyecto = fin_proyecto;
    }

    /**
     * @return the cod_proyecto
     */
    public int getCod_proyecto() {
        return cod_proyecto;
    }

    /**
     * @param cod_proyecto the cod_proyecto to set
     */
    public void setCod_proyecto(int cod_proyecto) {
        this.cod_proyecto = cod_proyecto;
    }

    /**
     * @return the int_id_usuario
     */
    public int getInt_id_usuario() {
        return int_id_usuario;
    }

    /**
     * @param int_id_usuario the int_id_usuario to set
     */
    public void setInt_id_usuario(int int_id_usuario) {
        this.int_id_usuario = int_id_usuario;
    }

}

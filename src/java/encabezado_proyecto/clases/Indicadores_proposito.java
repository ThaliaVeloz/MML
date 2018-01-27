package encabezado_proyecto.clases;

public class Indicadores_proposito {

    private int cod_in_proposito;
    private String des_in_proposito;
    private int cantidad_in_proposito;
    private int cod_proposito;
    private String tipo_cantidad_proposito;

    public Indicadores_proposito() {
    }

    public Indicadores_proposito(int cod_in_proposito, String des_in_proposito, int cantidad_in_proposito, int cod_proposito, String tipo_cantidad_proposito) {
        this.cod_in_proposito = cod_in_proposito;
        this.des_in_proposito = des_in_proposito;
        this.cantidad_in_proposito = cantidad_in_proposito;
        this.cod_proposito = cod_proposito;
        this.tipo_cantidad_proposito = tipo_cantidad_proposito;
    }

    /**
     * @return the cod_in_proposito
     */
    public int getCod_in_proposito() {
        return cod_in_proposito;
    }

    /**
     * @param cod_in_proposito the cod_in_proposito to set
     */
    public void setCod_in_proposito(int cod_in_proposito) {
        this.cod_in_proposito = cod_in_proposito;
    }

    /**
     * @return the des_in_proposito
     */
    public String getDes_in_proposito() {
        return des_in_proposito;
    }

    /**
     * @param des_in_proposito the des_in_proposito to set
     */
    public void setDes_in_proposito(String des_in_proposito) {
        this.des_in_proposito = des_in_proposito;
    }

    /**
     * @return the cantidad_in_proposito
     */
    public int getCantidad_in_proposito() {
        return cantidad_in_proposito;
    }

    /**
     * @param cantidad_in_proposito the cantidad_in_proposito to set
     */
    public void setCantidad_in_proposito(int cantidad_in_proposito) {
        this.cantidad_in_proposito = cantidad_in_proposito;
    }

    /**
     * @return the cod_proposito
     */
    public int getCod_proposito() {
        return cod_proposito;
    }

    /**
     * @param cod_proposito the cod_proposito to set
     */
    public void setCod_proposito(int cod_proposito) {
        this.cod_proposito = cod_proposito;
    }

    /**
     * @return the tipo_cantidad_proposito
     */
    public String getTipo_cantidad_proposito() {
        return tipo_cantidad_proposito;
    }

    /**
     * @param tipo_cantidad_proposito the tipo_cantidad_proposito to set
     */
    public void setTipo_cantidad_proposito(String tipo_cantidad_proposito) {
        this.tipo_cantidad_proposito = tipo_cantidad_proposito;
    }

}

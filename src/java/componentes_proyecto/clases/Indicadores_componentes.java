package componentes_proyecto.clases;

public class Indicadores_componentes {

    private int cod_in_componentes;
    private String des_in_componentes;
    private int cantidad_in_componentes;
    private int cod_componentes;
    String tipo_cantidad_componentes;

    public Indicadores_componentes() {
    }

    public Indicadores_componentes(int cod_in_componentes, String des_in_componentes, int cantidad_in_componentes, int cod_componentes, String tipo_cantidad_componentes) {
        this.cod_in_componentes = cod_in_componentes;
        this.des_in_componentes = des_in_componentes;
        this.cantidad_in_componentes = cantidad_in_componentes;
        this.cod_componentes = cod_componentes;
        this.tipo_cantidad_componentes = tipo_cantidad_componentes;
    }

    public int getCod_in_componentes() {
        return cod_in_componentes;
    }

    public void setCod_in_componentes(int cod_in_componentes) {
        this.cod_in_componentes = cod_in_componentes;
    }

    public String getDes_in_componentes() {
        return des_in_componentes;
    }

    public void setDes_in_componentes(String des_in_componentes) {
        this.des_in_componentes = des_in_componentes;
    }

    public int getCantidad_in_componentes() {
        return cantidad_in_componentes;
    }

    public void setCantidad_in_componentes(int cantidad_in_componentes) {
        this.cantidad_in_componentes = cantidad_in_componentes;
    }

    public int getCod_componentes() {
        return cod_componentes;
    }

    public void setCod_componentes(int cod_componentes) {
        this.cod_componentes = cod_componentes;
    }

    public String getTipo_cantidad_componentes() {
        return tipo_cantidad_componentes;
    }

    public void setTipo_cantidad_componentes(String tipo_cantidad_componentes) {
        this.tipo_cantidad_componentes = tipo_cantidad_componentes;
    }

    

}

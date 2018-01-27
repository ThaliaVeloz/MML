
package componentes_proyecto.clases;

public class Componentes {
    private int cod_componentes;
    private String descripcion_componente;
    private double costo_componente;
    private String supuestos_componentes;
    private int cod_proposito;

    public Componentes() {
    }

    public Componentes(int cod_componentes, String descripcion_componente, double costo_componente, String supuestos_componentes, int cod_proposito) {
        this.cod_componentes = cod_componentes;
        this.descripcion_componente = descripcion_componente;
        this.costo_componente = costo_componente;
        this.supuestos_componentes = supuestos_componentes;
        this.cod_proposito = cod_proposito;
    }

    public int getCod_componentes() {
        return cod_componentes;
    }

    public void setCod_componentes(int cod_componentes) {
        this.cod_componentes = cod_componentes;
    }

    public String getDescripcion_componente() {
        return descripcion_componente;
    }

    public void setDescripcion_componente(String descripcion_componente) {
        this.descripcion_componente = descripcion_componente;
    }

    public double getCosto_componente() {
        return costo_componente;
    }

    public void setCosto_componente(double costo_componente) {
        this.costo_componente = costo_componente;
    }

    public String getSupuestos_componentes() {
        return supuestos_componentes;
    }

    public void setSupuestos_componentes(String supuestos_componentes) {
        this.supuestos_componentes = supuestos_componentes;
    }

    public int getCod_proposito() {
        return cod_proposito;
    }

    public void setCod_proposito(int cod_proposito) {
        this.cod_proposito = cod_proposito;
    }

    
}

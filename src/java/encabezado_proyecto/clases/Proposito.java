
package encabezado_proyecto.clases;


public class Proposito {
    Integer cod_proposito;   
    String descripcion_proposito;
    double costo_proposito;
    String supuesto_proposito;

    public Proposito() {
    }

    public Proposito(Integer cod_proposito, String descripcion_proposito, double costo_proposito, String supuesto_proposito) {
        this.cod_proposito = cod_proposito;
        this.descripcion_proposito = descripcion_proposito;
        this.costo_proposito = costo_proposito;
        this.supuesto_proposito = supuesto_proposito;
    }

    public Integer getCod_proposito() {
        return cod_proposito;
    }

    public void setCod_proposito(Integer cod_proposito) {
        this.cod_proposito = cod_proposito;
    }

    public String getDescripcion_proposito() {
        return descripcion_proposito;
    }

    public void setDescripcion_proposito(String descripcion_proposito) {
        this.descripcion_proposito = descripcion_proposito;
    }

    public double getCosto_proposito() {
        return costo_proposito;
    }

    public void setCosto_proposito(double costo_proposito) {
        this.costo_proposito = costo_proposito;
    }

    public String getSupuesto_proposito() {
        return supuesto_proposito;
    }

    public void setSupuesto_proposito(String supuesto_proposito) {
        this.supuesto_proposito = supuesto_proposito;
    }
    
}

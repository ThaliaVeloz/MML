package actividades_proyecto.clases;

public class Actividades {

    private int cod_actividad;
    private String descripcion_actividad;
    private String supuesto_actividado;
    private double costo_actividad;
    private int cod_componentes;

    public Actividades() {
    }

    public Actividades(int cod_actividad, String descripcion_actividad, String supuesto_actividado, double costo_actividad, int cod_componentes) {
        this.cod_actividad = cod_actividad;
        this.descripcion_actividad = descripcion_actividad;
        this.supuesto_actividado = supuesto_actividado;
        this.costo_actividad = costo_actividad;
        this.cod_componentes = cod_componentes;
    }

    public int getCod_actividad() {
        return cod_actividad;
    }

    public void setCod_actividad(int cod_actividad) {
        this.cod_actividad = cod_actividad;
    }

    public String getDescripcion_actividad() {
        return descripcion_actividad;
    }

    public void setDescripcion_actividad(String descripcion_actividad) {
        this.descripcion_actividad = descripcion_actividad;
    }

    public String getSupuesto_actividado() {
        return supuesto_actividado;
    }

    public void setSupuesto_actividado(String supuesto_actividado) {
        this.supuesto_actividado = supuesto_actividado;
    }

    public double getCosto_actividad() {
        return costo_actividad;
    }

    public void setCosto_actividad(double costo_actividad) {
        this.costo_actividad = costo_actividad;
    }

    public int getCod_componentes() {
        return cod_componentes;
    }

    public void setCod_componentes(int cod_componentes) {
        this.cod_componentes = cod_componentes;
    }

    
    
}

package encabezado_proyecto.clases;

public class Medios_veri_proposito {

    Integer cod_medios_veri_in;    
    String observa_medios_veri_in;
    Integer cod_in_proposito;
    String archivo_medios_veri_prop;

    public Medios_veri_proposito() {
    }

    public Medios_veri_proposito(Integer cod_medios_veri_in, String observa_medios_veri_in, Integer cod_in_proposito, String archivo_medios_veri_prop) {
        this.cod_medios_veri_in = cod_medios_veri_in;
        this.observa_medios_veri_in = observa_medios_veri_in;
        this.cod_in_proposito = cod_in_proposito;
        this.archivo_medios_veri_prop = archivo_medios_veri_prop;
    }

    public Integer getCod_medios_veri_in() {
        return cod_medios_veri_in;
    }

    public void setCod_medios_veri_in(Integer cod_medios_veri_in) {
        this.cod_medios_veri_in = cod_medios_veri_in;
    }

    public String getObserva_medios_veri_in() {
        return observa_medios_veri_in;
    }

    public void setObserva_medios_veri_in(String observa_medios_veri_in) {
        this.observa_medios_veri_in = observa_medios_veri_in;
    }

    public Integer getCod_in_proposito() {
        return cod_in_proposito;
    }

    public void setCod_in_proposito(Integer cod_in_proposito) {
        this.cod_in_proposito = cod_in_proposito;
    }

    public String getArchivo_medios_veri_prop() {
        return archivo_medios_veri_prop;
    }

    public void setArchivo_medios_veri_prop(String archivo_medios_veri_prop) {
        this.archivo_medios_veri_prop = archivo_medios_veri_prop;
    }

}

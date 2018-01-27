
package componentes_proyecto.clases;

public class Medios_veri_componentes {
    private Integer cod_medios_veri_compo;   
    private String observa_medios_veri_compo;
    private int cod_in_componentes;
    private String archivo_medios_veri_compo;

    public Medios_veri_componentes() {
    }

    public Medios_veri_componentes(Integer cod_medios_veri_compo, String observa_medios_veri_compo, int cod_in_componentes, String archivo_medios_veri_compo) {
        this.cod_medios_veri_compo = cod_medios_veri_compo;
        this.observa_medios_veri_compo = observa_medios_veri_compo;
        this.cod_in_componentes = cod_in_componentes;
        this.archivo_medios_veri_compo = archivo_medios_veri_compo;
    }

    public Integer getCod_medios_veri_compo() {
        return cod_medios_veri_compo;
    }

    public void setCod_medios_veri_compo(Integer cod_medios_veri_compo) {
        this.cod_medios_veri_compo = cod_medios_veri_compo;
    }

    public String getObserva_medios_veri_compo() {
        return observa_medios_veri_compo;
    }

    public void setObserva_medios_veri_compo(String observa_medios_veri_compo) {
        this.observa_medios_veri_compo = observa_medios_veri_compo;
    }

    public int getCod_in_componentes() {
        return cod_in_componentes;
    }

    public void setCod_in_componentes(int cod_in_componentes) {
        this.cod_in_componentes = cod_in_componentes;
    }

    public String getArchivo_medios_veri_compo() {
        return archivo_medios_veri_compo;
    }

    public void setArchivo_medios_veri_compo(String archivo_medios_veri_compo) {
        this.archivo_medios_veri_compo = archivo_medios_veri_compo;
    }

    
    
}

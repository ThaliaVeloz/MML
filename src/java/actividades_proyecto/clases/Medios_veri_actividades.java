
package actividades_proyecto.clases;

public class Medios_veri_actividades {
    private int cod_medios_veri_activida;   
    private String des_medios_veri_activida;
    private int cod_actividades;
    private String archivo_medios_veri_activi;

    public Medios_veri_actividades() {
    }

    public Medios_veri_actividades(int cod_medios_veri_activida, String des_medios_veri_activida, int cod_actividades, String archivo_medios_veri_activi) {
        this.cod_medios_veri_activida = cod_medios_veri_activida;
        this.des_medios_veri_activida = des_medios_veri_activida;
        this.cod_actividades = cod_actividades;
        this.archivo_medios_veri_activi = archivo_medios_veri_activi;
    }

    public int getCod_medios_veri_activida() {
        return cod_medios_veri_activida;
    }

    public void setCod_medios_veri_activida(int cod_medios_veri_activida) {
        this.cod_medios_veri_activida = cod_medios_veri_activida;
    }

    public String getDes_medios_veri_activida() {
        return des_medios_veri_activida;
    }

    public void setDes_medios_veri_activida(String des_medios_veri_activida) {
        this.des_medios_veri_activida = des_medios_veri_activida;
    }

    public int getCod_actividades() {
        return cod_actividades;
    }

    public void setCod_actividades(int cod_actividades) {
        this.cod_actividades = cod_actividades;
    }

    public String getArchivo_medios_veri_activi() {
        return archivo_medios_veri_activi;
    }

    public void setArchivo_medios_veri_activi(String archivo_medios_veri_activi) {
        this.archivo_medios_veri_activi = archivo_medios_veri_activi;
    }

    
    
}

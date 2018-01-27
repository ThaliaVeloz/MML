
package componentes_proyecto.funciones;

import accesoDatos.AccesoDatos;
import componentes_proyecto.clases.Medios_veri_componentes;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author WinUser
 */
public class FMedios_veri_componentes implements Serializable{
    public static String ingresarMedios_veri_componentes(Medios_veri_componentes medio) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from encabezado_proyecto.fi_medios_veri_proposito(?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, medio.getObserva_medios_veri_compo());
            prstm.setInt(2, medio.getCod_in_componentes());
            prstm.setString(3, medio.getArchivo_medios_veri_compo());
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            if (resultSet.next()) {
                respuesta = resultSet.getString(1);
                return respuesta;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static String actualizarMedios_veri_componentes(Medios_veri_componentes medio) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from componentes_proyecto.fa_medios_veri_componentes(?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, medio.getObserva_medios_veri_compo());
            prstm.setInt(2, medio.getCod_in_componentes());
            prstm.setString(3, medio.getArchivo_medios_veri_compo());
            prstm.setInt(4, medio.getCod_medios_veri_compo());
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            if (resultSet.next()) {
                respuesta = resultSet.getString(1);
                return respuesta;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static String eliminarMedios_veri_componentes(Medios_veri_componentes medio) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from componentes_proyecto.fe_medios_veri_componentes(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, medio.getCod_medios_veri_compo());
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            if (resultSet.next()) {
                respuesta = resultSet.getString(1);
                return respuesta;
            } else {
                return null;
            }

        } catch (Exception e) {
            throw e;
        }

    }
     public static ArrayList<Medios_veri_componentes> obtenerMediosDadoCodigoIndicadorCompo(int codigo) throws Exception {
        ArrayList<Medios_veri_componentes> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        PreparedStatement prstm;
        Medios_veri_componentes accion;
        ResultSet resultSet;
        String sql;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from componentes_proyecto.f_select_medios_dado_codigo_indicador_componente(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, codigo);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                accion = new Medios_veri_componentes();
                accion.setCod_medios_veri_compo(resultSet.getInt("pcod_medios_veri_compo"));
                accion.setObserva_medios_veri_compo(resultSet.getString("pobservacion_medio_veri_compo"));
                accion.setArchivo_medios_veri_compo(resultSet.getString("parchivo_medios_veri_compo"));
                accion.setCod_in_componentes(resultSet.getInt("pcod_in_componentes"));
                lst.add(accion);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }
}

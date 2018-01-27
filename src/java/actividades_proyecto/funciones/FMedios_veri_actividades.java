
package actividades_proyecto.funciones;

import accesoDatos.AccesoDatos;
import actividades_proyecto.clases.Medios_veri_actividades;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class FMedios_veri_actividades implements Serializable{
     public static String ingresarMedios_veri_actividades(Medios_veri_actividades medio) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from actividades_proyecto.fi_medios_veri_actividades(?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, medio.getDes_medios_veri_activida());
            prstm.setInt(2, medio.getCod_actividades());
            prstm.setString(3, medio.getArchivo_medios_veri_activi());
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

    public static String actualizarMedios_veri_actividades(Medios_veri_actividades medio) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from actividades_proyecto.fa_medios_veri_actividades(?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, medio.getDes_medios_veri_activida());
            prstm.setInt(2, medio.getCod_actividades());
            prstm.setString(3, medio.getArchivo_medios_veri_activi());
            prstm.setInt(4, medio.getCod_medios_veri_activida());
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

    public static String eliminarMedios_veri_actividades(Medios_veri_actividades medio) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from actividades_proyecto.fe_medios_veri_actividades(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, medio.getCod_medios_veri_activida());
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
     public static ArrayList<Medios_veri_actividades> obtenerMediosDadoCodigoActividad(int codigo) throws Exception {
        ArrayList<Medios_veri_actividades> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        PreparedStatement prstm;
        Medios_veri_actividades accion;
        ResultSet resultSet;
        String sql;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from actividades_proyecto.f_select_medios_dado_codigo_actividad(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, codigo);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                accion = new Medios_veri_actividades(); 
                accion.setCod_medios_veri_activida(resultSet.getInt("pcod_medio_veri_activida"));
                accion.setDes_medios_veri_activida(resultSet.getString("pdes_medios_veri_activida"));
                accion.setArchivo_medios_veri_activi(resultSet.getString("parchivo_medios_veri_activi"));
                accion.setCod_actividades(resultSet.getInt("pcod_actividades"));           
             
                lst.add(accion);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }

}

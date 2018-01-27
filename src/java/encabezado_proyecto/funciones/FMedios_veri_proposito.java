package encabezado_proyecto.funciones;

import accesoDatos.AccesoDatos;
import encabezado_proyecto.clases.Medios_veri_proposito;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FMedios_veri_proposito implements Serializable {

    public static String ingresarMedios_veri_proposito(Medios_veri_proposito medio) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from encabezado_proyecto.fi_medios_veri_proposito(?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, medio.getObserva_medios_veri_in());
            prstm.setInt(2, medio.getCod_in_proposito());
            prstm.setString(3, medio.getArchivo_medios_veri_prop());
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

    public static String actualizarMedios_veri_proposito(Medios_veri_proposito medio) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from encabezado_proyecto.fa_medios_veri_proposito(?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, medio.getObserva_medios_veri_in());
            prstm.setInt(2, medio.getCod_in_proposito());
            prstm.setString(3, medio.getArchivo_medios_veri_prop());
            prstm.setInt(4, medio.getCod_medios_veri_in());
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

    public static String eliminarMedios_veri_proposito(Medios_veri_proposito medio) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from encabezado_proyecto.fe_medios_veri_proposito(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, medio.getCod_medios_veri_in());
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

    public static ArrayList<Medios_veri_proposito> obtenerMediosDadoCodigoIndicadorProp(int codigo) throws Exception {
        ArrayList<Medios_veri_proposito> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        PreparedStatement prstm;
        Medios_veri_proposito accion;
        ResultSet resultSet;
        String sql;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from encabezado_proyecto.f_select_medios_dado_codigo_indicador(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, codigo);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                accion = new Medios_veri_proposito();
                accion.setCod_in_proposito(resultSet.getInt("pcod_in_proposito"));
                accion.setObserva_medios_veri_in(resultSet.getString("pobserva_medios_veri_in"));
                accion.setArchivo_medios_veri_prop(resultSet.getString("parchivo_medios_veri_prop"));

                lst.add(accion);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }
}

package encabezado_proyecto.funciones;

import accesoDatos.AccesoDatos;
import encabezado_proyecto.clases.Proposito;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FProposito implements Serializable {

    public static String ingresarProposito(Proposito proposito) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from encabezado_proyecto.fi_proposito(?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, proposito.getCod_proposito());
            prstm.setString(2, proposito.getDescripcion_proposito());
            prstm.setDouble(3, proposito.getCosto_proposito());
            prstm.setString(4, proposito.getSupuesto_proposito());

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

    public static String actualizarProposito(Proposito proposito) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from encabezado_proyecto.fa_proposito(?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, proposito.getDescripcion_proposito());
            prstm.setDouble(2, proposito.getCosto_proposito());
            prstm.setString(3, proposito.getSupuesto_proposito());
            prstm.setInt(4, proposito.getCod_proposito());
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

    public static String eliminarProposito(Proposito proposito) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from encabezado_proyecto.fe_proposito(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, proposito.getCod_proposito());
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
    
    public static ArrayList<Proposito> obtenerPropositoDadoCodigoProyecto(int codigo) throws Exception {
        ArrayList<Proposito> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        PreparedStatement prstm;
        Proposito accion;
        ResultSet resultSet;
        String sql;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from encabezado_proyecto.f_select_proposito_dado_codigo_proyecto(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, codigo);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                accion = new Proposito();                 
                accion.setDescripcion_proposito(resultSet.getString("pdescripcion_proposito"));
                accion.setCosto_proposito(resultSet.getDouble("pcosto_proposito"));
                accion.setSupuesto_proposito(resultSet.getString("psupuesto_proposito"));            
             
                lst.add(accion);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }
}

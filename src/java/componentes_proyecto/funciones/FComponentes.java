
package componentes_proyecto.funciones;

import accesoDatos.AccesoDatos;
import componentes_proyecto.clases.Componentes;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FComponentes implements Serializable {
    public static String ingresarComponentes(Componentes componentes) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from componentes_proyecto.fi_componentes(?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, componentes.getDescripcion_componente());
            prstm.setDouble(2, componentes.getCosto_componente());
            prstm.setString(3, componentes.getSupuestos_componentes());
            prstm.setInt(4, componentes.getCod_proposito());            
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
        public static String actualizarComponentes(Componentes componentes) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from componentes_proyecto.fa_componentes(?,?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, componentes.getDescripcion_componente());
            prstm.setDouble(2, componentes.getCosto_componente());
            prstm.setString(3, componentes.getSupuestos_componentes());
            prstm.setInt(4, componentes.getCod_proposito());  
            prstm.setInt(5, componentes.getCod_componentes());                          
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
        public static String eliminarComponentes(Componentes componentes) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from componentes_proyecto.fe_componentes(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, componentes.getCod_componentes());
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
        public static ArrayList<Componentes> obtenerComponenteDadoCodigoProyecto(int codigo) throws Exception {
        ArrayList<Componentes> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        PreparedStatement prstm;
        Componentes accion;
        ResultSet resultSet;
        String sql;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from componentes_proyecto.f_select_componente_dado_codigo_proyecto(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, codigo);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                accion = new Componentes();
                accion.setCod_componentes(resultSet.getInt("pcod_componentes"));
                accion.setDescripcion_componente(resultSet.getString("pdescripcion_componente"));
                accion.setCosto_componente(resultSet.getDouble("pcosto_componente"));
                accion.setSupuestos_componentes(resultSet.getString("psupuestos_componentes"));
                accion.setCod_proposito(resultSet.getInt("pcod_proyecto"));
                lst.add(accion);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }
}

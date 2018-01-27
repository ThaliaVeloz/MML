package encabezado_proyecto.funciones;

import accesoDatos.AccesoDatos;
import encabezado_proyecto.clases.Proposito;
import encabezado_proyecto.clases.Proyecto;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import master.logica.entidades.Accion;

public class FProyecto implements Serializable {

    public static String ingresarProyecto(Proyecto proyecto) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from encabezado_proyecto.fi_proyecto(?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, proyecto.getNombre_proyecto());
            prstm.setString(2, proyecto.getDescripcion_proyecto());
            prstm.setString(3, proyecto.getFin_proyecto());
            prstm.setInt(4, proyecto.getInt_id_usuario());
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

    public static String actualizarProyecto(Proyecto proyecto) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from encabezado_proyecto.fa_proyecto(?,?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, proyecto.getNombre_proyecto());
            prstm.setString(2, proyecto.getDescripcion_proyecto());
            prstm.setString(3, proyecto.getFin_proyecto());
            prstm.setInt(4, proyecto.getInt_id_usuario());
            prstm.setInt(5, proyecto.getCod_proyecto());
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

    public static String eliminarProyecto(Proyecto proyecto) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from encabezado_proyecto.fe_proyecto(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, proyecto.getCod_proyecto());
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

    public static ArrayList<Proyecto> obtenerProyectoDadoCodigoUsuario(int codigo) throws Exception {
        ArrayList<Proyecto> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        PreparedStatement prstm;
        Proyecto accion;
        ResultSet resultSet;
        String sql;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from encabezado_proyecto.f_select_proyecto_dado_codigo_usuario(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, codigo);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                accion = new Proyecto();
                accion.setCod_proyecto(resultSet.getInt("pcod_proyecto"));
                accion.setNombre_proyecto(resultSet.getString("pnombre_proyecto"));
                accion.setDescripcion_proyecto(resultSet.getString("pdescripcion_proyecto"));
                accion.setFin_proyecto(resultSet.getString("pfin_proyecto"));

                lst.add(accion);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }

    public static String ingresarProyectoProposito(Proyecto proyecto, Proposito proposito) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from encabezado_proyecto.f_insertar_proy_prop(?,?,?,?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, proyecto.getNombre_proyecto());
            prstm.setString(2, proyecto.getDescripcion_proyecto());
            prstm.setString(3, proyecto.getFin_proyecto());
            prstm.setInt(4, proyecto.getInt_id_usuario());
            prstm.setString(5, proposito.getDescripcion_proposito());
            prstm.setDouble(6, proposito.getCosto_proposito());
            prstm.setString(7, proposito.getSupuesto_proposito());
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

}

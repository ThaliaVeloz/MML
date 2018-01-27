/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividades_proyecto.funciones;

import accesoDatos.AccesoDatos;
import actividades_proyecto.clases.Actividades;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author WinUser
 */
public class FActividades implements Serializable {

    public static String ingresarActividades(Actividades actividad) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from actividades_proyecto.fi_actividades(?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, actividad.getDescripcion_actividad());
            prstm.setString(2, actividad.getSupuesto_actividado());
            prstm.setDouble(3, actividad.getCosto_actividad());
            prstm.setInt(4, actividad.getCod_componentes());
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

    public static String actualizarActividades(Actividades actividad) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from actividades_proyecto.fa_actividades(?,?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, actividad.getDescripcion_actividad());
            prstm.setString(2, actividad.getSupuesto_actividado());
            prstm.setDouble(3, actividad.getCosto_actividad());
            prstm.setInt(4, actividad.getCod_componentes());
            prstm.setInt(5, actividad.getCod_actividad());
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

    public static String eliminarActividades(Actividades actividad) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from actividades_proyecto.fe_actividades(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, actividad.getCod_actividad());
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

    public static ArrayList<Actividades> obtenerActividadDadoCodigoComponente(int codigo) throws Exception {
        ArrayList<Actividades> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        PreparedStatement prstm;
        Actividades accion;
        ResultSet resultSet;
        String sql;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from actividades_proyecto.f_select_actividades_dado_codigo_componente(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, codigo);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                accion = new Actividades();
                accion.setCod_actividad(resultSet.getInt("pcod_actividad"));
                accion.setDescripcion_actividad(resultSet.getString("pdescripcion_actividado"));
                accion.setSupuesto_actividado(resultSet.getString("psupuestos_actividad"));
                accion.setCosto_actividad(resultSet.getDouble("pcosto_actividad"));
                accion.setCod_componentes(resultSet.getInt("pcod_componentes"));
                lst.add(accion);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes_proyecto.funciones;

import accesoDatos.AccesoDatos;
import componentes_proyecto.clases.Indicadores_componentes;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author WinUser
 */
public class FIndicadores_componentes implements Serializable {

    public static String ingresarIndicadores_componentes(Indicadores_componentes componentes) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from componentes_proyecto.fi_indicadores_componentes(?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, componentes.getDes_in_componentes());
            prstm.setInt(2, componentes.getCantidad_in_componentes());
            prstm.setInt(3, componentes.getCod_componentes());
            prstm.setString(4, componentes.getTipo_cantidad_componentes());
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

    public static String actualizarIndicadores_componentes(Indicadores_componentes componentes) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from componentes_proyecto.fa_indicadores_componentes(?,?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, componentes.getDes_in_componentes());
            prstm.setInt(2, componentes.getCantidad_in_componentes());
            prstm.setInt(3, componentes.getCod_componentes());
            prstm.setString(4, componentes.getTipo_cantidad_componentes());
            prstm.setInt(5, componentes.getCod_in_componentes());
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

    public static String eliminarIndicadores_componentes(Indicadores_componentes componentes) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from componentes_proyecto.fe_indicadores_componentes(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, componentes.getCod_in_componentes());
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

    public static ArrayList<Indicadores_componentes> obtenerIndicadorDadoCodigoComponente(int codigo) throws Exception {
        ArrayList<Indicadores_componentes> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        PreparedStatement prstm;
        Indicadores_componentes accion;
        ResultSet resultSet;
        String sql;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from componentes_proyecto.f_select_indicador_dado_codigo_componente(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, codigo);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                accion = new Indicadores_componentes();
                accion.setCod_in_componentes(resultSet.getInt("pcod_in_componentes"));
                accion.setDes_in_componentes(resultSet.getString("pdes_in_componentes"));
                accion.setCantidad_in_componentes(resultSet.getInt("pcantidad_in_componente"));
                accion.setTipo_cantidad_componentes(resultSet.getString("ptipo_cantidad_componentes"));
                accion.setCod_componentes(resultSet.getInt("pcod_componentes"));
                lst.add(accion);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }
}

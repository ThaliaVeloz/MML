/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encabezado_proyecto.funciones;

import accesoDatos.AccesoDatos;
import encabezado_proyecto.clases.Indicadores_proposito;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author WinUser
 */
public class FIndicadores_proposito implements Serializable {
    
    public static String ingresarIndicadores_proposito(Indicadores_proposito proposito) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from encabezado_proyecto.fi_indicadores_proposito_2(?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, proposito.getDes_in_proposito());
            prstm.setInt(2, proposito.getCantidad_in_proposito());
            prstm.setInt(3, proposito.getCod_proposito());
            prstm.setString(4, proposito.getTipo_cantidad_proposito());
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
    
    public static String actualizarIndicadores_proposito(Indicadores_proposito proposito) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from encabezado_proyecto.fa_indicadores_proposito_2(?,?,?,?,?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setString(1, proposito.getDes_in_proposito());
            prstm.setInt(2, proposito.getCantidad_in_proposito());
            prstm.setInt(3, proposito.getCod_proposito());
            prstm.setString(4, proposito.getTipo_cantidad_proposito());
            prstm.setInt(5, proposito.getCod_in_proposito());
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
    
    public static String eliminarIndicadores_proposito(Indicadores_proposito proposito) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from encabezado_proyecto.fe_indicadores_proposito(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, proposito.getCod_in_proposito());
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
    
    public static ArrayList<Indicadores_proposito> obtenerIndicadorDadoCodigoProposito(int codigo) throws Exception {
        ArrayList<Indicadores_proposito> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        PreparedStatement prstm;
        Indicadores_proposito accion;
        ResultSet resultSet;
        String sql;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from encabezado_proyecto.f_select_indicadores_dado_codigo_proposito(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, codigo);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                accion = new Indicadores_proposito();
                accion.setCod_in_proposito(resultSet.getInt("pcod_in_proposito"));
                accion.setDes_in_proposito(resultSet.getString("pdes_in_proposito"));
                accion.setCantidad_in_proposito(resultSet.getInt("pcantidad_in_proposito"));
                accion.setTipo_cantidad_proposito(resultSet.getString("ptipo_cantidad_proposito"));
                accion.setCod_proposito(resultSet.getInt("pcod_proposito"));
                
                lst.add(accion);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }
    
    
    public static String eliminarIndicadoresProposito(int idIndicador) throws Exception {
        String respuesta;
        AccesoDatos accesoDatos;
        String sql;
        PreparedStatement prstm;
        ResultSet resultSet;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from encabezado_proyecto.f_eliminacion_indicadores_prop(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, idIndicador);
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

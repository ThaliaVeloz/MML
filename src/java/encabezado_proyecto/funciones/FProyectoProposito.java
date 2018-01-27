/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encabezado_proyecto.funciones;

import accesoDatos.AccesoDatos;
import encabezado_proyecto.clases.ProyectoProposito;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author WinUser
 */
public class FProyectoProposito {

    public static ArrayList<ProyectoProposito> obtenerProyectoPropositoDadoCodigoUsuario(int codigo) throws Exception {
        ArrayList<ProyectoProposito> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        PreparedStatement prstm;
        ProyectoProposito proyectoProp;
        ResultSet resultSet;
        String sql;
        try {
            accesoDatos = new AccesoDatos();
            sql = "select * from encabezado_proyecto.f_obtener_proyecto_prop_dado_usuario(?)";
            prstm = accesoDatos.creaPreparedSmt(sql);
            prstm.setInt(1, codigo);
            resultSet = accesoDatos.ejecutaPrepared(prstm);
            while (resultSet.next()) {
                proyectoProp = new ProyectoProposito();

                proyectoProp.getProyecto().setNombre_proyecto(resultSet.getString("nombre_proyecto"));
                proyectoProp.getProyecto().setDescripcion_proyecto(resultSet.getString("descripcion_proyecto"));
                proyectoProp.getProyecto().setFin_proyecto(resultSet.getString("fin_proyecto"));
                proyectoProp.getProposito().setDescripcion_proposito(resultSet.getString("descripcion_proposito"));
                proyectoProp.getProposito().setCosto_proposito(resultSet.getDouble("costo_proposito"));
                proyectoProp.getProposito().setSupuesto_proposito(resultSet.getString("supuesto_proposito"));

                lst.add(proyectoProp);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }
}

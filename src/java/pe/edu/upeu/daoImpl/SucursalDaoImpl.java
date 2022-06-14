/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.config.Conexion;
import pe.edu.upeu.dao.SucursalDao;
import pe.edu.upeu.model.Sucursal;

/**
 *
 * @author HP
 */
public class SucursalDaoImpl implements SucursalDao {

    private PreparedStatement preparedStatement;
    private ResultSet resultset;
    private Connection conexion;

    @Override
    public List<Sucursal> listarSucursales() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String SQL = "SELECT * FROM sucursales";

        List<Sucursal> sucursales = new ArrayList<Sucursal>(10);

        try {

            conexion = Conexion.getConexion();
            preparedStatement = conexion.prepareStatement(SQL);
            resultset = preparedStatement.executeQuery();

            while (resultset.next()) {

                Sucursal sucursal = new Sucursal();
                sucursal.setIdSucursal(resultset.getInt("idSucursal"));
                sucursal.setNombreSucursal(resultset.getString("nombreSucursal"));
                sucursal.setDireccionSucursal(resultset.getString("direccionSucursal"));
                sucursal.setEstadoSucursal(resultset.getBoolean("estadoSucursal"));
                sucursales.add(sucursal);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return sucursales;
    }
}

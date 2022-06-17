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
import pe.edu.upeu.dao.VendedoresDao;
import pe.edu.upeu.dtos.VendedoresDto;

/**
 *
 * @author HP
 */
public class VendedoresDaoImpl implements VendedoresDao {

    private PreparedStatement preparedStatement;
    private ResultSet resultset;
    private Connection conexion;

    @Override
    public List<VendedoresDto> listarVendedores() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String SQL = "SELECT p.idPersona, p.nombrePersona, p.apellidoPersona, p.dniPersona, p.telefonoPersona, r.nombreRol FROM personas p JOIN empleados e ON p.idPersona=e.idPersona JOIN usuarios u ON e.idEmpleado=u.idEmpleado JOIN roles r ON r.idRol=u.idRol WHERE r.nombreRol='vendedor'";
        List<VendedoresDto> vendedores = new ArrayList<VendedoresDto>(10);

        try {

            conexion = Conexion.getConexion();
            preparedStatement = conexion.prepareStatement(SQL);
            resultset = preparedStatement.executeQuery();

            while (resultset.next()) {

                VendedoresDto vendedor = new VendedoresDto();
                vendedor.setIdPersona(resultset.getInt("idPersona"));
                vendedor.setNombrePersonas(resultset.getString("nombrePersona"));
                vendedor.setApellidoPersonas(resultset.getString("apellidoPersona"));
                vendedor.setDniPersonas(resultset.getString("dniPersona"));
                vendedor.setTelefonoPersonas(resultset.getString("dniPersona"));
                vendedor.setNombreRoles(resultset.getString("nombreRol"));
                vendedores.add(vendedor);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return vendedores;
    }

}

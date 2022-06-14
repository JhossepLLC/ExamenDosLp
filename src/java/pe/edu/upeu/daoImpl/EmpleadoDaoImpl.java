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
import pe.edu.upeu.dao.EmpleadoDao;
import pe.edu.upeu.dtos.EmpleadoDto;
import pe.edu.upeu.model.Empleado;

/**
 *
 * @author HP
 */
public class EmpleadoDaoImpl implements EmpleadoDao {

    private PreparedStatement preparedStatement;
    private ResultSet resultset;
    private Connection conexion;

    @Override
    public List<EmpleadoDto> listarEmpleados() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String SQL = "SELECT * FROM empleados e, personas p WHERE e.idPersona = p.idPersona";

        List<EmpleadoDto> empleados = new ArrayList<EmpleadoDto>(10);

        try {

            conexion = Conexion.getConexion();
            preparedStatement = conexion.prepareStatement(SQL);
            resultset = preparedStatement.executeQuery();

            while (resultset.next()) {

                EmpleadoDto empleado = new EmpleadoDto();
                empleado.setIdEmpleado(resultset.getInt("idEmpleado"));
                empleado.setCargoEmpleados(resultset.getString("cargoEmpleado"));
                empleado.setIdPersona(resultset.getInt("idPersona"));
                empleado.setNombrePersonas(resultset.getString("nombrePersona"));
                empleado.setApellidoPersonas(resultset.getString("apellidoPersona"));
                empleado.setDniPersonas(resultset.getString("dniPersona"));
                empleado.setTelefonoPersonas(resultset.getString("telefonoPersona"));
                empleados.add(empleado);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return empleados;
    }

}

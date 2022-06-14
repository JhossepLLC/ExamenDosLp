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
import pe.edu.upeu.dao.ClienteDao;
import pe.edu.upeu.dtos.ClienteDto;
import pe.edu.upeu.dtos.EmpleadoDto;
import pe.edu.upeu.model.Cliente;

/**
 *
 * @author HP
 */
public class ClienteDaoImpl implements ClienteDao {

    private PreparedStatement preparedStatement;
    private ResultSet resultset;
    private Connection conexion;

    @Override
    public List<ClienteDto> listarCliente() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String SQL = "SELECT * FROM empleados e, personas p WHERE e.idPersona = p.idPersona";

        List<ClienteDto> empleados = new ArrayList<ClienteDto>(10);

        try {

            conexion = Conexion.getConexion();
            preparedStatement = conexion.prepareStatement(SQL);
            resultset = preparedStatement.executeQuery();

            while (resultset.next()) {

                ClienteDto cliente = new ClienteDto();
                cliente.setIdCliente(resultset.getInt("idCliente"));
                empleados.add(cliente);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return empleados;
    }

}

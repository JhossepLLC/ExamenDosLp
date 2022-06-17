/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pe.edu.upeu.config.Conexion;
import pe.edu.upeu.dao.DetalleDao;
import pe.edu.upeu.model.Detalle;
import pe.edu.upeu.model.Venta;

/**
 *
 * @author HP
 */
public class DetalleDaoImpl implements DetalleDao {

    private PreparedStatement preparedStatement;
    private ResultSet resultset;
    private Connection conexion;

    @Override
    public List<Map<String, Object>> listarDetalles() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //StringBuilder SQL = "SELECT s.nombreSucursal as sucursal, concat(p.nombrePersona, ' ', p.apellidoPersona) as vendedor, concat(p.nombrePersona, ' ', p.apellidoPersona) as clientes, v.fechaVenta as fecha FROM ventas v, sucursales s, usuarios u, empleados e, personas p, clientes c WHERE v.idSucursal = s.idSucursal AND v.idUsuario = u.idUsuario AND u.idEmpleado = e.idEmpleado AND e.idPersona = p.idPersona AND c.idPersona = p.idPersona AND c.idCliente = ? AND s.idSucursal = ? AND u.idUsuario = ?";
        StringBuilder query = new StringBuilder();
        query.append("select ");
        query.append("v.idVenta, su.nombreSucursal as sucursales, ");
        query.append("concat(p1.nombrePersona,' ',p1.apellidoPersona) as empleados, ");
        query.append("concat(p2.nombrePersona, ' ',p2.apellidoPersona) as clientes, ");
        query.append("v.fechaventa as fecha ");
        query.append("from  ");
        query.append("ventas as v inner join sucursales as su on v.idSucursal = su.idSucursal ");
        query.append("inner join clientes as c on v.idCliente=c.idCliente ");
        query.append("inner join usuarios as u on v.idUsuario=u.idUsuario ");
        query.append("inner join empleados as e on u.idEmpleado=e.idEmpleado ");
        query.append("inner join personas as p1 on e.idPersona=p1.idPersona ");
        query.append("inner join personas as p2 on c.idPersona=p2.idPersona ");
        
        List<Map<String, Object>> detalles = new ArrayList<>();
        try {
            conexion = Conexion.getConexion();
            preparedStatement = conexion.prepareStatement(query.toString());
            resultset = preparedStatement.executeQuery();
            
            while (resultset.next()) {

                Map<String, Object> detalle = new HashMap<>();
                detalle.put("nombreCliente", resultset.getString("clientes"));
                detalle.put("nombreEmpleados", resultset.getString("empleados"));
                detalle.put("nombreSucursales", resultset.getString("sucursales"));                
                detalle.put("fechaVentas", resultset.getString("fecha"));
                detalles.add(detalle);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return detalles;
    }
     
    
    /**
     * metodo que crea en la tabla venta y retornará el 
     * id de la base de datos
     * @param producto objeto completo de la venta
     * @return id genereado por base de datos 
     */
    @Override
    public int crearVenta(Venta producto) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String SQL = "insert into ventas(fechaVenta, idUsuario, idCliente, idSucursal) values(now(),?,?,?)";
        int resultado = 0;
        try {

            conexion = Conexion.getConexion();
            preparedStatement = conexion.prepareStatement(SQL, preparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, producto.getIdUsuario());
            preparedStatement.setInt(2, producto.getIdCliente());
            preparedStatement.setInt(3, producto.getIdSucursal());

            preparedStatement.executeUpdate();
            resultset = preparedStatement.getGeneratedKeys();
            while(resultset.next()){
                resultado = resultset.getInt(1);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public int crearDetalleVenta(int idVenta, Detalle detalles) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String SQL = "insert into detalles(idVenta, idProducto, precioDetalle, cantidadDetalle) values(?,?,?,?)";
        int resultado = 0;
        try {

            conexion = Conexion.getConexion();
            preparedStatement = conexion.prepareStatement(SQL);

            preparedStatement.setInt(1, idVenta);
            preparedStatement.setInt(2, detalles.getIdProducto());
            preparedStatement.setDouble(3, detalles.getPrecioDetalle());
            preparedStatement.setInt(4, detalles.getCantidadDetalle());
            
            resultado = preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return resultado;
    }
}

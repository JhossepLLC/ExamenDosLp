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
import pe.edu.upeu.model.Producto;
import pe.edu.upeu.dao.ProductoDao;
import pe.edu.upeu.dtos.ProductoDto;

/**
 *
 * @author HP
 */
public class ProductoDaoImpl implements ProductoDao {

    private PreparedStatement preparedStatement;
    private ResultSet resultset;
    private Connection conexion;


    @Override
    public List<ProductoDto> listarProductos() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String SQL = "SELECT * FROM productos p, categorias c WHERE p.idCategoria = c.idCategoria";
        
        List<ProductoDto> productos = new ArrayList<ProductoDto>(10);

        try {

            conexion = Conexion.getConexion();
            preparedStatement = conexion.prepareStatement(SQL);
            resultset = preparedStatement.executeQuery();

            while (resultset.next()) {

                ProductoDto producto = new ProductoDto();
                producto.setIdProducto(resultset.getInt("idProducto"));
                producto.setNombreProductos(resultset.getString("nombreProducto"));
                producto.setPrecioProductos(resultset.getDouble("precioProducto"));
                producto.setStockProductos(resultset.getDouble("stockProducto"));
                producto.setEstadoProductos(resultset.getBoolean("estadoProducto"));
                producto.setIdCategoria(resultset.getInt("idCategoria"));
                producto.setNombreCategorias(resultset.getString("nombreCategoria"));
                producto.setEstadoCategorias(resultset.getBoolean("estadoCategoria"));
                productos.add(producto);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return productos;
    }

}

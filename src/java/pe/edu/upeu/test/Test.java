/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.test;

import com.google.gson.Gson;
import pe.edu.upeu.config.Conexion;
import pe.edu.upeu.dao.CategoriaDao;
import pe.edu.upeu.dao.ClienteDao;
import pe.edu.upeu.dao.DetalleDao;
import pe.edu.upeu.dao.EmpleadoDao;
import pe.edu.upeu.dao.ProductoDao;
import pe.edu.upeu.dao.VendedoresDao;
import pe.edu.upeu.dao.VentaDao;
import pe.edu.upeu.daoImpl.CategoriaDaoImpl;
import pe.edu.upeu.daoImpl.ClienteDaoImpl;
import pe.edu.upeu.daoImpl.DetalleDaoImpl;
import pe.edu.upeu.daoImpl.EmpleadoDaoImpl;
import pe.edu.upeu.daoImpl.ProductoDaoImpl;
import pe.edu.upeu.daoImpl.VendedoresDaoImpl;
import pe.edu.upeu.daoImpl.VentaDaoImpl;
import pe.edu.upeu.model.Detalle;
import pe.edu.upeu.model.Venta;

/**
 *
 * @author HP
 */
public class Test {

    static Gson gson = new Gson();
    static DetalleDao detalleDao = new DetalleDaoImpl();
    
    public static void main(String[] args) {
        Venta ventaNuevas = new Venta();
        ventaNuevas.setIdCliente(1);
        ventaNuevas.setIdSucursal(1);
        ventaNuevas.setIdUsuario(1);
        int idVentaCreada = detalleDao.crearVenta(ventaNuevas);
        Detalle detalleVentaNueva = new Detalle();
        detalleVentaNueva.setIdProducto(3);
        detalleVentaNueva.setCantidadDetalle(2);
        detalleVentaNueva.setPrecioDetalle(50.0);
        detalleDao.crearDetalleVenta(idVentaCreada, detalleVentaNueva);
    }
}

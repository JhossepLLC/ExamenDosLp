/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.test;

import com.google.gson.Gson;
import pe.edu.upeu.config.Conexion;
import pe.edu.upeu.dao.ClienteDao;
import pe.edu.upeu.dao.DetalleDao;
import pe.edu.upeu.dao.EmpleadoDao;
import pe.edu.upeu.dao.ProductoDao;
import pe.edu.upeu.dao.VentaDao;
import pe.edu.upeu.daoImpl.ClienteDaoImpl;
import pe.edu.upeu.daoImpl.DetalleDaoImpl;
import pe.edu.upeu.daoImpl.EmpleadoDaoImpl;
import pe.edu.upeu.daoImpl.ProductoDaoImpl;
import pe.edu.upeu.daoImpl.VentaDaoImpl;

/**
 *
 * @author HP
 */
public class Test {
    static Gson gson = new Gson();
    static ProductoDao productoDao = new ProductoDaoImpl();
    static ClienteDao clienteDao = new ClienteDaoImpl();
    static DetalleDao detalleDao = new DetalleDaoImpl();
    static EmpleadoDao empleadoDao = new EmpleadoDaoImpl();
    static VentaDao ventaDao = new VentaDaoImpl();
    
    public static void main(String[] args) {
        System.out.println(gson.toJson(productoDao.listarProductos()));
        /*System.out.println(gson.toJson(clienteDao.listarCliente()));
        System.out.println(gson.toJson(empleadoDao.listarEmpleados()));*/
          
        if (Conexion.getConexion() != null) {
            System.out.println("si");
        } else {
            System.out.println("no");
        }
    }
}

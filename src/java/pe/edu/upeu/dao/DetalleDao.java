/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.dao;

import java.util.List;
import java.util.Map;
import pe.edu.upeu.model.Detalle;
import pe.edu.upeu.model.Venta;

/**
 *
 * @author HP
 */
public interface DetalleDao {
    List<Map<String,Object> > listarDetalles();
    int crearVenta(Venta producto);
    int crearDetalleVenta(int idVenta, Detalle detalles);
    
    List<Map<String, Object>> listarDetalleVenta(int idVentas);
    
}

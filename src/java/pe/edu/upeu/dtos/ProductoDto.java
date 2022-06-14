/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author HP
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
    private Integer idProducto;
    private String nombreProductos;
    private Double precioProductos;
    private Double stockProductos;
    private Boolean estadoProductos;
    private Integer idCategoria;
    private String nombreCategorias;
    private Boolean estadoCategorias;
}

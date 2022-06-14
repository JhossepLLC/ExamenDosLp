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
public class VentaDto {
    private Integer idVenta;
    private Integer fechaVentas;
    private Integer idUsuarios;
    private String nombreUsuarios;
    private Integer passwordUsuarios;
    private Boolean estadoUsuarios;
    private Integer idCliente;
    private String direccionClientes;
    private String hobbyClientes;
    private String correoClientes;
    private Integer idSucursal;
    private String nombreSucursales;
    private String direccionSucursales;
    private Boolean estadoSucursales;
}

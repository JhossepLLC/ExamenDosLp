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
public class VendedoresDto {
    private Integer idPersona;
    private String nombrePersonas;
    private String apellidoPersonas;
    private String dniPersonas;
    private String telefonoPersonas;
    private Integer idEmpleado; 
    private String cargoEmpleados;
    private Integer idUsuario;
    private String nombreUsuarios;
    private Integer passwordUsuarios;
    private Boolean estadoUsuarios;
    private Integer idRol;
    private String nombreRoles;
    private Boolean estadoRoles;
}

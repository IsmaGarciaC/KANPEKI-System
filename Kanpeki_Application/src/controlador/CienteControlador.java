/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Cliente;

/**
 *
 * @author Ismael
 */
public class CienteControlador {
    Conexion con = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    Statement sentencia;
    
    Cliente cliente = new Cliente();

    public CienteControlador() {
        con.getConector();
    }
    
    public void crearCliente (Cliente c) {
    
        try {
            String sql = "INSERT INTO Cliente (id, nombre, apellido, cedula, edad, direccion, genero)"
                    + "VALUES ( "+c.getId() + ",'" +c.getNombre() + "','" +c.getApellido() + "','" +c.getCedula()+ "','" +c.getEdad()+ "','" +c.getDireccion()+ "','" 
                    +c.getGenero()+"');";
            
            
            sentencia= con.getConector().createStatement();
            
            if (sentencia.executeUpdate(sql) > 0) {
                System.out.println("El registro se inserto correctamente");
    
            }
            else{
            
                System.out.println("No se pudo insertar el registro");
            
            }
        } catch (SQLException e) {
            
            System.out.println("Error" + " " + e);
        }
        
        System.out.println(c.toString());
        con.cerrar();
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

import java.sql.Date;

/**
 *
 * @author paula
 */
public class IngredienteValidator {
    
    public static boolean validateNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public static boolean validateCategoria(String categoria) {
        return categoria != null && !categoria.trim().isEmpty();
    }

    public static boolean validateCantidad(double cantidad) {
        return cantidad > 0;
    }

    public static boolean validateFecha(Date fecha) {
        return fecha != null && fecha.after(new Date(System.currentTimeMillis()));
    }
}

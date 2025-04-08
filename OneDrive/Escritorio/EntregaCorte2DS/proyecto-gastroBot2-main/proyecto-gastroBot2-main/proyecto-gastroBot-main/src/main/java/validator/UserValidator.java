/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

/**
 *
 * @author Carolina
 */
public class UserValidator {
    public static boolean validateNombre(String nombre){
        return nombre != null && !nombre.trim().isEmpty();
    }
    
    public static boolean validateCorreo(String correo){
        return correo != null && correo.contains("@");
    }
    
   public static boolean validateContraseña(String contraseña) {
    return contraseña != null && contraseña.matches("\\d{6,}");
}
}


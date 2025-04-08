/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

/**
 *
 * @author paula
 */
public class ListaCompraValidator {
    public static boolean validateIngredientes(String ingredientes) {
        return ingredientes != null && !ingredientes.trim().isEmpty();
    }
}

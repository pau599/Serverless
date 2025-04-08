/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

/**
 *
 * @author paula
 */
public class RecetaValidator {
    public static boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public static boolean validarIngredientes(String ingredientes) {
        return ingredientes != null && !ingredientes.trim().isEmpty();
    }

    public static boolean validarPasos(String pasos) {
        return pasos != null && !pasos.trim().isEmpty();
    }

    public static boolean validarProteinas(String proteinasSeleccionadas) {
        return proteinasSeleccionadas != null && !proteinasSeleccionadas.trim().isEmpty();
    }
}
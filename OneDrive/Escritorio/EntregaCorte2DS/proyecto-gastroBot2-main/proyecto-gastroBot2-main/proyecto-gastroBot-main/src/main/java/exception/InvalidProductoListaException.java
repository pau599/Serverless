/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author paula
 */

public class InvalidProductoListaException extends Exception {
    public InvalidProductoListaException(String mensaje) {
        super(mensaje);
    }
}
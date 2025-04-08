/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

import dto.ProductoListaDTO;

/**
 *
 * @author paula
 */
public class ProductoListaValidator {

    public static boolean validarNombreProducto(String nombreProducto) {
        return nombreProducto != null && !nombreProducto.trim().isEmpty() && nombreProducto.length() <= 255;
    }

    public static boolean validarIdListaCompra(int idListaCompra) {
        return idListaCompra > 0;
    }

    public static boolean validarProductoLista(ProductoListaDTO producto) {
        return validarNombreProducto(producto.getNombreProducto()) &&
               validarIdListaCompra(producto.getIdListaCompra());
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;



import Repository.ProductoListaRepository;
import dto.ProductoListaDTO;
import exception.InvalidProductoListaException;

import java.sql.SQLException;
import java.util.List;
import validator.ProductoListaValidator;


/**
 *
 * @author Carolina
 */


public class ProductoListaService {

    private ProductoListaRepository repository = new ProductoListaRepository();

    public void agregarProducto(ProductoListaDTO producto) throws SQLException, InvalidProductoListaException {
        if (!ProductoListaValidator.validarProductoLista(producto)) {
            throw new InvalidProductoListaException("Producto inválido");
        }
        repository.save(producto);
    }

    public void editarProducto(ProductoListaDTO producto) throws SQLException, InvalidProductoListaException {
        if (!ProductoListaValidator.validarProductoLista(producto)) {
            throw new InvalidProductoListaException("Producto inválido");
        }
        repository.update(producto);
    }

    public void eliminarProducto(int idProducto) throws SQLException {
        repository.delete(idProducto);
    }

    public List<ProductoListaDTO> obtenerProductosPorLista(int idListaCompra) throws SQLException {
        return repository.findByListaCompraId(idListaCompra);
    }
}
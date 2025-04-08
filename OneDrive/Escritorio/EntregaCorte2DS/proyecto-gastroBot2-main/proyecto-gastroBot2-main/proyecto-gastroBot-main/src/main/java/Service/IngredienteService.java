/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;


import Repository.IngredienteRepository;
import dto.IngredienteDTO;
import exception.InvalidUserDataException;
import java.sql.SQLException;
import validator.IngredienteValidator;

/**
 *
 * @author Carolina
 */
public class IngredienteService {
    
    private IngredienteRepository repository = new IngredienteRepository();

    public void createIngrediente(int idIngrediente, String nombre, String categoria, java.sql.Date fechaVencimiento, double cantidad, int idUsuario) throws SQLException, InvalidUserDataException {
        if (!IngredienteValidator.validateNombre(nombre) || 
            !IngredienteValidator.validateCategoria(categoria) || 
            !IngredienteValidator.validateCantidad(cantidad) || 
            !IngredienteValidator.validateFecha(fechaVencimiento)) {
            throw new InvalidUserDataException("Datos inválidos del ingrediente.");
        }

        IngredienteDTO ingrediente = new IngredienteDTO(idIngrediente, nombre, categoria, fechaVencimiento, cantidad, idUsuario);
        repository.save(ingrediente);
    }

    public IngredienteDTO getIngredienteById(int idIngrediente) throws SQLException {
        return repository.findById(idIngrediente);
    }
}

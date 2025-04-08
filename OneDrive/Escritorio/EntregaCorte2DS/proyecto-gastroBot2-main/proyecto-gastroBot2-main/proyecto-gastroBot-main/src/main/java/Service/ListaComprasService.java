/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Repository.ListaCompraRepository;
import dataBaseConfig.DatabaseConfig;
import dto.ListaCompraDTO;
import exception.InvalidUserDataException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import validator.ListaCompraValidator;

/**
 *
 * @author Carolina
 */
public class ListaComprasService {
    private ListaCompraRepository repository = new ListaCompraRepository();

   private int obtenerIdUsuarioPorCorreo(String correo) throws SQLException {
        int idUsuario = -1;
        String query = "SELECT idUsuario FROM Usuario WHERE correo = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, correo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    idUsuario = rs.getInt("idUsuario");
                }
            }
        }

        return idUsuario;
    }

   public void createListaCompra(int idListaCompra, String correoUsuario, String ingredientes) throws SQLException, InvalidUserDataException {
        if (!ListaCompraValidator.validateIngredientes(ingredientes)) {
            throw new InvalidUserDataException("Los ingredientes no pueden estar vacíos.");
        }

        int idUsuario = obtenerIdUsuarioPorCorreo(correoUsuario);
        if (idUsuario == -1) {
            throw new SQLException("Usuario no encontrado con el correo: " + correoUsuario);
        }

        ListaCompraDTO dto = new ListaCompraDTO(idListaCompra, idUsuario, ingredientes);
        repository.save(dto);
    }

    public ListaCompraDTO getListaCompraById(int idListaCompra) throws SQLException {
        return repository.findById(idListaCompra);
    }
}

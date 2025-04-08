/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import dataBaseConfig.DatabaseConfig;
import dto.IngredienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Carolina
 */
public class IngredienteRepository {
    
    public IngredienteDTO findById(int idIngrediente) throws SQLException {
    String query = "SELECT * FROM ingrediente WHERE idingrediente = ?"; 
    
    try (Connection connection = DatabaseConfig.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {
        
        
        statement.setInt(1, idIngrediente);
        
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return new IngredienteDTO(
                    resultSet.getInt("idingrediente"),
                    resultSet.getString("nombre"),
                    resultSet.getString("categoria"), 
                    resultSet.getDate("fechaVencimiento"),
                    resultSet.getDouble("cantidad"),
                    resultSet.getInt("idusuario")  
                );  
            } else {
                return null;
            }
        }
    }
}
    
    public void save(IngredienteDTO ingrediente) throws SQLException {
    String query = "INSERT INTO Ingrediente (nombre, categoria, fecha_vencimiento, cantidad, idUsuario) " +
                   "VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = DatabaseConfig.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, ingrediente.getNombre());
        stmt.setString(2, ingrediente.getCategoria());
        stmt.setDate(3, ingrediente.getFechaVencimiento());
        stmt.setDouble(4, ingrediente.getCantidad());
        stmt.setInt(5, ingrediente.getIdUsuario());

        stmt.executeUpdate();
    }
}
}

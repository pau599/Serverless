/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import dataBaseConfig.DatabaseConfig;
import dto.RecetaDTO;
import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Carolina
 */
public class RecetaRepository {

    public RecetaDTO findByNombre(String nombre) throws SQLException {
        String query = "SELECT * FROM receta WHERE nombre_receta = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nombre);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new RecetaDTO(
                        resultSet.getString("nombre_receta"),
                        resultSet.getString("descripcion"),
                        resultSet.getString("dificultad"),
                        resultSet.getInt("tiempo_preparacion")
                );
            } else {
                return null;
            }
        }
    }

    public void save(RecetaDTO receta) throws SQLException {
        String query = "INSERT INTO Receta (nombre_receta, descripcion, dificultad, tiempo_preparacion) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, receta.getNombreReceta());
            statement.setString(2, receta.getDescripcion());
            statement.setString(3, receta.getDificultad());
            statement.setInt(4, receta.getTiempoPreparacion());

            statement.executeUpdate();
        }
    }
}
   
    


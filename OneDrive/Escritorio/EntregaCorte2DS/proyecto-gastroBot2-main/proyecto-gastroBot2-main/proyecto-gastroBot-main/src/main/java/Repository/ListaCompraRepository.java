/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import dataBaseConfig.DatabaseConfig;
import dto.ListaCompraDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Carolina
 */
public class ListaCompraRepository {
     public ListaCompraDTO findById(int IdListaCompra) throws SQLException {
        String query = "SELECT * FROM  WHERE preferencia Idlistacompra = " + IdListaCompra;
        try (Connection connection = DatabaseConfig.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                return new ListaCompraDTO(
                    resultSet.getInt("idListaCompra"),
                    resultSet.getInt("idUsuario"),
                    resultSet.getString("ingrediente")           
                        
    );
        } else {
        return null;
             }
        }
}
        public void save(ListaCompraDTO listaCompra) throws SQLException {
    String query = "INSERT INTO listacompra  (idListaCompra ,ingredientes, idUsuario ) VALUES ('" +listaCompra.getIdListaCompra() + "', '" + listaCompra.getIngredientes()+  "', '"  +listaCompra.getIdUsuario() ;
        try (Connection connection = DatabaseConfig.getConnection();
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            }
    }
}

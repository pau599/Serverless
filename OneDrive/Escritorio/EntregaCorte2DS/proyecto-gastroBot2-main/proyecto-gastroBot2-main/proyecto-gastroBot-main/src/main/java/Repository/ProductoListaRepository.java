/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import dataBaseConfig.DatabaseConfig;
import dto.ProductoListaDTO;

import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carolina
 */
public class ProductoListaRepository {



    public void save(ProductoListaDTO producto) throws SQLException {

        String query = "INSERT INTO ProductoLista (nombre_producto, precio_producto, idListaCompra) " +

                       "VALUES (?, ?, ?)";



        try (Connection conn = DatabaseConfig.getConnection();

             PreparedStatement stmt = conn.prepareStatement(query)) {



            stmt.setString(1, producto.getNombreProducto());

            stmt.setDouble(2, producto.getPrecio());

            stmt.setInt(3, producto.getIdListaCompra());

            stmt.executeUpdate();

        }

    }



    public void update(ProductoListaDTO producto) throws SQLException {

        String query = "UPDATE ProductoLista SET nombre_producto = ?, precio_producto = ? WHERE idProductoLista = ?";



        try (Connection conn = DatabaseConfig.getConnection();

             PreparedStatement stmt = conn.prepareStatement(query)) {



            stmt.setString(1, producto.getNombreProducto());

            stmt.setDouble(2, producto.getPrecio());

            stmt.setInt(3, producto.getId()); 

            stmt.executeUpdate();

        }

    }



    public void delete(int idProducto) throws SQLException {

        String query = "DELETE FROM ProductoLista WHERE idProductoLista = ?";



        try (Connection conn = DatabaseConfig.getConnection();

             PreparedStatement stmt = conn.prepareStatement(query)) {



            stmt.setInt(1, idProducto);

            stmt.executeUpdate();

        }

    }



    public List<ProductoListaDTO> findByListaCompraId(int idListaCompra) throws SQLException {

        List<ProductoListaDTO> productos = new ArrayList<>();

        String query = "SELECT idProductoLista, nombre_producto, precio_producto FROM ProductoLista WHERE idListaCompra = ?";



        try (Connection conn = DatabaseConfig.getConnection();

             PreparedStatement stmt = conn.prepareStatement(query)) {



            stmt.setInt(1, idListaCompra);

            ResultSet rs = stmt.executeQuery();



            while (rs.next()) {

                ProductoListaDTO producto = new ProductoListaDTO();

                producto.setId(rs.getInt("idProductoLista")); 

                producto.setNombreProducto(rs.getString("nombre_producto"));

                producto.setPrecio(rs.getDouble("precio_producto"));

                producto.setIdListaCompra(idListaCompra);

                productos.add(producto);

            }

        }



        return productos;

    }

}
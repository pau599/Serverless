/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataBaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Carolina
 */
public class DatabaseConfig {
    private static final String URL =
    "jdbc:mysql://localhost:3307/gastrobot";
    private static final String USER = "root";
    private static final String PASSWORD = "pumbolillo1145D";
    public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASSWORD);
}

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Repository.UserRepository;
import dataBaseConfig.DatabaseConfig;
import dto.UserDTO;
import exception.InvalidUserDataException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import validator.UserValidator;

/**
 *
 * @author Carolina
 */

public class UserService {
    public static String correoActual;
    private UserRepository userRepository = new UserRepository();
    
    public UserDTO getUsuarioByCorreoAndContraseña(String correo, String contraseña) throws SQLException{
        String contraseñaEncriptada = encriptarContraseña(contraseña);
        return userRepository.findByCorreoAndContraseña(correo,contraseñaEncriptada);
    }
    
    public void createUser( String nombre, String contraseña, String correo) throws SQLException, InvalidUserDataException {
    if (!UserValidator.validateNombre(nombre)) {
        throw new InvalidUserDataException("Nombre inválido");
    }
    
    if (!UserValidator.validateCorreo(correo)) {
        throw new InvalidUserDataException("Correo inválido");
    }
    
    if (!UserValidator.validateContraseña(contraseña)) {
        throw new InvalidUserDataException("Contraseña inválida");
    }

    String contraseñaEncriptada = encriptarContraseña(contraseña);
    
    UserDTO user = new UserDTO(nombre, correo, contraseñaEncriptada);
    userRepository.save(user);
}
    
    
    
    public String encriptarContraseña(String contraseña) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(contraseña.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al encriptar la contraseña", e);
        }
}
    
    public void cambiarContraseña(String correo, String nuevaContraseña) throws SQLException, InvalidUserDataException {
        String contraseñaEncriptada = encriptarContraseña(nuevaContraseña);
    try (Connection conn = DatabaseConfig.getConnection();
         PreparedStatement stmt = conn.prepareStatement("UPDATE Usuario SET contraseña = ? WHERE correo = ?")) {

        stmt.setString(1, contraseñaEncriptada);
        stmt.setString(2, correo);
        int filas = stmt.executeUpdate();

        if (filas == 0) {
            throw new SQLException("No se encontró un usuario con ese correo.");
        }
    }
    }

    public void eliminarCuenta(String correo) throws SQLException {
    try (Connection conn = DatabaseConfig.getConnection()) {
       
        try (PreparedStatement stmt1 = conn.prepareStatement("DELETE FROM ListaCompra WHERE idUsuario = (SELECT idUsuario FROM Usuario WHERE correo = ?)")) {
            stmt1.setString(1, correo);
            stmt1.executeUpdate();
        }

        try (PreparedStatement stmt2 = conn.prepareStatement("DELETE FROM Usuario WHERE correo = ?")) {
            stmt2.setString(1, correo);
            stmt2.executeUpdate();
        }
    }
    
    
    
    
    }
}

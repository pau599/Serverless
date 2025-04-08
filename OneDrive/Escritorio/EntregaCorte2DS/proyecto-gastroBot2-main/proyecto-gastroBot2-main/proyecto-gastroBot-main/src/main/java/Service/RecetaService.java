/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Repository.RecetaRepository;
import dto.RecetaDTO;
import exception.InvalidRecetaDataException;
import java.sql.SQLException;
import validator.RecetaValidator;

/**
 *
 * @author Carolina
 */
public class RecetaService {
    private RecetaRepository recetaRepository = new RecetaRepository();

    public void crearRecetaDesdeRespuestaIA(String respuestaIA) throws SQLException {
        String nombre = extraerNombreReceta(respuestaIA);
        String descripcion = respuestaIA;
        String dificultad = "Fácil"; 
        int tiempoPreparacion = 15; 

        RecetaDTO receta = new RecetaDTO(nombre, descripcion, dificultad, tiempoPreparacion);
        recetaRepository.save(receta);
    }

   public String extraerNombreReceta(String respuestaIA) {
    String[] lineas = respuestaIA.split("\n");

   
    if (!lineas[0].trim().isEmpty() && lineas[0].length() < 80) {
        return lineas[0].trim();
    }

   
    for (String linea : lineas) {
        if (linea.toLowerCase().contains("nombre") || linea.toLowerCase().contains("receta")) {
            
            int indice = linea.indexOf(":");
            if (indice != -1) {
                return linea.substring(indice + 1).trim();
            } else {
                return linea.trim();
            }
        }
    }

    return "Receta sin nombre";
}
}
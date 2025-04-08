/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Carolina
 */
public class RecetaDTO {
    private String nombreReceta;
    private String descripcion;
    private String dificultad;
    private int tiempoPreparacion;

    public RecetaDTO(String nombreReceta, String descripcion, String dificultad, int tiempoPreparacion) {
        this.nombreReceta = nombreReceta;
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDificultad() {
        return dificultad;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }
}

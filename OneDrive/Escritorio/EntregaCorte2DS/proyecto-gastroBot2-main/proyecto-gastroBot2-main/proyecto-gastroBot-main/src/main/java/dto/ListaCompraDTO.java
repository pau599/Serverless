/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.List;

/**
 *
 * @author Carolina
 */
public class ListaCompraDTO {
    
    private int idListaCompra;
    private int idUsuario;
    private String ingredientes;
   

    public ListaCompraDTO(int idListaCompra, int idUsuario, String ingredientes) {
        this.idListaCompra = idListaCompra;
        this.idUsuario = idUsuario;
        this.ingredientes = ingredientes;
       
    }

   

    public int getIdListaCompra() {
        return idListaCompra;
    }

    public void setIdListaCompra(int idListaCompra) {
        this.idListaCompra = idListaCompra;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

   

}


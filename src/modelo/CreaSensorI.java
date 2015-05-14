/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author Alina
 */
public interface CreaSensorI {
    
     public Object getOperacion(String operacion);
     public void   setDTO (util.DTO dto);
     public String obtenerResultado();
}

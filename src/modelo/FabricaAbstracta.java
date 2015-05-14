/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import util.DTO;

/**
 *
 * @author Allan
 */
public interface FabricaAbstracta {
    
    public String calcula();
    public DTO getDto();
    public boolean validarCantidadOperandos(int arrayListSize, int identificadorOperacion);
}

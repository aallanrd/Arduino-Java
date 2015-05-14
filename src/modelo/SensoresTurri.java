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
public abstract class SensoresTurri implements FabricaOpTurri {
    
    
     public DTO dto;
   
   public  void setDTO(DTO dto1){
       this.dto = dto1;
   }
   
   @Override
   //metodo alambrado si identificadorOperacion = 1 => debe haber solo un operando
   //si identificadorOperacion = 2 => deben haber al menos dos operandos
   public boolean validarCantidadOperandos(int arrayListSize, int identificadorOperacion){
       boolean cantidadCorrecta = true;
       if(identificadorOperacion == 1){
            if (!(arrayListSize == 1))cantidadCorrecta = false;
       }
       else{
           if(!(arrayListSize > 1))cantidadCorrecta = false;
       }
       return cantidadCorrecta;
   }
    
}

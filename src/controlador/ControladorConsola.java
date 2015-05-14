/*
    @ITCR 2015 - Diseño de Software 
    * Alina Pacheco 
    * Allan Rojas 
    * Carlos Azofeifa
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package controlador;

import modelo.CreaOperacionCatie;
import modelo.CreaOperacionTurri;
import util.DTO;
import modelo.CreaSensorI;
import util.utileria;

/**
 *
 * @author Carlos
 *  @version    1.01 
 */
public class ControladorConsola implements ControladorConsolaI{
    
    CreaSensorI creaopI ;
    
    /**
     * Send DTO passing by Interface CreaSensorI
     * @param datos 
     */
    private utileria util  = new utileria();
    
    @Override
    public void enviaDTO(DTO datos) {
        
       String operador =  datos.getOperador(); // Suma
       
       if(  util.esCatie(operador)  ){
        //Reviso Array de Aritmeticas > SUma 
        creaopI = new CreaOperacionCatie();
         creaopI.setDTO(datos);
       }
       
       else if(  util.esTurri(operador)  ){
        //Reviso Array de Aritmeticas > SUma 
        creaopI = new CreaOperacionTurri();
         creaopI.setDTO(datos);
       } 
       
       
       
       
        
    }
    
    /**
     * To perform this operation you must first send DTO to the class : Go look the metod : enviaDTO(DTO datos)
     * Goes to the class with the operation selected by the user
     * @return String resultado
     */
    @Override
    public String retornaResultado() {
        
    String calcula = creaopI.obtenerResultado();
    return  calcula;
    
        
    }
    
    
    

}

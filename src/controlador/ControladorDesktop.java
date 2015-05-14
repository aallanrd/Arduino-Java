/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.ArrayList;
import modelo.*;
import util.DTO;
import util.utileria;

/**
 *
 * @author Alina
 */
public class ControladorDesktop implements ControladorDesktopI{

    private DTO datos;
    private CreaSensorI creaopI;
    private utileria util ;
    
    public  ControladorDesktop (){
        util = new utileria();
    }
    
   
    
    @Override
    public void enviaDTO(DTO datos) {
        
//       creaopI = new CreaOperacionCatie();
//       datos = new DTO();
//        datos.setOperador("TempCatie");
//        datos.setOperandos(new ArrayList());
//        creaopI.setDTO(datos);
//        enviaDTO(datos); 
        
       String operador =  datos.getOperador(); // Suma
       
       if(  util.esCatie(operador)  ){
        //Reviso Array de Aritmeticas > SUma 
        creaopI = new CreaOperacionCatie();
        creaopI.setDTO(datos);
       }
       if(  util.esTurri(operador)  ){
        //Reviso Array de Aritmeticas > SUma 
        creaopI = new CreaOperacionTurri();
        creaopI.setDTO(datos);
       } 
       
        
       
    }

    @Override
    public String retornaResultado() {
        
        String calcula = creaopI.obtenerResultado();
        return  calcula;
    }

   
    
    
}

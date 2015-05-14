
package controlador;

import modelo.*;
import util.DTO;
import util.Util;

/**
 *
 * @author Alina
 */
public class ControladorDesktop implements ControladorDesktopI{

    private DTO datos;
    private CreaSensorI creaopI;
    private Util util ;
    
    public  ControladorDesktop (){
        util = new Util();
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

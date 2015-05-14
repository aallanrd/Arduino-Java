/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import controlador.CustomClassLoader;
import util.DTO;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author Alina
 */
public class CreaOperacionTurri implements CreaSensorI {
    
    
   
  SensoresTurri operacion ;
  
  
    // Factory Method
    @Override
    public void setDTO(DTO dto) {
        
        //Obtengo Operador Ej @Suma
        String operador = dto.getOperador();
        System.out.println(operador);
        
        //Segun el Operador del DTO, busco y alojo en clase abstracta
        operacion = (SensoresTurri) getOperacion(operador);
        
        //Segun la clase que encuentre, alojo el DTO recibido
        operacion.setDTO(dto);
        
    }

    
     @Override
    public String obtenerResultado() {
        
        //Segun la clase que encuentre, alojo el DTO recibido
        String calcula = operacion.calcula();
        return calcula;
        //String calcula = operacion.calcula(dto.getOperandos());
        
    }
  
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public Object getOperacion(String operacion) {
        Object o = null;
        try {
            CustomClassLoader loader = new CustomClassLoader();
            // This class should be in your application class path
            Class<?> c = loader.findClass("modelo.operaciones._" + operacion);
            o = c.newInstance();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
           System.out.println("Error ");
        }
        return o;

    }

    

    

    
    
    
    
}

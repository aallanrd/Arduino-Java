/*
 * Copyright (C) 2015 Allan
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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

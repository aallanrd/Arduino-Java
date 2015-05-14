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


package modelo.operaciones;

import controlador.FenixConnect;
import controlador.FenixTipadas;
import util.DTO;
import java.util.ArrayList;


import modelo.SensoresTurri;

/**
 *
 * @author Alina
 */
public class _TempTurri extends SensoresTurri {
    
    
    
    public String id = "n";
    public FenixConnect test = new FenixConnect();
    
    @Override
    public String calcula(){
        
        System.out.println("Entro a Calcula");
        boolean initialize = test.initialize();
        
        if (initialize) {
            test.sendData(id);  
            try { Thread.sleep(100); } catch (InterruptedException ie) {}

            test.close();
        }

        int x = 0;
        int tam = FenixTipadas.gettingData.size();
        String ret = "";
         System.out.println("Tam: " +tam);
        while (x != tam) {
            
            String get = FenixTipadas.gettingData.get(x);
            System.out.println();
            ret = get + "," ; 
            x++;
        }
        return ret;
    }
    
      
   
    
    
    @Override
     public DTO getDto(){
         
         return this.dto;
   }
    
    
}

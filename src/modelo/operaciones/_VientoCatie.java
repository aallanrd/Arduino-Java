/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.operaciones;

import controlador.FenixConnect;
import controlador.FenixTipadas;
import util.DTO;
import java.util.ArrayList;

import modelo.SensoresCatie;

/**
 *
 * @author Alina
 */
public class _VientoCatie extends SensoresCatie {
    
    
     
    public String id = "y";
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

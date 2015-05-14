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

package util;

import java.util.ArrayList;

/**
 *
 * @author Allan
 */

public class Util {
    
    
    public ArrayList operacionesDisponibles;
    
    public String operation_package = "modelo.operaciones";
    
    
    
    public Util() {
        
    }
    
    
    
    //Lista de Operaciones Aritmeticas Permitidas
    public ArrayList getOperacionesCatie(){
        
        ArrayList<String> lista_operaciones = new ArrayList<>();
        
        lista_operaciones.add("VientoCatie");
       // lista_operaciones.add("Resta");
        
        return  lista_operaciones;
    }
    
    //Lista de Operaciones de Conversion Permitidas
    public ArrayList getOperacionesTurri(){
        ArrayList<String> lista_operaciones = new ArrayList<>();
        
        lista_operaciones.add("TempTurri");
      //  lista_operaciones.add("DecToHex");
        return lista_operaciones;
    }
    //Retorna Int 
    public boolean esCatie(String op){
        
        boolean ret = false;
        int size = getOperacionesCatie().size();
        for(int i = 0; i<size; i++ ){
            
            if(getOperacionesCatie().get(i).equals(op)){
                ret =  true;
                break;
            }
        
     }
        return ret;
    }
    //Retorna Int 
    public boolean esTurri(String op){
        
        boolean ret = false;
        int size = getOperacionesTurri().size();
        for(int i = 0; i<size; i++ ){
            
            if(getOperacionesTurri().get(i).equals(op)){
                ret =  true;
                break;
            }
        
     }
        return ret;
    } 
    
    //______________________________________________-
    public ArrayList cargarClases(){
        
        this.operacionesDisponibles = new ArrayList();
        SearchSensorClass bn = new SearchSensorClass();
        ArrayList<Class<?>> find = bn.find(operation_package);
        
        for ( int i = 0 ;i < find.size();i++){
            
            String classNameA = find.get(i).getSimpleName();

            if (classNameA.charAt(0) == '_') {
                operacionesDisponibles.add(classNameA.substring(1));
            }
        }
        return operacionesDisponibles;
        
    }
    
     public boolean validarOpcionDigitada(int opcionDigitada, int opcionesDisponibles){
        boolean opcionCorrecta = true;
        if(opcionDigitada < 1 || opcionDigitada > opcionesDisponibles+1)opcionCorrecta = false;
        return opcionCorrecta;
    }
    
    
    
    public boolean validarSoloNumeros(ArrayList operandos){
        boolean soloNumeros = true;
        for (int i = 0; i < operandos.size(); i++){
            String elemento = operandos.get(i).toString();
            if(isInteger(elemento))continue;
            else{
                soloNumeros = false;
                break;
            }
        }
        return soloNumeros;
    }
    public boolean isInteger(String number){
        boolean integer = true;
        for(int i = 0; i < number.length(); i++){
            if(!((int)number.charAt(i) < 48 || (int)number.charAt(i) > 57))continue;
            else{
                integer = false;
                break;
            }
        }
        return integer;
    }
    
    
    
}

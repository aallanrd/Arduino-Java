/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;

/**
 *
 * @author Allan
 */

public class utileria {
    
    
    public ArrayList operacionesDisponibles;
    
    public String operation_package = "modelo.operaciones";
    
    
    
    public utileria() {
        
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
        BuscaNombres bn = new BuscaNombres();
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.ArrayList;

/**
 *
 * @author Alina
 */

public class DTO {

    private ArrayList<String> operandos;
    private String operador;
    
    public DTO(){
        operandos = new ArrayList();
    }

    public ArrayList getOperandos() {
        return operandos;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperandos(ArrayList operandos) {
        this.operandos = operandos;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }
    
    public boolean addOperando(String op){
        boolean integer = new utileria().isInteger(op);
        if(integer){
            operandos.add(op);   
        }
        return integer;
    }
    

}

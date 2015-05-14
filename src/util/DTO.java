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
        boolean integer = new Util().isInteger(op);
        if(integer){
            operandos.add(op);   
        }
        return integer;
    }
    

}

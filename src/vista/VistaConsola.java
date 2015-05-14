/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorConsola;
import controlador.ControladorConsolaI;
import java.util.ArrayList;
import java.util.Scanner;
import util.*;

/**
 *
 * @author Allan
 */

public class VistaConsola{
        
        private Scanner scanner = new Scanner(System.in);
        private String operandosIngresados;
        private String[] operandosObtenidos;
        private String stringDesplegar = "";
        private String operacionSeleccionada;
        private int iterador;
        private int operacionSeleccionadaConvertida;
        private ControladorConsolaI controlador;
        private  utileria util = new utileria();
        private ArrayList operandos = new ArrayList();
        private DTO datos = new DTO();
       
        private ArrayList operacionesDisponibles = new ArrayList();
        //private ValidacionesConsola validaciones = new ValidacionesConsola();
        
        public void creaStringDesplegar(){
            
            for(iterador = 0; iterador < operacionesDisponibles.size(); iterador++){
               
                stringDesplegar += iterador+1;
                stringDesplegar += "-";
                stringDesplegar += operacionesDisponibles.get(iterador).toString();
                stringDesplegar += "\n";
              
            }
            stringDesplegar += iterador+1;
            stringDesplegar += "-Salir";
        }
        
        public void creaMenu(){
            
            controlador = new ControladorConsola();
            operacionesDisponibles = util.cargarClases();
            creaStringDesplegar();
            
            
            while(true){
                
                System.out.println(stringDesplegar);
                
                operacionSeleccionada = scanner.nextLine();
                
                if(util.isInteger(operacionSeleccionada)){
                    
                    operacionSeleccionadaConvertida =  Integer.parseInt(operacionSeleccionada);

                    if(operacionSeleccionadaConvertida  == iterador+1)break;

                    if(util.validarOpcionDigitada(operacionSeleccionadaConvertida , iterador)){

                        datos.setOperador(operacionesDisponibles.get(operacionSeleccionadaConvertida -1).toString());

                        System.out.println("Digite el o los números para realizar la operación "
                                + "separados por un espacio\n");

                        operandosIngresados = scanner.nextLine();

                        operandosObtenidos = operandosIngresados.split(" ");

                        operandos.removeAll(operandos);

                        for(int i = 0; i < operandosObtenidos.length; i ++){
                            System.out.println(operandosObtenidos[i]);
                            operandos.add(operandosObtenidos[i]);
                        }

                        if(util.validarSoloNumeros(operandos)){

                            datos.setOperandos(operandos);

                            controlador.enviaDTO(datos);

                            String resultado = controlador.retornaResultado();
                            
                            if(!(resultado.equals("")))System.out.println("El resultado es: "+ resultado );
                            else System.out.println("Error en los operandos ingresados\n");
                        }
                        else System.out.println("Error en los operandos ingresados\n");
                    }
                    else System.out.println("Opcion no disponible\n");
                }
                else System.out.println("Error, vuelva a intentarlo\n");
            }
        }
}

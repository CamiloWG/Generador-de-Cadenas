/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.generadorcadenas;

import Datos.Gramatica;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Acer
 */
public class Manager {
    
    private Gramatica grammar;
    
    public Manager() {
        this.grammar = new Gramatica();
        System.out.println("Bienvenido al Generador de Cadenas!");
        System.out.println("A continuación podrás crear tu gramatica:\n");
    }
    
    public void Menu() {
        System.out.println("|--------------- MENÚ ---------------|");
        System.out.println("| 1. Agregar variable no terminal    |");
        System.out.println("| 2. Eliminar variable no terminal   |");
        System.out.println("| 3. Agregar simbolo terminal        |");
        System.out.println("| 4. Eliminar simbolo terminal       |");
        System.out.println("| 5. Asignar variable incial         |");
        System.out.println("| 6. Agregar regla gramatical        |");
        System.out.println("| 7. Eliminar regla gramatical       |");
        System.out.println("| 8. Generar cadenas                 |");
        System.out.println("| 9. Ver gramatica                   |");
        System.out.println("|____________________________________|\n");
        try {
            Scanner scan = new Scanner(System.in);
            int num = scan.nextInt();
            switch(num) {
                case 1: {
                    this.addVarTerminal();
                    break;
                }
                case 2: {
                    this.deleteVarTerminal();
                    break;
                }
                case 3: {
                    this.addSimboloTerminal();
                    break;
                }
                case 4: {
                    this.deleteSimboloTerminal();
                    break;
                }
                case 5: {
                    this.setInicial();
                    break;
                }
                case 6: {
                    this.addRule();
                    break;
                }
                case 7: {
                    this.deleteRule();
                    break;
                }
                case 8: {
                    this.generateStrings();
                    break;
                }
                case 9: {
                    System.out.println("|----------- GRAMATICA -----------|");
                    System.out.println(this.grammar);
                    break;
                }
            }
        } catch(Exception e) {
            System.out.println(e);
            System.out.println("ERROR: Elija una opcion valida!");
        }
        Menu();
    }
    
    
    private void addVarTerminal() {
        System.out.println("Ingrese la variable a agregar en mayuscula:");
        Scanner scan = new Scanner(System.in);
        char var = scan.next().charAt(0);
        if(Character.isUpperCase(var)) {
            if(this.grammar.addVariable(var)) System.out.println("Variable " + var + " agregada exitosamente!\n");
            else System.out.println("La variable " + var + " ya existe!\n");
        } else System.out.println("Ingrese una variable valida!\n");
    }
    
    private void deleteVarTerminal() {
        System.out.println("Ingrese la variable a eliminar en mayuscula:");
        Scanner scan = new Scanner(System.in);
        char var = scan.next().charAt(0);
        if(Character.isUpperCase(var)) {
            if(this.grammar.deleteVariable(var)) System.out.println("Variable " + var + " eliminada exitosamente!\n");
            else System.out.println("La variable " + var + " no existe!\n");
        } else System.out.println("Ingrese una variable valida!\n");
    }
    
    
    private void addSimboloTerminal() {
        System.out.println("Ingrese el simbolo a agregar en minuscula:");
        Scanner scan = new Scanner(System.in);
        char var = scan.next().charAt(0);
        if(Character.isLowerCase(var) || Character.isDigit(var)) {
            if(this.grammar.addTerminales(var)) System.out.println("El simbolo " + var + " fue agregado exitosamente!\n");
            else System.out.println("El simbolo " + var + " ya existe!\n");
        } else System.out.println("Ingrese un simbolo valido!\n");
    }
    
    
    private void deleteSimboloTerminal() {
        System.out.println("Ingrese el simbolo a eliminar en minuscula:");
        Scanner scan = new Scanner(System.in);
        char var = scan.next().charAt(0);
        if(Character.isLowerCase(var) || Character.isDigit(var)) {
            if(this.grammar.deleteTerminales(var)) System.out.println("Simbolo " + var + " eliminado exitosamente!\n");
            else System.out.println("Simbolo " + var + " no existe!\n");
        } else System.out.println("Ingrese una variable valida!\n");
    }
    
    private void setInicial() {
        System.out.println("Ingrese la variable que desea asignar como inicial:");
        Scanner scan = new Scanner(System.in);
        char var = scan.next().charAt(0);
        if(Character.isUpperCase(var)) {
            if(this.grammar.setVariableInicial(var)) System.out.println("Variable " + var + " asignada inicial exitosamente!\n");
            else System.out.println("La variable " + var + " no existe!\n");
        } else System.out.println("Ingrese una variable valida!\n");
    }
    
    private void addRule() {
        System.out.println("Ingrese la variable donde desea agregar la regla:");
        Scanner scan = new Scanner(System.in);
        char var = scan.next().charAt(0);
        if(Character.isUpperCase(var)) { 
            System.out.println("Ahora ingrese la regla:");
            String rule = scan.next();
            if(this.grammar.validateRule(rule) || rule.equals("^")) {
                if(this.grammar.addReglaToVar(var, rule)) System.out.println("Regla " + rule + " agregada en "+ var +" exitosamente!\n");
                else System.out.println("La regla " + rule + " ya existe para la variable "+ var +"\n");
            } else System.out.println("Ingrese una regla valida!\n");
        } else System.out.println("Ingrese una variable valida!\n");
    }
    
    private void deleteRule() {
        System.out.println("Ingrese la variable donde desea eliminar la regla:");
        Scanner scan = new Scanner(System.in);
        char var = scan.next().charAt(0);
        if(Character.isUpperCase(var)) { 
            System.out.println("Ahora ingrese la regla a eliminar:");
            String rule = scan.next();
            if(this.grammar.deleteReglaFromVar(var, rule)) System.out.println("Regla " + rule + " eliminada exitosamente de la variable "+ var +"\n");
            else System.out.println("La regla " + rule + " no existe para la variable "+ var +"\n");
        } else System.out.println("Ingrese una variable valida!\n");
    }
    
    private void generateStrings() {
        System.out.println("\n\n| ------- GENERADOR DE CADENAS ------- |");
        String attempt = this.grammar.generarCadenaAleatoria();
        if(attempt.contains("ERROR")) {
            System.out.println(attempt);
            return;
        } 
        
        System.out.println("Cadenas generadas:");
        Scanner scan = new Scanner(System.in);
        int amount = 0;
        Set<String> cadenas = new HashSet<>();
        try {
            
            do {
                int size = cadenas.size();
                int counter = 0;
                while(true) {
                    String str = this.grammar.generarCadenaAleatoria();
                    cadenas.add(str);
                    if(cadenas.size() != size){
                        System.out.println(str);
                        counter = 0;
                        break;
                    }
                    if(counter == 10000) break;
                    counter++;
                }
                if(counter >= 10000) {
                    System.out.println("No se encontraron mas cadenas!");
                    amount = 0;
                    break;
                } else {
                    System.out.println("¿Desea generar otra cadena? | 1 = Si | Otro numero = No");
                    amount = scan.nextInt();
                }
            } while(amount == 1);
        } catch(Exception e) {
            System.out.println("Ingrese un numero valido!");
            generateStrings();
        }
        
        
        
        
        System.out.println("\nTotal cadenas generadas:");
        cadenas.forEach(str -> System.out.println(str));
        
    }
}

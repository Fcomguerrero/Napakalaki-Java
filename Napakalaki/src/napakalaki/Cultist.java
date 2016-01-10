/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Fco Manuel Guerrero Jimènez
 */
public class Cultist {
    
//Atributos
    private String name;
    private int gainedLevels;

//Constructor
public Cultist(String name, int gainedLevels) {
    this.name = name;
    this.gainedLevels = gainedLevels;
}
//obtener el numero de niveles Ganados
public int getGainedLevels() {
    return gainedLevels;
}

        
}//class

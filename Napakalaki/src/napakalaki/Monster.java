/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Fco M Guerrero Jimènez
 */
public class Monster {
    private final String name;
    private final int combatLevel;
    BadConsequence bc;
    Prize price;
    private Prize prize;
 
    //constructor
Monster(String name, int level, BadConsequence bc, Prize price){
    this.name = name;
    this.combatLevel = level;
    this.bc = bc;
    this.price = price;
}

//consultores   
public String getName(){
    return name;
}
public BadConsequence getBc() {
    return bc;
}
public Prize getPrice() {
return price;
}
public int getCombatLevel(){
    return combatLevel;
}
public int getLevelsGained(){
    return this.price.getLevel();
}
public int getTreasuresGained(){
    return this.price.getTreasures();
}

//devuelve un String con el estado del objeto
public String toString(){
    return "\n" + name + "\nNivel = " + combatLevel + "\nBuen Rollo" + price.toString() + "\nMal Rollo" + bc.toString();
}            
    
}//class
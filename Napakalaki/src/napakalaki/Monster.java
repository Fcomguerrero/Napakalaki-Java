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
public class Monster {
    private final String name;
    private final int combatLevel;
    private int levelChangeAgainstCultistPlayer = 0;
    BadConsequence bc;
    Prize price;
    private Prize prize;
 
    //constructor
Monster(String name, int level, BadConsequence bc, Prize price, int LC){
    this.name = name;
    this.combatLevel = level;
    this.bc = bc;
    this.price = price;
    this.levelChangeAgainstCultistPlayer = LC;
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
public int getCombatLevelAgainstCultistPlayer() {
    return getCombatLevel() + levelChangeAgainstCultistPlayer;
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
    @Override
    public String toString(){
    return "\n" + name + "\nNivel = " + combatLevel + "\nBuen Rollo" + price.toString() + "\nMal Rollo" + bc.toString();
}            
    
}//class
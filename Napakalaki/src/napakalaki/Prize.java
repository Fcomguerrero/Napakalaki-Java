/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author fcis
 */
public class Prize {
    
private int treasures;
private int level;
                    
Prize(int treasures, int level){  //constructor
        this.treasures = treasures ;
        this.level = level ;
}

public int getTreasures(){ //consultor
    return treasures;
}
       
public int getLevel(){ //consultor
    return level;
}
 //devuelve un String con el estado del objeto
public String toString(){
return "\nTreasures = " + Integer.toString(treasures) + "\nLevels = " + Integer.toString(level);

}

} //class

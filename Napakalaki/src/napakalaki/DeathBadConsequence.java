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
public class DeathBadConsequence extends NumericBadConsequence{
    
     //constructor        
    public DeathBadConsequence(String text){
       super(text, Player.MAXLEVEL,MAXTREASURES,MAXTREASURES);
    }

@Override    
    public String toString(){
        String Salida = super.toString() + "Estas Muerto";
        return Salida;
    }
}
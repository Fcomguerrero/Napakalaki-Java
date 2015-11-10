/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.Random;
/**
 *
 * @author fcis
 */
public class Dice {
    
      //<<SINGLETON>>
    private static final Dice instance = new Dice();
    //El constructor privado asegura que no se puede instanciar desde otras clases
    private Dice() {}
    public static Dice getInstance(){
        return instance;
    }
    //Genera un numero aleatorio entre 1 y 6
    private Random number = new Random();
    public int nextNumber(){
        int dice = number.nextInt(6)+1;
        //System.out.println("\nNumero Obtenido " + Integer.toString(dice) + "\n");
    return dice;
    }

}//class


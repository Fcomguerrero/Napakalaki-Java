/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author fcis
 */
public class Napakalaki {
    
     //<<SINGLETON>>
    private static final Napakalaki instance = new Napakalaki();
    //El constructor privado asegura que no se puede instanciar desde otras clases
    private Napakalaki() {}
    public static Napakalaki getInstance(){
        return instance;
    }
    
    private Monster currentMonsters;
    private Player currentPlayer;
    private ArrayList<Player> players;
    
    
}

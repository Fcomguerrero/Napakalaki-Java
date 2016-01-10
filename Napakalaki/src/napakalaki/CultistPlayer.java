/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.Collections;
import java.util.Random;
import javafx.scene.control.TreeItem;

/**
 *
 * @author Fco Manuel Guerrero Jimènez
 */
public class CultistPlayer extends Player{
    
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    //Constructor
    public CultistPlayer(Player p, Cultist c ) {
        super(p);
        this.myCultistCard = c;
        this.totalCultistPlayers++;         
    }
    
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
    @Override
    protected int getCombatLevel(){ 
       int lv = super.getCombatLevel() + super.getCombatLevel()/20;
       int nivel = lv + myCultistCard.getGainedLevels() * CultistPlayer.getTotalCultistPlayers();
       return nivel;
    }
    @Override
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    @Override
    protected boolean shouldConvert(){
        return false;
    }    
    //El  método  canYouGiveMeATreasure  también  se  redefine  para  consultar  si  el
    //enemigo tiene tesoros visibles para ser robados.
    @Override
    protected boolean canYouGiveMeATreasure(){
        return !visibleTreasures.isEmpty();                
    }
    //El método giveMeATresure se redefine en CultistPlayer de manera que se devuelva
    //un tesoro visible elegido al azar.
    @Override
    protected Treasure giveMeATreasure(){
        Treasure treasure;
        Random random = new Random();
        int number = random.nextInt(getVisibleTreasures().size());
        treasure = super.enemy.visibleTreasures.remove(number);
      return treasure;
    }
  
    
    
}//class


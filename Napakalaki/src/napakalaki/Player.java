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
public class Player {
    //Atributos de clase 
   private String name;
   private int level;
   private boolean dead = true;
   private boolean canlSteal = true;
   private BadConsequence pendingBadConsequense;
   private Player enemy;
   
   //<<constant>>
   static final int MAXLEVEL = 10;
   
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
    
    public Player(String name){
        this.name = name;
        this.dead = true;
        this.canlSteal = true;
        this.enemy = null;
        this.level = 1;
        this.pendingBadConsequense = null;
    }
    
    //Devuelve true si el jugador está muerto, false en caso contrario.  
    public boolean isDead(){
        return dead;
    }
    //Devuelve el nombre del jugador.
    public String getName() {
        return name;
    }
    //Devuelve el nivel de combate del jugador, que viene dado por su nivel más los bonus
    //que le proporcionan los tesoros que tenga equipados, según las reglas del juego.
    private int getCombatLevel(){
        int suma=0;
       for (Treasure visibleTreasure : visibleTreasures) {
           suma = visibleTreasure.getBonus();
       }
            return level+=suma;
    }
    //Devuelve la vida al jugador, modificando el atributo correspondiente.
    private void bringToLife(){
        this.dead = false;
    }
    //Incrementa el nivel del jugador en i niveles, teniendo en cuenta las reglas del juego
    private void incrementLevels(int i){
        if(level+i<MAXLEVEL)
            level=level+i;
        else
            level = MAXLEVEL;
    }
    //Decrementa el nivel del jugador en i niveles, teniendo en cuenta las reglas de juego.
    private void decrementLevels(int i){
        if(level-i>=1)
            level=level-i;
        else 
            this.level = 1;
    }
    //Cambia el estado de jugador a muerto, modificando el correspondiente atributo.
    //Esto ocurre cuando el jugador, por algún motivo, ha perdido todos sus tesoros.
    private void dieIfNoTreasures(){
        if(this.visibleTreasures.isEmpty() && this.hiddenTreasures.isEmpty())
            this.dead = true;
    }
    //Devuelve el nivel del jugador.
    public int getLevel(){
        return level;
    }
    //Devuelve true si el jugador no ha robado ningún tesoro a su enemigo y false en caso contrario.
    public boolean canlSteal(){
        return this.canlSteal;
    }
     //Cambia el atributo canISteal a false cuando el jugador roba un tesoro.
    private void haveStolen(){
            this.canlSteal = false;
    }
    //Devuelve true si el jugador tiene tesoros para ser robados por otro jugador y false
    //en caso contrario
    private boolean canYouGiveMeATreasure(){
       return !hiddenTreasures.isEmpty();
    }
    //Asigna el mal rollo al jugador, dándole valor a su atributo pendingBadConsequence
    private void setPendingBadConsequence(BadConsequence b){
        this.pendingBadConsequense=b;
    }
    //Devuelve true cuando el jugador no tiene ningún mal rollo que cumplir y no tiene
    //más de 4 tesoros ocultos, y false en caso contrario. Para comprobar que el jugador
    //no tenga mal rollo que cumplir, utiliza el método isEmpty de la clase BadConsequence.
    public boolean validState(){
        if(this.pendingBadConsequense.isEmpty() && this.hiddenTreasures.size()<=4)
            return true;
        else
            return false;
    }
    //Devuelve el número de tesoros visibles de tipo tKind que tiene el jugador.
    private int howManyVisibleTreasures(TreasureKind tKind){
            int i=0;
        for(Treasure tr : this.visibleTreasures){
            if (tr.getType() == tKind)
                i++;
    }
        return i;
    }
    //Asigna valor al atributo que referencia al enemigo del jugador.
    public void setEnemy(Player enemy){
        this.enemy = enemy;
    }
   
    
    
    
}//class

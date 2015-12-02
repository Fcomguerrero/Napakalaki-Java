/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Fco Manuel Guerrero Jimènez
 */
public class Player {
    //Atributos de clase 
   private String name;
   private int level;
   private boolean dead = true;
   private boolean canlSteal = true;
   private BadConsequence pendingBadConsequense;
   Player enemy;
   
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
    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }
    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }
    //Devuelve el nivel de combate del jugador, que viene dado por su nivel más los bonus
    //que le proporcionan los tesoros que tenga equipados, según las reglas del juego.
    private int getCombatLevel(){ 
        int suma=0;
       for (Treasure visibleTreasure : visibleTreasures){
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
   //Devuelve un tesoro elegido al azar de entre los tesoros ocultos del jugador. 
   private Treasure giveMeATreasure(){
       Treasure treasure;
       Collections.shuffle(hiddenTreasures);
       treasure = hiddenTreasures.remove(0);
       return treasure;
   }
   //El jugador se descarta de todos sus tesoros ocultos y visibles. Para cada tesoro que se
   // descarta se hace uso de la operación discardVisibleTreasure(t:Treasure) o discardHiddenTreasure(t:Treasure)
   //según corresponda, de esa forma se verifica si se cumple con algún mal rollo pendiente.
    
   public void discardAllTreasures(){               //Diagrama
    ArrayList<Treasure> vlista = new ArrayList<Treasure>(visibleTreasures);  //copia el ArrayList
    ArrayList<Treasure> hlista = new ArrayList<Treasure>(hiddenTreasures);   //copia el ArrayList
       for(Treasure t: vlista) //1.2
           this.discardVisibleTreasure(t);
       for(Treasure t: hlista)    //1.3
           this.discardHiddenTreasure(t);
   }

    public void discardHiddenTreasure(Treasure t) {
      this.hiddenTreasures.remove(t);
      if(this.pendingBadConsequense != null && !this.pendingBadConsequense.isEmpty()){
            this.pendingBadConsequense.substractHiddenTreasure(t);
      }
      this.dieIfNoTreasures();
      }
    
    public void discardVisibleTreasure(Treasure t) {
        this.visibleTreasures.remove(t);
       if(this.visibleTreasures != null && !this.pendingBadConsequense.isEmpty()){
           this.pendingBadConsequense.substractVisibleTreasure(t);
       }
    this.dieIfNoTreasures();
    }
    //Cuando el jugador decide robar un tesoro a su enemigo, este método comprueba que
    //puede hacerlo (sólo se puede robar un tesoro durante la partida) y que su enemigo tiene
    //tesoros ocultos para ser robados (canYouGiveMeATreasure()), en el caso que así sea éste le
    //proporciona un tesoro que se almacenará con sus ocultos. El jugador no puede volver a
    //robar otro tesoro durante la partida. En el caso que no se haya podido robar el tesoro por
    //algún motivo se devuelve null.
   public Treasure stealTreasure(){
       boolean canl = canlSteal();
       boolean canYou = false;
       Treasure treasure = null;
       if(canl){
           this.enemy.canYouGiveMeATreasure();
            if(canYou){
                this.enemy.giveMeATreasure();
                       this.hiddenTreasures.add(treasure);
                       this.haveStolen();
            }       
       }
       return treasure;
   }
   //Cuando el jugador ha perdido el combate, hay que considerar el mal rollo que le impone el
    //monstruo con el que combatió. Para ello, decrementa sus niveles según indica el mal rollo y
    //guarda una copia de un objeto badConsequence ajustada a los tesoros que puede perder.
    //Es decir, un objeto mal rollo que refleje el mal rollo indicado por el monstruo pero
    //eliminando las condiciones que el jugador no pueda cumplir según los tesoros de que
    //disponga (por ejemplo si el mal rollo del monstruo implica perder 2 tesoros visibles y el
    //jugador sólo tiene 1, entonces el mal rollo pendiente será de sólo 1 tesoro visible). La
    //operación encargada de hacer esto es adjustToFitTreasureList de la clase badConsequence.
    //Éste es el mal rollo pendiente (pendingbadConsequence) que el jugador almacenará y que
    //deberá cumplir descartándose de esos tesoros antes de que pueda pasar al siguiente turno.
   private void applyBadConsequence(Monster m){
       int nLevels;
       BadConsequence pendingBad;
       BadConsequence badConsequence = m.getBc();
       nLevels = badConsequence.getLevels();
       this.decrementLevels(nLevels);
       pendingBad = badConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        this.setPendingBadConsequence(pendingBad);           
   }
    //Esta operación es la encargada de aplicar el buen rollo del monstruo vencido al jugador,
    //sumando los niveles correspondientes y pidiendo al CardDealer que le dé el número de
    //tesoros indicado en el buen rollo del monstruo. Esos tesoros se añaden a sus tesoros ocultos.
   private void applyPrize(Monster m){
       int nLevels = m.getLevelsGained();
       this.incrementLevels(nLevels);
       int nTreasures = m.getTreasuresGained();
       if(nTreasures > 0){
           CardDealer dealer = CardDealer.getInstance();
           for(int i=1; i<=nTreasures; i++){
              Treasure treasure = dealer.nextTreasure();
               this.hiddenTreasures.add(treasure);
           }                      
       }
   }
   //Comprueba si el tesoro t se puede pasar de oculto a visible según las reglas del juego.
   private boolean canMakeTreasureVisible(Treasure t){
        boolean canMake = false;
        TreasureKind type = t.getType();
        switch (type) {
            case ONEHAND: 
                if ((howManyVisibleTreasures(type)>1)||(howManyVisibleTreasures(TreasureKind.BOTHHANDS)>0)){
                    canMake = false;
                }else{
                    canMake = true;
                    break;
                }
            case BOTHHANDS:
                if ((howManyVisibleTreasures(type)>0)||(howManyVisibleTreasures(TreasureKind.ONEHAND)>0)){
                    canMake = false;
              
                }else{
                canMake = true;
                } 
            default: 
                if (howManyVisibleTreasures(type)>0){
                    canMake = false;
                }else                
                   canMake = true;               
                }
        //Devolvemos el resultado:
        return canMake;
    }
   
   public void makeTreasureVisible(Treasure t){
       boolean canl = this.canMakeTreasureVisible(t);
        if(canl){
            this.visibleTreasures.add(t);
            this.hiddenTreasures.remove(t);
        }
   }
    //Cuando un jugador está en su primer turno o se ha quedado sin tesoros, hay que
    //proporcionarle nuevos tesoros para que pueda seguir jugando. El número de tesoros que se
    //les proporciona viene dado por el valor que saque al tirar el dado:
   public void initTreasures(){
       CardDealer dealer = CardDealer.getInstance();
       Dice dice = Dice.getInstance();
       this.bringToLife();
       Treasure treasure = dealer.nextTreasure();
       this.hiddenTreasures.add(treasure);
       int number = dice.nextNumber();
       if(number > 1){
           treasure = dealer.nextTreasure();
           this.hiddenTreasures.add(treasure);
       }
       else if(number == 6){
           treasure = dealer.nextTreasure();
           this.hiddenTreasures.add(treasure);
       }               
    }
   //Operación responsabilidad de la única instancia de Napakalaki, la cual pasa el control al
    //jugador actual (currentPlayer) para que lleve a cabo el combate con el monstruo que le ha
    //tocado (currentMonster). El método de la clase Player con esa responsabilidad es
    //combat(currentMonster:Monster): CombatResult, cuyo comportamiento general (también
    //reflejado en el diagrama y responsabilidad de Player) es: si el nivel de combate del jugador
    //supera al del monstruo, se aplica el buen rollo y se puede ganar el combate o el juego, en
    //otro caso, el jugador pierde el combate y se aplica el mal rollo correspondiente.
    public CombatResult combat(Monster m) {
        CombatResult combatResult = null;
        int myLevel = getCombatLevel();
        int monsterLevel = m.getCombatLevel();
        if(myLevel > monsterLevel){
            applyPrize(m);
            if(myLevel >= MAXLEVEL )
                combatResult = CombatResult.WINGAME;
                else
                    combatResult = CombatResult.WIN;            
        }else{
            applyBadConsequence(m);
            combatResult = CombatResult.LOSE;
        }
        return combatResult;
    }
//Metodo toString()
    @Override
    public String toString() {      
        return getName();
    }
   
    
  
   
}//class

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Fco Manuel Guerrero Jimènez
 */
public class Napakalaki {
    
     //<<SINGLETON>>
    private static final Napakalaki instance = new Napakalaki();
    //El constructor privado asegura que no se puede instanciar desde otras clases
    private Napakalaki() {}
    public static Napakalaki getInstance(){
        return instance;
    }
    
    public Monster currentMonster = null;
    public Player currentPlayer;
    public ArrayList<Player> players = new ArrayList();
    
    //Se encarga de solicitar a CardDealer la inicialización de los mazos de cartas de Tesoros y
    //de Monstruos, de inicializar los jugadores proporcionándoles un nombre, asignarle a cada
    //jugador su enemigo y de iniciar el juego con la llamada a nextTurn() para pasar al siguiente
    //turno (que en este caso será el primero).
    public void initGame(ArrayList<String>names){
        initPlayers(names); 
        this.setEnemies();
        dealer.initCards(); 
        this.nextTurn();                              
    }        
    //Inicializa el array de jugadores que contiene Napakalaki, creando tantos jugadores como
    //elementos haya en names, que es el array de String que contiene el nombre de los jugadores.
     private void initPlayers(ArrayList<String>names){        
         for(String x:names)
             players.add(new Player(x));
     }
    //Se asigna un enemigo a cada jugador. Esta asignación se hace de forma aleatoria teniendo
    //en cuenta que un jugador no puede ser enemigo de sí mismo.         
      private void setEnemies(){
        int njugadores = players.size();
          for (int i = 0; i < njugadores; i++) {                                
            Player enemy = players.get((i+1)%players.size());                                
                  players.get(i).setEnemy(enemy);                                                         
          }
     }
    private Player nextPlayer(){
        int nextindice;
        Player nextPlayer;
        int numeroJugadores = 2;
        if(this.currentPlayer == null){
            Random rnd = new Random();
            nextindice = rnd.nextInt(numeroJugadores);
        }
        else{
         int currentPlayerIndex = this.players.indexOf(this.currentPlayer);
         if(currentPlayerIndex == numeroJugadores - 1){
             nextindice = 0;
        }else{
                nextindice = currentPlayerIndex + 1;
         }
        } 
        nextPlayer = players.get(nextindice); 
        this.currentPlayer = nextPlayer;
        return this.currentPlayer;
    }        
    //Devuelve el jugador actual (currentPlayer).
    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }
    //Devuelve el monstruo en juego (currentMonster).
    public Monster getCurrentMonster(){
        return this.currentMonster;
    }
    //Esta operación usa el método nextTurnAllowed(), donde se verifica si el jugador activo
    //(currentPlayer) cumple con las reglas del juego para poder terminar su turno.
    //En caso el caso que nextTurnIsAllowed() devuelva true, se le solicita a CardDealer el
    //siguiente monstruo al que se enfrentará ese jugador (currentMonster) y se actualiza el
    //jugador activo al siguiente jugador.
    //En caso de que el nuevo jugador activo esté muerto, por el combate en su anterior turno o
    //porque es el primer turno, se inicializan sus tesoros siguiendo las reglas del juego. La
    //inicialización de los tesoros se encuentra recogida en el diagrama subordinado initTreasures.
    public boolean nextTurn(){
        boolean stateOK = false;
        boolean dead = true;
        stateOK = this.nextTurnAllowed();        
        if(stateOK){
            dealer = CardDealer.getInstance();          
            this.currentMonster = dealer.nextMonster();
            this.currentPlayer = this.nextPlayer();
            dead = currentPlayer.isDead();
                if(dead){
                    this.currentPlayer.initTreasures();
                }
        } 
        return stateOK;
    }
    //nextTurnAllowed
    private boolean nextTurnAllowed(){
        boolean Allowed = false;
        if (this.currentPlayer == null)
            Allowed = true;
        else{
            Allowed = this.currentPlayer.validState();
        }
      return Allowed;
    }    
    //Devuelve true si el parámetro result es WINGAME (valor del enumerado CombatResult). En
    //caso contrario devuelve false.
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINGAME;
               
    }
      
    CardDealer dealer = CardDealer.getInstance();
    public void discardVisibleTreasures(ArrayList<Treasure>treasures){ //diagrama 
        for(Treasure t: treasures){
            this.currentPlayer.discardVisibleTreasure(t); //1.2
        this.dealer.giveTreasureBack(t);                  //1.3
        }    
    }
    public void discardHiddenTreasures(ArrayList<Treasure>treasures){ //diagrama
        for(Treasure t: treasures){                     
            this.currentPlayer.discardHiddenTreasure(t);    //1.2       
            this.dealer.giveTreasureBack(t);                //1.3
        }
    }
    //Operación responsabilidad de la única instancia de Napakalaki, la cual pasa el control al
    //jugador actual (currentPlayer) para que lleve a cabo el combate con el monstruo que le ha
    //tocado (currentMonster). El método de la clase Player con esa responsabilidad es
    //combat(currentMonster:Monster): CombatResult, cuyo comportamiento general (también
    //reflejado en el diagrama y responsabilidad de Player) es: si el nivel de combate del jugador
    //supera al del monstruo, se aplica el buen rollo y se puede ganar el combate o el juego, en
    //otro caso, el jugador pierde el combate y se aplica el mal rollo correspondiente.
    public CombatResult developCombat(){
        Cultist cultist = null;
        CombatResult combatResult = null;
        int indexP;
        combatResult = currentPlayer.combat(currentMonster);        
        if(combatResult == CombatResult.LOSEANDCONVERT) {    
            cultist = dealer.nextCultist(); 
            CultistPlayer cultistPlayer = new CultistPlayer(currentPlayer,cultist);
            indexP = this.players.indexOf(currentPlayer);
            this.players.set(indexP, cultistPlayer);
            currentPlayer = cultistPlayer;
        }
        dealer.giveMonsterBack(currentMonster);
        return combatResult;
    }
    //Operación en la que se pide al jugador actual que pase tesoros ocultos a visibles, siempre
    //que pueda hacerlo según las reglas del juego, para ello desde Player se ejecuta el método:
    //canMakeTreasureVisible(treasures:Treasure ):boolean
     public void makeTreasuresVisible(ArrayList<Treasure>treasures){
        for(Treasure t: treasures){
            this.currentPlayer.makeTreasureVisible(t);
        }                        
   }
    
       
}//class

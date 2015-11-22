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
    
    private Monster currentMonster;
    private Player currentPlayer;
    private ArrayList<Player> players;
    
    //Inicializa el array de jugadores que contiene Napakalaki, creando tantos jugadores como
    //elementos haya en names, que es el array de String que contiene el nombre de los jugadores.
     private void initPlayers(String[] names){
         ArrayList players = new ArrayList();
         for(String x:names)
             players.add(new Player(x));
     }
    private Player nextPlayer(){
        int nextindice;
        Player nextPlayer;
        int numeroJugadores = this.players.size();
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
    private boolean nextTurnIsAllowed(){
        boolean Allowed;
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
    //Se asigna un enemigo a cada jugador. Esta asignación se hace de forma aleatoria teniendo
    //en cuenta que un jugador no puede ser enemigo de sí mismo.
    private void setEnemies(){
        int njugadores = players.size();
        int miIndex = this.players.indexOf(this.currentPlayer);
        Random rnd = new Random(njugadores);
        int indiceEnemigo = rnd.nextInt();
        int indiceEnemy = players.indexOf(indiceEnemigo);
        for(Player p: players){
        p.setEnemy(nextPlayer()); 
        }              
      }
    CardDealer dealer = CardDealer.getInstance();
    public void discardVisibleTreasure(Treasure[] treasures){ //diagrama 
        for(Treasure t: treasures){
            this.currentPlayer.discardVisibleTreasure(t); //1.2
        this.dealer.giveTreasureBack(t);                  //1.3
        }    
    }
    public void discardHiddenTreasure(Treasure[] treasures){ //diagrama
        for(Treasure t: treasures){                     
            this.currentPlayer.discardHiddenTreasure(t);    //1.2       
            this.dealer.giveTreasureBack(t);                //1.3
        }
    }
    
}//class

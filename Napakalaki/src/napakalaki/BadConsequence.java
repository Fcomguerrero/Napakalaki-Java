/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
/**
 *
 * @author Fco Manuel Guerrero Jimènez
 */
public abstract class BadConsequence {
    private String text;
    private int levels;
    static final int MAXTREASURES = 10;
          
       //constructor
    public BadConsequence(String text, int levels){
        this.text = text;
        this.levels = levels;
    }
                       
    //consultores     
    public String getText(){
        return text;
    }
    public int getLevels(){
        return levels;
    }
  
    //Devuelve true cuando el mal rollo que tiene que cumplir el jugador está vacío, eso
    //significa que el conjunto de atributos del mal rollo indican que no hay mal rollo que
    //cumplir. Plantéate qué valores deberán tener.
    public abstract boolean isEmpty();
    //Actualiza el mal rollo para que el tesoro visible t no forme parte del mismo. Es posible que
    //esta actualización no implique cambio alguno, que lleve a eliminar un tipo específico de
    //tesoro visible, o a reducir el número de tesoros visibles pendientes.
    public abstract void substractVisibleTreasure(Treasure t);
    //Igual que el anterior, pero para los ocultos.
    public abstract void substractHiddenTreasure(Treasure t);          
    //Recibe como parámetros los tesoros visibles y ocultos de los qpublicue dispone el jugador y
    //devuelve un nuevo objeto mal rollo que se ajusta a las posibilidades del jugador. Los
    //atributos de BadConsequence que debemos tener en cuenta para ajustar el el mal rollo que
    //debe cumplir el jugador son nVisibleTreasures, nHiddenTreasures, specificVisibleTreasures y
    //specificHiddenTreasures.
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h);
 
    //devuelve un String con el estado del objeto
    @Override
    public String toString(){
        
        String mensaje;
        mensaje = "\nText: "+ getText() + "\nNiveles Perdidos = " + getLevels();
    return mensaje;
    }
}//class                                                                                
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
public class NumericBadConsequence extends BadConsequence {
    
    private int nVisibleTreasures;
    private int nHiddenTreasures;
 
    //constructor
    public NumericBadConsequence(String text, int levels, int nVisible, int nHidden){
        super(text,levels);
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }
    
    public int getnVisibleTreasures(){
        return nVisibleTreasures;
    }
    public int getnHiddenTreasures(){
        return nHiddenTreasures;
    }
     //Devuelve true cuando el mal rollo que tiene que cumplir el jugador está vacío, eso
    //significa que el conjunto de atributos del mal rollo indican que no hay mal rollo que
    //cumplir. Plantéate qué valores deberán tener.
    @Override
    public boolean isEmpty(){
        return this.nHiddenTreasures==0 && this.nVisibleTreasures==0;
    }
    //Recibe como parámetros los tesoros visibles y ocultos de los que dispone el jugador y
    //devuelve un nuevo objeto mal rollo que se ajusta a las posibilidades del jugador. Los
    //atributos de BadConsequence que debemos tener en cuenta para ajustar el el mal rollo que
    //debe cumplir el jugador son nVisibleTreasures, nHiddenTreasures, specificVisibleTreasures y
    //specificHiddenTreasures.
    public NumericBadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        int visible,hidden;
        visible = Math.min(nVisibleTreasures, v.size());
        hidden = Math.min(nHiddenTreasures, h.size());              
        NumericBadConsequence bc = new NumericBadConsequence(getText(), getLevels(), visible, hidden);         
     return bc;            
    }
    //Actualiza el mal rollo para que el tesoro visible t no forme parte del mismo. Es posible que
    //esta actualización no implique cambio alguno, que lleve a eliminar un tipo específico de
    //tesoro visible, o a reducir el número de tesoros visibles pendientes.
    @Override
    public void substractVisibleTreasure(Treasure t){
          if(nVisibleTreasures > 0)
              nVisibleTreasures--;
    }
    //Igual que el anterior, pero para los ocultos.
    @Override
    public void substractHiddenTreasure(Treasure t){
        if(nHiddenTreasures > 0)
            nHiddenTreasures--;
    }
    
    //devuelve un String con el estado del objeto
    @Override
    public String toString(){        
        String mensaje = new String();       
        mensaje += "Tesoros visibles Perdidos= " + nVisibleTreasures
                + "\nTesoros Ocultos Perdidos = " + nVisibleTreasures ;    
    return mensaje;
    }
    
}//class

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
public class SpecificBadConsequence extends BadConsequence{
    
     //Atributos de tipo Lista TreasureKind
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();        
    
    //constructor
    SpecificBadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        super(text,levels);     
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
    }
     
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }
    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }
      //Devuelve si la lista esta vacia     
    boolean listaVisiblesVacia() {
        return this.specificVisibleTreasures.isEmpty();
    }         
    //Devuelve si la lista esta vacia
    boolean listaOcultoVacia() {
        return this.specificHiddenTreasures.isEmpty();
    }
     //Devuelve true cuando el mal rollo que tiene que cumplir el jugador está vacío, eso
    //significa que el conjunto de atributos del mal rollo indican que no hay mal rollo que
    //cumplir. Plantéate qué valores deberán tener.
    @Override
    public boolean isEmpty(){
        return this.specificHiddenTreasures.isEmpty() && this.specificVisibleTreasures.isEmpty();
    } 
    //Actualiza el mal rollo para que el tesoro visible t no forme parte del mismo. Es posible que
    //esta actualización no implique cambio alguno, que lleve a eliminar un tipo específico de
    //tesoro visible, o a reducir el número de tesoros visibles pendientes.
    @Override
    public void substractVisibleTreasure(Treasure t){
          if(!this.specificVisibleTreasures.isEmpty()){
            for(TreasureKind k : specificVisibleTreasures){
                if (k.equals(t.getType())) 
                    this.specificVisibleTreasures.remove(t.getType());     
            }       
          }
    }
    //Igual que el anterior, pero para los ocultos.
    @Override
    public void substractHiddenTreasure(Treasure t){
        if(!this.specificHiddenTreasures.isEmpty()){
            for(TreasureKind k : specificHiddenTreasures){
                if (k.equals(t.getType())) 
                    this.specificHiddenTreasures.remove(t.getType());
            }            
        }
    }
    //Recibe como parámetros los tesoros visibles y ocultos de los que dispone el jugador y
    //devuelve un nuevo objeto mal rollo que se ajusta a las posibilidades del jugador. Los
    //atributos de BadConsequence que debemos tener en cuenta para ajustar el el mal rollo que
    //debe cumplir el jugador son nVisibleTreasures, nHiddenTreasures, specificVisibleTreasures y
    //specificHiddenTreasures.
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        ArrayList<TreasureKind>visible = new ArrayList();
        ArrayList<TreasureKind>hidden = new ArrayList();
        
        if(!v.isEmpty() && specificVisibleTreasures != null)
            for (int i=0; i<specificVisibleTreasures.size(); i++) {
                 for (int j=0; j< v.size(); j++) {
                    if (specificVisibleTreasures.get(i) == v.get(i).getType()) {
                         visible.add(v.get(j).getType());
                        break;
                    } 
                }
            }     
        if(!h.isEmpty() && specificHiddenTreasures != null)
            for (int i=0; i<specificHiddenTreasures.size(); i++) {
                for (int j=0; j< h.size(); j++) {
                    if (specificHiddenTreasures.get(i) == h.get(j).getType()) {
                         hidden.add(h.get(j).getType());
                            break;
                    }
                }
            }         
        SpecificBadConsequence bc = new SpecificBadConsequence("Ajuste.", 0, visible, hidden);         
     return bc;            
    }
    //devuelve un String con el estado del objeto
    @Override
    public String toString(){
        
        String mensaje = new String();
        
        if(!specificVisibleTreasures.isEmpty()){
            mensaje += "\nTesoros visibles Perdidos = " + specificVisibleTreasures+ " ";
            for( TreasureKind tsr: specificVisibleTreasures);    
        }
        if(!specificHiddenTreasures.isEmpty()){
            mensaje += "\nTesoros ocultos perdidos = " + specificHiddenTreasures+ " ";
            for( TreasureKind tsr: specificHiddenTreasures);
        }
    return mensaje;
    }
    
    
    
    
}//class

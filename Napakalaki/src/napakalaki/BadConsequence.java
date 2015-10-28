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
public class BadConsequence {
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    
    //Atributos de tipo Lista TreasureKind
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    //constructor
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }
    //constructor        
    public BadConsequence(String text, boolean death){
        this.text = text;
        this.death = death;
    }
    //constructor
    BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
    }
    //consultores     
    public String getText(){
        return text;
    }
    public int getLevels(){
        return levels;
    }
    public int getnVisibleTreasures(){
        return nVisibleTreasures;
    }
    public int getnHiddenTreasures(){
        return nHiddenTreasures;
    }
     public boolean isDeath() {
        return death;
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
    //devuelve un String con el estado del objeto
    
    @Override
    public String toString(){
        
        String mensaje = new String();
        
        mensaje += "\nNiveles Perdidos = " + levels;
        if(nVisibleTreasures != 0){
            mensaje += "\nTesoros visibles Perdidos = " + nVisibleTreasures + " ";
            for( TreasureKind tsr: specificVisibleTreasures);    
        }
        if(nHiddenTreasures != 0){
            mensaje += "\nTesoros ocultos perdidos = " + nHiddenTreasures + " ";
            for( TreasureKind tsr: specificHiddenTreasures);
        }
        if(death==true)
            mensaje += "\nMuerto: SI" + " ";
    
    return mensaje;
    }
  
        
        
        
        
        
        
}
    
    
    
    
    
    
    
   

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Fco M Guerrero Jimènez
 */
public class PruebaNapakalaki {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    //Creando los objetos bueno,malo y Monster
        Prize pzr = new Prize(2,5);
        BadConsequence bc = new BadConsequence(" ",5,7,3);
        Monster monstruillo = new Monster("Monstruillo",4,bc,pzr);
        
     //Mostrar la informacion del mostruillo
     System.out.print(monstruillo);
   
    //Probamos el dado
     System.out.print("\n*****************************************");
     System.out.print("\n         Prueba del DADO                 ");
     System.out.print("\n       Resultado Obtenido " + Dice.getInstance().nextNumber());
     System.out.print("\n*****************************************");
    
    } //main
    
} //class

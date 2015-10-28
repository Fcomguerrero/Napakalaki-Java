/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author fcis
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
     //System.out.print(monstruillo);
     
     //Lista de Monstruos
     ArrayList<Monster> monstruos = new ArrayList();
     
     //************************************************************************
    BadConsequence badConsequence = new BadConsequence("Pierdes 5 niveles y 3"
            + " tesoros visibles", 5, 3, 0);
    Prize prize = new Prize(4,2);
    monstruos.add(new Monster("El rey de rosa", 13, badConsequence,prize));
    //**************************************************************************
    BadConsequence badConsequence1 = new BadConsequence("Te atrapan para llevarte "
            + "de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano "
            + "visible y 1 mano oculta",0,
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), // Pierdes visibles
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND))); //Pierdes ocultos
    Prize prize1 = new Prize(4,1);
    monstruos.add(new Monster("Ángeles de la noche ibicenca", 14,badConsequence1, prize1));
    //**************************************************************************
    BadConsequence badConsequence2 = new BadConsequence("Pierdes tu armadura\n" +
                " visible y otra oculta", 0,
            new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
            new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
    Prize prize2 = new Prize(2,1);
    monstruos.add(new Monster("3 Byakhees de bonanza", 8, badConsequence2,prize2));
    //**************************************************************************
    BadConsequence badConsequence4 = new BadConsequence("Embobados con el lindo "
            + "primigenio te descartas de tu casco visible",0,
            new ArrayList(Arrays.asList(TreasureKind.HELMET)),
            new ArrayList(Arrays.asList()));
    Prize prize4 = new Prize(1,1);
    monstruos.add(new Monster("Chibithulhu",2,badConsequence4,prize4));
    //**************************************************************************
     BadConsequence badConsequence5 = new BadConsequence("El primordial bostezo\n" +
            " contagioso. Pierdes el calzado visible",0,
             new ArrayList(Arrays.asList(TreasureKind.SHOES)),
             new ArrayList(Arrays.asList()));
    Prize prize5 = new Prize(1,1);
    monstruos.add(new Monster("El sopor de Dunwich",2,badConsequence5,prize5));
    //**************************************************************************
     BadConsequence badConsequence6 = new BadConsequence("Pierdes todos tus tesoros\n" +
        " visibles",0,10,0);
    Prize prize6 = new Prize(3,1);                                     
    monstruos.add(new Monster("El gorrón en el umbral",10,badConsequence6,prize6));
    //**************************************************************************
     BadConsequence badConsequence7 = new BadConsequence("Pierdes la armadura\n" +
            " visible",0,
             new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
             new ArrayList(Arrays.asList()));  
    Prize prize7 = new Prize(2,1);
    monstruos.add(new Monster("H.P Munchcraft",6,badConsequence7,prize7));
    //**************************************************************************
    BadConsequence badConsequence8 = new BadConsequence("Sientes bichos bajo la\n" +
        " ropa. Descarta la armadura visible",0,
            new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
            new ArrayList(Arrays.asList()));
    Prize prize8 = new Prize(1,1);
    monstruos.add(new Monster("Bichgooth",2,badConsequence8,prize8));
    //**************************************************************************
    BadConsequence badConsequence10 = new BadConsequence("Toses los pulmones y\n" +
        " pierdes 2 niveles.",2,0,0);
    Prize prize10 = new Prize(1,1);
    monstruos.add(new Monster("La que redacta en las tinieblas",2,badConsequence10,prize10));
    //**************************************************************************
    BadConsequence badConsequence11 = new BadConsequence("Estos monstruos resultan\n" +
        " bastante superficiales y te aburren mortalmente. Estas muerto",true);
    Prize prize11 = new Prize(2,1);
    monstruos.add(new Monster("Los hondos",8,badConsequence11,prize11));
    //**************************************************************************
    BadConsequence badConsequence12 = new BadConsequence("Pierdes 2 niveles y 2\n" +
        " tesoros ocultos.",2,0,2);
    Prize prize12 = new Prize(2,1);
    monstruos.add(new Monster("Semillas Cthulhu",4,badConsequence12,prize12));
    //**************************************************************************
    BadConsequence badConsequence13 = new BadConsequence("Te intentas escaquear.\n" +
        " Pierdes una mano visible.",0,
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
            new ArrayList(Arrays.asList()));
    Prize prize13 = new Prize(2,1);
    monstruos.add(new Monster("Dameargo",1,badConsequence13,prize13));
    //**************************************************************************
    BadConsequence badConsequence14 = new BadConsequence("Da mucho asquito.\n" +
        "Pierdes 3 niveles.",3,0,0);
    Prize prize14 = new Prize(1,1);
    monstruos.add(new Monster("Pollipolipo volante",3,badConsequence14,prize14));
    //**************************************************************************
    BadConsequence badConsequence15 = new BadConsequence("No le hace gracia que\n" +
        " pronuncien mal su nombre. Estas muerto",true);
    Prize prize15 = new Prize(3,1);
    monstruos.add(new Monster("YskhtihyssgGoth",12,badConsequence15,prize15));
    //**************************************************************************
    BadConsequence badConsequence16 = new BadConsequence("La familia te atrapa.\n" +
        " Estas muerto.",true);
    Prize prize16 = new Prize(4,1);
    monstruos.add(new Monster("Familia feliz",1,badConsequence16,prize16));
    //**************************************************************************
    BadConsequence badConsequence17 = new BadConsequence("La quinta directiva\n" +
    " primaria te obliga a perder 2 niveles y un tesoro 2 manos visible",2,
            new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
            new ArrayList(Arrays.asList()));
    Prize prize17 = new Prize(2,1);
    monstruos.add(new Monster("Roboggoth",8,badConsequence17,prize17));
    //**************************************************************************
    BadConsequence badConsequence18 = new BadConsequence("Te asusta en la noche."
            + " Pierdes un casco visible.",0,
            new ArrayList(Arrays.asList(TreasureKind.HELMET)),
            new ArrayList(Arrays.asList()));
    Prize prize18 = new Prize(1,1);
    monstruos.add(new Monster("El espia",5,badConsequence18,prize18));
    //**************************************************************************
    BadConsequence badConsequence19 = new BadConsequence("Menudo susto te llevas."
            + " Pierdes 2 niveles y 5 tesoros visibles.",2,5,0);
    Prize prize19 = new Prize(1,1);
    monstruos.add(new Monster("El Lenguas",20,badConsequence19,prize19));
    //**************************************************************************
    BadConsequence badConsequence20 = new BadConsequence("Te faltan manos para tanta"
            + " cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.",3,
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.BOTHHANDS)),
            new ArrayList(Arrays.asList()));
    Prize prize20 = new Prize(1,1);
    monstruos.add(new Monster("Bicefalo",20,badConsequence20,prize20));
    //**************************************************************************
        
    //Consulta 1
     System.out.print("*****Tienen un nivel de combate superior a 10***");
            for(int i=0; i<monstruos.size(); i++){
                int nivel=0;
                nivel = monstruos.get(i).getCombatLevel();
                if(nivel>10)
                    System.out.print(monstruos.get(i));
            }
    //Consulta 2
    System.out.print("\nTienen un mal Rollo que implica solo perdida de niveles");
            for(int i=0; i<monstruos.size(); i++){
                   BadConsequence bcc = monstruos.get(i).bc;
                 if(bcc.getLevels() > 0 && 
                          bcc.getnHiddenTreasures()==0 &&  bcc.getnVisibleTreasures()== 0 && 
                          bcc.listaVisiblesVacia() && bcc.listaOcultoVacia())
                      System.out.print(monstruos.get(i));
     }
    //Consulta 3
    System.out.print("\nSu buen rollo indica una ganancia de niveles superior a 1");
            for(int i=0; i<monstruos.size(); i++){
                 Prize pzrce = monstruos.get(i).price;
                if(pzrce.getLevel() > 1)
                 System.out.print(monstruos.get(i));    
            }
    //Consulta 4               
    System.out.print("\nMal Rollo con perdida de algun tipo de tesoro Visibles o Ocultos");
        for(int i=0; i<monstruos.size(); i++){
            if(monstruos.get(i).bc.getnHiddenTreasures() > 0 || 
                    monstruos.get(i).bc.getnVisibleTreasures() > 0 || 
                    monstruos.get(i).bc.getSpecificVisibleTreasures() != null ||
                    monstruos.get(i).bc.getSpecificHiddenTreasures()!= null);
                System.out.print(monstruos.get(i));
    }
        
    /* ******************************************************* OTRAS PRUEBAS
    ArrayList<Prize>buenmonstruo = new ArrayList();
   // ArrayList<BadConsequence> Malmonstruo = new ArrayList();
    
    System.out.print("monstruillo en array de los buenos");
     
        for(int i=0; i<monstruos.size(); i++){
            //if (monstruos.get(i).getName()=="El Lenguas")
                buenmonstruo.add(monstruillo.price);}
        for(int i=0; i<buenmonstruo.size(); i++)
        System.out.println(buenmonstruo.get(i));        
  */              
                    
                    
                   
    } //main
    
} //class

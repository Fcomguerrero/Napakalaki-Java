/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Fco M Guerrero Jimènez
 */
public class CardDealer {
    
    //<<SINGLETON>>
    private static final CardDealer instance = new CardDealer();
    //El constructor privado asegura que no se puede instanciar desde otras clases
    private CardDealer() {}
    public static CardDealer getInstance(){
        return instance;
    }
    
    //ArrayList de Monstruos y Tesoros
     private ArrayList<Monster> unusedMonsters = new ArrayList();
     private ArrayList<Monster> usedMonsters = new ArrayList();
     private ArrayList<Treasure> unusedTreasures = new ArrayList();
     private ArrayList<Treasure> usedTreasures = new ArrayList();
    
     
     public void initCards(){
        initMonsterCardDeck();
        initTreasureCardDeck();
     }
          
    private void initMonsterCardDeck(){
    //************************************************************************
    BadConsequence badConsequence = new BadConsequence("Pierdes 5 niveles y 3"
            + " tesoros visibles", 5, 3, 0);
    Prize prize = new Prize(4,2);
    unusedMonsters.add(new Monster("El rey de rosa", 13, badConsequence,prize));
    //**************************************************************************
    BadConsequence badConsequence1 = new BadConsequence("Te atrapan para llevarte "
            + "de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano "
            + "visible y 1 mano oculta",0,
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), // Pierdes visibles
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND))); //Pierdes ocultos
    Prize prize1 = new Prize(4,1);
    unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14,badConsequence1, prize1));
    //**************************************************************************
    BadConsequence badConsequence2 = new BadConsequence("Pierdes tu armadura\n" +
                " visible y otra oculta", 0,
            new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
            new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
    Prize prize2 = new Prize(2,1);
    unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, badConsequence2,prize2));
    //**************************************************************************
    BadConsequence badConsequence4 = new BadConsequence("Embobados con el lindo "
            + "primigenio te descartas de tu casco visible",0,
            new ArrayList(Arrays.asList(TreasureKind.HELMET)),
            new ArrayList(Arrays.asList()));
    Prize prize4 = new Prize(1,1);
    unusedMonsters.add(new Monster("Chibithulhu",2,badConsequence4,prize4));
    //**************************************************************************
     BadConsequence badConsequence5 = new BadConsequence("El primordial bostezo\n" +
            " contagioso. Pierdes el calzado visible",0,
             new ArrayList(Arrays.asList(TreasureKind.SHOES)),
             new ArrayList(Arrays.asList()));
    Prize prize5 = new Prize(1,1);
    unusedMonsters.add(new Monster("El sopor de Dunwich",2,badConsequence5,prize5));
    //**************************************************************************
     BadConsequence badConsequence6 = new BadConsequence("Pierdes todos tus tesoros\n" +
        " visibles",0,BadConsequence.MAXTREASURES,0);
    Prize prize6 = new Prize(3,1);                                     
    unusedMonsters.add(new Monster("El gorrón en el umbral",10,badConsequence6,prize6));
    //**************************************************************************
     BadConsequence badConsequence7 = new BadConsequence("Pierdes la armadura\n" +
            " visible",0,
             new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
             new ArrayList(Arrays.asList()));  
    Prize prize7 = new Prize(2,1);
    unusedMonsters.add(new Monster("H.P Munchcraft",6,badConsequence7,prize7));
    //**************************************************************************
    BadConsequence badConsequence8 = new BadConsequence("Sientes bichos bajo la\n" +
        " ropa. Descarta la armadura visible",0,
            new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
            new ArrayList(Arrays.asList()));
    Prize prize8 = new Prize(1,1);
    unusedMonsters.add(new Monster("Bichgooth",2,badConsequence8,prize8));
    //**************************************************************************
    BadConsequence badConsequence10 = new BadConsequence("Toses los pulmones y\n" +
        " pierdes 2 niveles.",2,0,0);
    Prize prize10 = new Prize(1,1);
    unusedMonsters.add(new Monster("La que redacta en las tinieblas",2,badConsequence10,prize10));
    //**************************************************************************
    BadConsequence badConsequence11 = new BadConsequence("Estos monstruos resultan\n" +
        " bastante superficiales y te aburren mortalmente. Estas muerto",true);
    Prize prize11 = new Prize(2,1);
    unusedMonsters.add(new Monster("Los hondos",8,badConsequence11,prize11));
    //**************************************************************************
    BadConsequence badConsequence12 = new BadConsequence("Pierdes 2 niveles y 2\n" +
        " tesoros ocultos.",2,0,2);
    Prize prize12 = new Prize(2,1);
    unusedMonsters.add(new Monster("Semillas Cthulhu",4,badConsequence12,prize12));
    //**************************************************************************
    BadConsequence badConsequence13 = new BadConsequence("Te intentas escaquear.\n" +
        " Pierdes una mano visible.",0,
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
            new ArrayList(Arrays.asList()));
    Prize prize13 = new Prize(2,1);
    unusedMonsters.add(new Monster("Dameargo",1,badConsequence13,prize13));
    //**************************************************************************
    BadConsequence badConsequence14 = new BadConsequence("Da mucho asquito.\n" +
        "Pierdes 3 niveles.",3,0,0);
    Prize prize14 = new Prize(1,1);
    unusedMonsters.add(new Monster("Pollipolipo volante",3,badConsequence14,prize14));
    //**************************************************************************
    BadConsequence badConsequence15 = new BadConsequence("No le hace gracia que\n" +
        " pronuncien mal su nombre. Estas muerto",true);
    Prize prize15 = new Prize(3,1);
    unusedMonsters.add(new Monster("YskhtihyssgGoth",12,badConsequence15,prize15));
    //**************************************************************************
    BadConsequence badConsequence16 = new BadConsequence("La familia te atrapa.\n" +
        " Estas muerto.",true);
    Prize prize16 = new Prize(4,1);
    unusedMonsters.add(new Monster("Familia feliz",1,badConsequence16,prize16));
    //**************************************************************************
    BadConsequence badConsequence17 = new BadConsequence("La quinta directiva\n" +
    " primaria te obliga a perder 2 niveles y un tesoro 2 manos visible",2,
            new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
            new ArrayList(Arrays.asList()));
    Prize prize17 = new Prize(2,1);
    unusedMonsters.add(new Monster("Roboggoth",8,badConsequence17,prize17));
    //**************************************************************************
    BadConsequence badConsequence18 = new BadConsequence("Te asusta en la noche."
            + " Pierdes un casco visible.",0,
            new ArrayList(Arrays.asList(TreasureKind.HELMET)),
            new ArrayList(Arrays.asList()));
    Prize prize18 = new Prize(1,1);
    unusedMonsters.add(new Monster("El espia",5,badConsequence18,prize18));
    //**************************************************************************
    BadConsequence badConsequence19 = new BadConsequence("Menudo susto te llevas."
            + " Pierdes 2 niveles y 5 tesoros visibles.",2,5,0);
    Prize prize19 = new Prize(1,1);
    unusedMonsters.add(new Monster("El Lenguas",20,badConsequence19,prize19));
    //**************************************************************************
    BadConsequence badConsequence20 = new BadConsequence("Te faltan manos para tanta"
            + " cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.",3,
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.BOTHHANDS)),
            new ArrayList(Arrays.asList()));
    Prize prize20 = new Prize(1,1);
    unusedMonsters.add(new Monster("Bicefalo",20,badConsequence20,prize20));
    //**************************************************************************    
    
    }//fin initMonsterCardDeck
    
    //public Treasure(String name, int bonus,  TreasureKind type )
    private void initTreasureCardDeck(){
        
unusedTreasures.add(new Treasure("¡Si mi amo!", 4, TreasureKind.HELMET));
unusedTreasures.add(new Treasure("Botas de investigacion", 3, TreasureKind.SHOES));
unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET));
unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR));
unusedTreasures.add(new Treasure("Botas de lluvia acida", 1, TreasureKind.BOTHHANDS));
unusedTreasures.add(new Treasure("Casco minero", 2, TreasureKind.HELMET));
unusedTreasures.add(new Treasure("Ametralladora Thompson", 4, TreasureKind.BOTHHANDS));
unusedTreasures.add(new Treasure("Camiseta de la UGR", 1, TreasureKind.BOTHHANDS));
unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND));
unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND));
unusedTreasures.add(new Treasure("Fez alopodo", 3, TreasureKind.HELMET));
unusedTreasures.add(new Treasure("Hacha prehistorica", 2, TreasureKind.ONEHAND));
unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR));
unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS ));
unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND));
unusedTreasures.add(new Treasure("Escopeta de 3 canones", 4, TreasureKind.BOTHHANDS));
unusedTreasures.add(new Treasure("Garabato mistico", 2, TreasureKind.ONEHAND));
unusedTreasures.add(new Treasure("La rebeca metalica", 2, TreasureKind.ARMOR));
unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS));
unusedTreasures.add(new Treasure("Necro-comicon", 1, TreasureKind.ONEHAND));
unusedTreasures.add(new Treasure("Necronomicon", 5, TreasureKind.BOTHHANDS));
unusedTreasures.add(new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS));
unusedTreasures.add(new Treasure("Necrog-nomicon", 2, TreasureKind.ONEHAND));
unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
unusedTreasures.add(new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND));
unusedTreasures.add(new Treasure("Necroplayboycon", 3, TreasureKind.ONEHAND));
unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND));
unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS));
unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND));
unusedTreasures.add(new Treasure("Tentaculo de pega", 2, TreasureKind.HELMET));
unusedTreasures.add(new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES));

}//initTreasureCardDeck
    
    //Baraja el mazo de cartas de tesoros unusedTreasures.
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);       
    }
    //Baraja el mazo de cartas de Monsters unusedMonsters.
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }
    //Introduce en el mazo de descartes de tesoros (usedTreasures) el tesoro t.
    public void giveTreasureBack(Treasure t){
        this.usedTreasures.add(t);
    }
    //Introduce en el mazo de descartes de monstruos (usedMonsters) al monstruo m.
    public void giveMonsterBack(Monster m){
        this.usedMonsters.add(m);  
    }
    public Treasure nextTreasure(){
        Treasure next;
        if(unusedTreasures.isEmpty()){
            unusedTreasures = usedTreasures;
        Collections.shuffle(unusedTreasures);      
        usedTreasures.clear();
        }
        next = unusedTreasures.get(0);
        unusedTreasures.remove(next);
        return next;
    }
    public Monster nextMonster(){
        Monster next;
        if(unusedMonsters.isEmpty()){
            unusedMonsters = usedMonsters;
        Collections.shuffle(unusedMonsters);
        usedMonsters.clear();
        }
        next = unusedMonsters.get(0);
        unusedMonsters.remove(next);
        return next;
    }
    
    
    
    
    
    
   
    
}//clase 

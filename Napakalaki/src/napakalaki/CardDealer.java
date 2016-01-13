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
 * @author Fco Manuel Guerrero Jimènez
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
     ArrayList<Monster> unusedMonsters = new ArrayList();
     ArrayList<Monster> usedMonsters = new ArrayList();
     ArrayList<Treasure> unusedTreasures = new ArrayList();
     ArrayList<Treasure> usedTreasures = new ArrayList();
     ArrayList<Cultist> unusedCultists = new ArrayList();
    
     
     public void initCards(){ 
        initMonsterCardDeck();
        initTreasureCardDeck();
        intiCultistCardDeck();
     }
          
    private void initMonsterCardDeck(){
    //************************************************************************
    NumericBadConsequence NbadConse = new NumericBadConsequence("Pierdes 5 niveles y 3"
            + " tesoros visibles", 5, 3, 0);
    Prize priz = new Prize(4,2);
    unusedMonsters.add(new Monster("El rey de rosa", 13, NbadConse,priz,0));
    //**************************************************************************
    SpecificBadConsequence SpbadConse = new SpecificBadConsequence("Te atrapan para llevarte "
            + "de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano "
            + "visible y 1 mano oculta",0,
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), // Pierdes visibles
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND))); //Pierdes ocultos
    priz = new Prize(4,1);
    unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, SpbadConse, priz,0));
    //**************************************************************************
    SpbadConse = new SpecificBadConsequence("Pierdes tu armadura\n" +
                " visible y otra oculta", 0,
            new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
            new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
    priz = new Prize(2,1);
    unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, SpbadConse,priz,0));
    //**************************************************************************
    SpbadConse = new SpecificBadConsequence("Embobados con el lindo "
            + "primigenio te descartas de tu casco visible",0,
            new ArrayList(Arrays.asList(TreasureKind.HELMET)),
            new ArrayList(Arrays.asList()));
    priz = new Prize(1,1);
    unusedMonsters.add(new Monster("Chibithulhu",2,SpbadConse,priz,0));
    //**************************************************************************
    SpbadConse = new SpecificBadConsequence("El primordial bostezo\n" +
            " contagioso. Pierdes el calzado visible",0,
             new ArrayList(Arrays.asList(TreasureKind.SHOES)),
             new ArrayList(Arrays.asList()));
    priz = new Prize(1,1);
    unusedMonsters.add(new Monster("El sopor de Dunwich",2,SpbadConse,priz,0));
    //**************************************************************************
     NbadConse = new NumericBadConsequence("Pierdes todos tus tesoros\n" +
        " visibles",0,BadConsequence.MAXTREASURES,0);
    priz = new Prize(3,1);                                     
    unusedMonsters.add(new Monster("El gorrón en el umbral",10,NbadConse,priz,0));
    //**************************************************************************
    SpbadConse = new SpecificBadConsequence("Pierdes la armadura\n" +
            " visible",0,
             new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
             new ArrayList(Arrays.asList()));  
    priz = new Prize(2,1);
    unusedMonsters.add(new Monster("H.P Munchcraft",6,SpbadConse,priz,0));
    //**************************************************************************
    SpbadConse = new SpecificBadConsequence("Sientes bichos bajo la\n" +
        " ropa. Descarta la armadura visible",0,
            new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
            new ArrayList(Arrays.asList()));
    priz = new Prize(1,1);
    unusedMonsters.add(new Monster("Bichgooth",2,SpbadConse,priz,0));
    //**************************************************************************
    NbadConse = new NumericBadConsequence("Toses los pulmones y\n" +
        " pierdes 2 niveles.",2,0,0);
    priz = new Prize(1,1);
    unusedMonsters.add(new Monster("La que redacta en las tinieblas",2,NbadConse,priz,0));
    //**************************************************************************
    DeathBadConsequence DbadConse = new DeathBadConsequence("Estos monstruos resultan\n" +
        " bastante superficiales y te aburren mortalmente. Estas muerto");
    priz = new Prize(2,1);
    unusedMonsters.add(new Monster("Los hondos",8,DbadConse,priz,0));
    //**************************************************************************
    NbadConse = new NumericBadConsequence("Pierdes 2 niveles y 2\n" +
        " tesoros ocultos.",2,0,2);
    priz = new Prize(2,1);
    unusedMonsters.add(new Monster("Semillas Cthulhu",4,NbadConse,priz,0));
    //**************************************************************************
    SpbadConse = new SpecificBadConsequence("Te intentas escaquear.\n" +
        " Pierdes una mano visible.",0,
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
            new ArrayList(Arrays.asList()));
    priz = new Prize(2,1);
    unusedMonsters.add(new Monster("Dameargo",1,SpbadConse,priz,0));
    //**************************************************************************
    NbadConse = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles.",3,0,0);
    priz = new Prize(1,1);
    unusedMonsters.add(new Monster("Pollipolipo volante",3,NbadConse,priz,0));
    //**************************************************************************
    DbadConse = new DeathBadConsequence("No le hace gracia que\n" +
        " pronuncien mal su nombre. Estas muerto");
    priz = new Prize(3,1);
    unusedMonsters.add(new Monster("YskhtihyssgGoth",12,DbadConse,priz,0));
    //**************************************************************************
    DbadConse = new DeathBadConsequence("La familia te atrapa. Estas muerto.");
    priz = new Prize(4,1);
    unusedMonsters.add(new Monster("Familia feliz",1,DbadConse,priz,0));
    //**************************************************************************
    SpbadConse = new SpecificBadConsequence("La quinta directiva\n" +
    " primaria te obliga a perder 2 niveles y un tesoro 2 manos visible",2,
            new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
            new ArrayList(Arrays.asList()));
    priz = new Prize(2,1);
    unusedMonsters.add(new Monster("Roboggoth",8,SpbadConse,priz,0));
    //**************************************************************************
    SpbadConse = new SpecificBadConsequence("Te asusta en la noche."
            + " Pierdes un casco visible.",0,
            new ArrayList(Arrays.asList(TreasureKind.HELMET)),
            new ArrayList(Arrays.asList()));
    priz = new Prize(1,1);
    unusedMonsters.add(new Monster("El espia",5,SpbadConse,priz,0));
    //**************************************************************************
    NbadConse = new NumericBadConsequence("Menudo susto te llevas."
            + " Pierdes 2 niveles y 5 tesoros visibles.",2,5,0);
    priz = new Prize(1,1);
    unusedMonsters.add(new Monster("El Lenguas",20,NbadConse,priz,0));
    //**************************************************************************
    SpbadConse = new SpecificBadConsequence("Te faltan manos para tanta"
            + " cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.",3,
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.BOTHHANDS)),
            new ArrayList(Arrays.asList()));
    priz = new Prize(1,1);
    unusedMonsters.add(new Monster("Bicefalo",20,SpbadConse,priz,0));
    //**************************************************************************
    //SECTARIO#SECTARIO#SECTARIO#SECTARIO#SECTARIO#SECTARIO#SECTARIO#SECTARIO#SECTARIO#
    //SECTARIO#SECTARIO#SECTARIO#SECTARIO#SECTARIO#SECTARIO#SECTARIO#SECTARIO#SECTARIO#    
    SpbadConse = new SpecificBadConsequence("Pierdes 1 mano visible",0,
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
            new ArrayList(Arrays.asList()));
    priz = new Prize(3,1);
    unusedMonsters.add(new Monster("El mal indecible impronunciable",10,SpbadConse,priz,-2));
    //**************************************************************************
    NbadConse = new NumericBadConsequence("Pierdes tus tesoros visibles. Jajaja.",
            0,BadConsequence.MAXTREASURES,0);              
    priz = new Prize(2,1);
    unusedMonsters.add(new Monster("Testigos Oculares",6,NbadConse,priz,2));
    //**************************************************************************
    DbadConse = new DeathBadConsequence("Hoy no es tu dia de suerte. Mueres.");
    priz = new Prize(2,5);
    unusedMonsters.add(new Monster("El gran cthulhu",20,DbadConse,priz,4));
    //**************************************************************************
    NbadConse = new NumericBadConsequence("Tu gobierno te recorta 2 niveles.",2,0,0);       
    priz = new Prize(2,1);
    unusedMonsters.add(new Monster("Serpiente Politico",8,NbadConse,priz,-2));
    //**************************************************************************
    SpbadConse = new SpecificBadConsequence("Pierdes tu casco y tu\n" +
"armadura visible. Pierdes tus manos ocultas.",0,
            new ArrayList(Arrays.asList(TreasureKind.HELMET,TreasureKind.ARMOR)),
            new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.BOTHHANDS)));
    priz = new Prize(1,1);
    unusedMonsters.add(new Monster("Felpuggoth",2,SpbadConse,priz,5));
    //**************************************************************************
    NbadConse = new NumericBadConsequence("Pierdes 2 niveles.",2,0,0);
    priz = new Prize(4,2);
    unusedMonsters.add(new Monster("Shoggoth",16,NbadConse,priz,-4));
    //**************************************************************************
    NbadConse = new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles.",2,0,0);         
    priz = new Prize(1,1);
    unusedMonsters.add(new Monster("Lolitagooth",2,NbadConse,priz,3));
    //**************************************************************************
    shuffleMonsters();
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
shuffleTreasures();

}//initTreasureCardDeck
    
private void intiCultistCardDeck(){
    unusedCultists.add(new Cultist("Sectario",1));
    unusedCultists.add(new Cultist("Sectario",2));
    unusedCultists.add(new Cultist("Sectario",1));
    unusedCultists.add(new Cultist("Sectario",2));
    unusedCultists.add(new Cultist("Sectario",1));   
    unusedCultists.add(new Cultist("Sectario",1));
    shuffleCultists();
}    
    
    //Baraja el mazo de cartas de tesoros unusedTreasures.
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);       
    }
    //Baraja el mazo de cartas de Monsters unusedMonsters.
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }
    //Baraja el mazo de cartas de Cultist unusedCultists
    private void shuffleCultists(){
        Collections.shuffle(unusedCultists);
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
        usedTreasures.clear();
            shuffleTreasures();              
        }
        next = unusedTreasures.get(0);
        unusedTreasures.remove(next);
        return next;
    }
    public Monster nextMonster(){        
        if(unusedMonsters.isEmpty()){
            unusedMonsters = usedMonsters;
            usedMonsters.clear();
        shuffleMonsters();      
        }   
       Monster next = unusedMonsters.get(0);
       unusedMonsters.remove(0);
        return next;
    }
    //next carta de Sectario
    public Cultist nextCultist(){
        Cultist next;
        next = unusedCultists.get(0);
        unusedCultists.remove(0);
        return next;
    }
              
}//clase 

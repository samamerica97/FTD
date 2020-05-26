/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FTD_Project.Model;

import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Random;

/**
 * In het spel FTD is een beurt van een speler opgedeeld in verschillende delen met verschillende mogelijkheden.
 * De logica achter het spel.
 * 
 * @author Sam America & Olivier Lenaerts
 */
public class Kaartspel {
    /** het pak speelkaarten */
    private PakKaarten deck;
    /** de spelerslijst */
    private ArrayList<Spelers> spelerLijst;
    /** de index van de spelers */
    private int indexSpeler;
    /** de huidige kaart die getrokken is uit het pak kaarten */
    private Kaart huidigeKaart;
    /** het aantal keer gegokt */
    private int aantalGokken;
    /** de gegokte waarde */
    private int gok;
    /** het aantal keer na elkaar fout */
    private int aantalFouten;
    /** het aantal slokken wat uitgedeeld mag worden */
    private int aantalSlokken;
    
    /**
     * Constructor voor Kaartspel wordt verwezen naar initKaartspel() 
     */
    public Kaartspel() {
        initKaartspel();        
    }
    
    /**
     * Maak een nieuwe spelerslijst een nieuw pak speelkaarten en zet het aantal fouten op 0
     * 
     * @param spelerLijst de spelerlijst
     * @param deck het pak speelkaarten
     * @param aantalFouten het aantal fouten wat 0 is op het begin van het spel
     */
    private void initKaartspel(){
        spelerLijst = new ArrayList<>();
        this.deck = new PakKaarten();
        aantalFouten = 0;
    }
    
    /**
     * Vul de spelerlijst met namen
     * @param sp namen van de spelers die meedoen aan het spel
     */
    public void vulSpelersLijst(String sp){
        Spelers s = new Spelers(sp);
        getSpelerLijst().add(s);        
    }
    
    /**
     * Schud het pak kaarten op het begin van het spel en duid een willekeurige speler aan die mag beginnen
     */
    public void startSpel(){
        this.deck.schudden();
        Random r = new Random();
        indexSpeler = r.nextInt(getSpelerLijst().size()); //het spel beginnen bij een random speler in de spelerarray
    }
    
    /**
     * Raap een kaart van het pak speelkaarten en reset het aantal gokken 
     */
    public void raapKaart(){   
        aantalGokken = 0;
        huidigeKaart = deck.raapKaart();
    }
    
    /**
     * er is gegokt, verhoog het aantal keer gegokt met 1
     */
    public void gok(){
        aantalGokken ++;
    }
    
    /**
     * er is 2 keer fout gegokt, verhoog het aantal fouten met 1
     * het aantal slokken van de huidige speler wordt verhoogt met het verschil van de 2de gok en de kaartwaarde van de huidige kaart
     * indien het aantal fouten 3 is, krijgen alle spelers 2 slokken erbij en wordt het aantal fouten gereset
     * 
     * de huidige speler zijn totaal aantal slokken en fouten wordt verhoogd
     */
    public void foutGeraden(){ 
        aantalFouten ++;
        getSpelerLijst().get(getIndexSpeler()).setSlokken(getSpelerLijst().get(getIndexSpeler()).getSlokken()+Math.abs(gok-huidigeKaart.getWaarde()));
        getSpelerLijst().get(getIndexSpeler()).setTotaalSlokken(getSpelerLijst().get(getIndexSpeler()).getTotaalSlokken()+Math.abs(gok-huidigeKaart.getWaarde()));
        getSpelerLijst().get(getIndexSpeler()).setAantalFout(getSpelerLijst().get(getIndexSpeler()).getAantalFout()+1);     
        
        if (getAantalFouten() == 3){
            for (Spelers sp: spelerLijst){
                sp.setSlokken(sp.getSlokken()+2);
                sp.setTotaalSlokken(sp.getTotaalSlokken()+2);
            }
            aantalFouten = 0;
        }
    }
    
    /**
     * er is juist geraden, dus het aantal fouten wordt gereset
     * het aantal slokken wat uitgedeeld mag worden is bepaald
     * 
     * de huidige speler zijn totaal aantal keer juist wordt verhoogd
     */
    public void juistGeraden(){
        aantalFouten = 0;
        getSpelerLijst().get(getIndexSpeler()).setAantalJuist(getSpelerLijst().get(getIndexSpeler()).getAantalJuist()+1);
        if (aantalGokken == 1){
            aantalSlokken = 3;
        }
        else{
            aantalSlokken = 1;
        }
    }
    
    /**
     * de speler wordt veranderd naar de volgende uit de spelerlijst
     */
    public void volgendeSpeler(){
        if (indexSpeler == (spelerLijst.size()-1)){
            indexSpeler = 0;
        }else{
            indexSpeler ++;
        }
    }
    
    /**
     * indien er opnieuw wil gespeeld worden, verwezen naar initKaartspel()
     */
    public void speelOpnieuw(){
        initKaartspel();
    }
    
    /**
     * indien er niet meer opnieuw gespeeld wil worden, sluit het programma af 
     */
    public void exitSpel(){
        exit(0);
    }
    
    /**
     * wat is de huidige kaart?
     * @return de huidigeKaart
     */
    public Kaart getHuidigeKaart() {
        return huidigeKaart;
    }
    
    /**
     * hoeveel kaarten er over zijn
     * @return de hoeveelheid kaarten die over zijn
     */
    public int getKaartenOver(){
        return this.deck.kaartenOver();
    }
    
           
    /**
     * hoeveel keer er gegokt is
     * @return the aantalGokken
     */
    public int getAantalGokken() {
        return aantalGokken;
    }

    /**
     * wat er gegokt is
     * @return the gok
     */
    public int getGok() {
        return gok;
    }

    /**
     * @param gok de gegokte waarde setten
     */
    public void setGok(int gok) {
        this.gok = gok;
    }

    /**
     * @return de spelerLijst
     */
    public ArrayList<Spelers> getSpelerLijst() {
        return spelerLijst;
    }

    /**
     * het aantal slokken wat uitgedeeld mag worden
     * @return het aantalSlokken
     */
    public int getAantalSlokken() {
        return aantalSlokken;
    }

    /**
     * de index van de huidige speler
     * @return de indexSpeler
     */
    public int getIndexSpeler() {
        return indexSpeler;
    }

    /**
     * aantal keer dat er na elkaar fout gegokt is
     * @return het aantalFouten
     */
    public int getAantalFouten() {
        return aantalFouten;
    }
}

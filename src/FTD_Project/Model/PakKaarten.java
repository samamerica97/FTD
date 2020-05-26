/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FTD_Project.Model;

import java.util.Random;

/**
 * Het genereren van een pak kaarten
 * 
 * @author Sam America & Olivier Lenaerts
 */
public class PakKaarten {
    /** een array deck waar 52 verschillende kaarten in komen */
    private final Kaart[] deck;
    /** het aantal kaarten wat gespeeld is */
    private int kaartenGebruikt;
    
    /**
     * Constructor voor een pak speelkaarten te maken en deze vullen met alle mogelijke kaarten in een kaartspel
     */
    public PakKaarten() {
        deck = new Kaart[52];        
        int i = 0; //het deck vullen met kaarten
        for (int soort = 0; soort <= 3; soort++){
            for(int waarde = 1; waarde <=13; waarde++)
                deck[i++]=new Kaart(waarde,soort);
        }
        kaartenGebruikt = 0;
    }
    
    /**
     * het pak kaarten schudden in een random volgorde
     */
    public void schudden(){
        Random r = new Random();
        for (int i = 0; i < deck.length; i++){
            int random = r.nextInt(deck.length);
            Kaart temp = deck[i];
            deck[i]=deck[random];
            deck[random] = temp;
        }
        kaartenGebruikt = 0;
    }
    /**
     * hoeveel kaarten er nog over zijn
     * @return kaartenOver
     */
    public int kaartenOver(){
        return deck.length - kaartenGebruikt;
    }
    
    /**
     * een kaart rapen van het deck, verhoogt het aantal kaarten
     * @return deck zonder de gerapen kaart
     */
    public Kaart raapKaart(){
        kaartenGebruikt++;
        return deck[kaartenGebruikt-1];
    }
}

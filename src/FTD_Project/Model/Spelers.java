/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FTD_Project.Model;

/**
 * de eigenschappen van de spelers die in de spelerlijst komen
 * 
 * @author Sam America & Olivier Lenaerts
 */
public class Spelers {
    /** de naam van de speler */
    private String naam;
    /** het huidig aantal slokken van de speler */
    private int slokken;
    /** het totaal aantal slokken van de speler */
    private int totaalSlokken;
    /** het aantal keer dat de speler juist is */
    private int aantalJuist;
    /**het aantal keer dat de speler fout is */
    private int aantalFout;
    
    /**
     * Constructor voor spelers waarin alle eigenschappen worden gedefinieerd
     * @param naam de naam van de speler
     */
    public Spelers(String naam) {
        this.naam = naam;
        this.slokken = 0;
        this.totaalSlokken = 0;
        this.aantalFout = 0;
        this.aantalJuist = 0;
    }

    /**
     * @return de naam van de speler
     */
    public String getNaam() {
        return naam;
    }

    /**
     * @return het aantal slokken van de speler
     */
    public int getSlokken() {
        return slokken;
    }

    /**
     * @param slokken de slokken veranderen
     */
    public void setSlokken(int slokken) {
        this.slokken = slokken;
    }

    /**
     * @return het totaalSlokken van de speler
     */
    public int getTotaalSlokken() {
        return totaalSlokken;
    }

    /**
     * @param totaalSlokken the totaalSlokken to set
     */
    public void setTotaalSlokken(int totaalSlokken) {
        this.totaalSlokken = totaalSlokken;
    }

    /**
     * @return het aantalJuist 
     */
    public int getAantalJuist() {
        return aantalJuist;
    }

    /**
     * @param aantalJuist the aantalJuist to set
     */
    public void setAantalJuist(int aantalJuist) {
        this.aantalJuist = aantalJuist;
    }

    /**
     * @return the aantalFout
     */
    public int getAantalFout() {
        return aantalFout;
    }

    /**
     * @param aantalFout the aantalFout to set
     */
    public void setAantalFout(int aantalFout) {
        this.aantalFout = aantalFout;
    }
}

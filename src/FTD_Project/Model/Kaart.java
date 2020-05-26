/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FTD_Project.Model;

/**
 * de verschillende soorten kaarten aanmaken
 * 
 * @author Sam America & Olivier Lenaerts
 */

//inspiratie: http://www-h.eng.cam.ac.uk/help/importedHTML/languages/java/javanotes5.0.2/source/Card.java
public class Kaart {
    /**waardes van elke soort kaart*/
    private final int Koeken = 0;
    private final int Schuppen = 1;      
    private final int Klaveren = 2;
    private final int Harten = 3;

    
    /** de soort kaart */
    private final int soort;
    /** de waarde van de kaart */
    private final int waarde;
    
    //constructor
    public Kaart(int waarde, int soort) {
        this.soort = soort;
        this.waarde = waarde;
    }

    /**
     * @return de soort
     */
    public int getSoort() {
        return soort;
    }

    /**
     * @return de waarde
     */
    public int getWaarde() {
        return waarde;
    }
    
    /**
     * om de soort als een string te krijgen
     * @return soort als string
     */
    public String getSoortAlsString(){
        switch(soort){
            case Schuppen: return "Schuppen";
            case Harten: return "Harten";
            case Klaveren: return "Klaveren";
            default: return "Koeken";
        }
    }
    
    /**
     * om de waarde als een string te krijgen
     * @return waarde als string
     */
    public String getWaardeAlsString(){
        switch(waarde){
            case 1: return "Aas";
            case 2: return "Twee";
            case 3: return "Drie";
            case 4: return "Vier";
            case 5: return "Vijf";
            case 6: return "Zes";
            case 7: return "Zeven";
            case 8: return "Acht";
            case 9: return "Negen";
            case 10: return "Tien";
            case 11: return "Boer";
            case 12: return "Dame";
            default: return "Heer";
        }
    }
    
    
    /**
     * om de volledige kaart als een string te krijgen
     * @return soort en waarde als string
     */
    @Override
    public String toString(){
        return getSoortAlsString()+ " " + getWaardeAlsString();
    }    
}

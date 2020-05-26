/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FTD_Project.View;

import FTD_Project.Model.Kaartspel;        
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 *  In deze view worden de kaarten aangemaakt.
 * @author Sam America & Olivier Lenaerts
 */
public class KaartView extends Region{
    /** model kaartspel */
    private Kaartspel k;
    /** constructor van de kaartview*/
    public KaartView(Kaartspel k) {
        this.k = k;
    }
    
    /**
     * methode om de kaarten aan te maken en op het speelveld te tonen
     */
   
    public void update(){
        Image afbeelding;
        switch(k.getHuidigeKaart().getSoort()){
            case 1 : afbeelding = new javafx.scene.image.Image("/images/Schuppen.png", 0, 0, true, true); break;
            case 2 : afbeelding = new javafx.scene.image.Image("/images/Klaver.png", 0, 0, true, true); break;
            case 3 : afbeelding = new javafx.scene.image.Image("/images/Harten.png", 0, 0, true, true); break;
            default : afbeelding = new javafx.scene.image.Image("/images/Koeken.png", 0, 0, true, true);
        }        
        if(k.getHuidigeKaart().getSoort() == 0 || k.getHuidigeKaart().getSoort() == 3){
            Image nummer = null;
            switch(k.getHuidigeKaart().getWaarde()){
                case 1 : nummer = new javafx.scene.image.Image("/images/1R.png", 0, 0, true, true); break;
                case 2 : nummer = new javafx.scene.image.Image("/images/2R.png", 0, 0, false, false); break;
                case 3 : nummer = new javafx.scene.image.Image("/images/3R.png", 0, 0, false, false); break;
                case 4 : nummer = new javafx.scene.image.Image("/images/4R.png", 0, 0, false, false); break;
                case 5 : nummer = new javafx.scene.image.Image("/images/5R.png", 0, 0, false, false); break;
                case 6 : nummer = new javafx.scene.image.Image("/images/6R.png", 0, 0, false, false); break;
                case 7 : nummer = new javafx.scene.image.Image("/images/7R.png", 0, 0, false, false); break;
                case 8 : nummer = new javafx.scene.image.Image("/images/8R.png", 0, 0, false, false); break;
                case 9 : nummer = new javafx.scene.image.Image("/images/9R.png", 0, 0, false, false); break;
                case 10 : nummer = new javafx.scene.image.Image("/images/10R.png", 0, 0, false, false); break;
                case 11 : nummer = new javafx.scene.image.Image("/images/11R.png", 0, 0, false, false); break;
                case 12 : nummer = new javafx.scene.image.Image("/images/12R.png", 0, 0, false, false); break;
                case 13 : nummer = new javafx.scene.image.Image("/images/13R.png", 0, 0, false, false); break;
            }
            Rectangle vorm = new Rectangle(100,140);
            vorm.setFill(new ImagePattern(afbeelding));
            Rectangle nr = new Rectangle(100,140);
            nr.setFill(new ImagePattern(nummer));
            getChildren().addAll(nr,vorm);
        
        }
        else{
            Image nummer = null;
            switch(k.getHuidigeKaart().getWaarde()){
                case 1 : nummer = new javafx.scene.image.Image("/images/1Z.png", 0, 0, true, true); break;
                case 2 : nummer = new javafx.scene.image.Image("/images/2Z.png", 0, 0, false, false); break;
                case 3 : nummer = new javafx.scene.image.Image("/images/3Z.png", 0, 0, false, false); break;
                case 4 : nummer = new javafx.scene.image.Image("/images/4Z.png", 0, 0, false, false); break;
                case 5 : nummer = new javafx.scene.image.Image("/images/5Z.png", 0, 0, false, false); break;
                case 6 : nummer = new javafx.scene.image.Image("/images/6Z.png", 0, 0, false, false); break;
                case 7 : nummer = new javafx.scene.image.Image("/images/7Z.png", 0, 0, false, false); break;
                case 8 : nummer = new javafx.scene.image.Image("/images/8Z.png", 0, 0, false, false); break;
                case 9 : nummer = new javafx.scene.image.Image("/images/9Z.png", 0, 0, false, false); break;
                case 10 : nummer = new javafx.scene.image.Image("/images/10Z.png", 0, 0, false, false); break;
                case 11 : nummer = new javafx.scene.image.Image("/images/11Z.png", 0, 0, false, false); break;
                case 12 : nummer = new javafx.scene.image.Image("/images/12Z.png", 0, 0, false, false); break;
                case 13 : nummer = new javafx.scene.image.Image("/images/13Z.png", 0, 0, false, false); break;
            }
            Rectangle vorm = new Rectangle(100,140);
            vorm.setFill(new ImagePattern(afbeelding));
            Rectangle nr = new Rectangle(100,140);
            nr.setFill(new ImagePattern(nummer));
            getChildren().addAll(nr,vorm);
        }
    }        
}
        
    
    
    


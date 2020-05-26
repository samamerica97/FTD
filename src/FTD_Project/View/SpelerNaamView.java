/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FTD_Project.View;

import FTD_Project.Model.Kaartspel;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *  In deze view wordt afgebeeld welke speler aan de beurt is.
 * @author Sam America & Olivier Lenaerts
 */
public class SpelerNaamView extends Region{
    /** model van het kaartspel*/
    private Kaartspel model;
    
    public SpelerNaamView(Kaartspel model){
        this.model = model;
    }
    
    /**
     * tekst tonen van wie aan de beurt is. 
     */
    public void isAanDeBeurt(){
        getChildren().clear();
        Text speler = new Text(908,400,model.getSpelerLijst().get(model.getIndexSpeler()).getNaam() + "\n is aan de beurt\n trek een kaart!" );
        speler.setTextAlignment(TextAlignment.CENTER);
        speler.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),28));
        getChildren().add(speler);
    }
    
    /**
     * tekst terug weg doen.
     */
    public void update(){
        getChildren().clear();
    }       
}

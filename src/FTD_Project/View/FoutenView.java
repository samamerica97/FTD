/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FTD_Project.View;

import FTD_Project.Model.Kaartspel;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import static javafx.scene.paint.Color.BLACK;
import javafx.scene.text.Font;


/**
 *  het aantal fouten wordt weergegeven in een label
 * @author Sam America & Olivier Lenaerts
 */
public class FoutenView extends Region{
    /** model van het kaartspel*/
    private Kaartspel model;
    
    public FoutenView(Kaartspel model) {
        this.model = model;
    }  
    
    /**
     * het weergeven van het aantal fouten
     */
    public void update(){
        getChildren().clear();
        Label aantalKeerFout = new Label(model.getAantalFouten()+"");
        aantalKeerFout.setLayoutX(1085);
        aantalKeerFout.setLayoutY(431);
        aantalKeerFout.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),30));
        aantalKeerFout.setTextFill(BLACK);
        getChildren().add(aantalKeerFout);
    }
}

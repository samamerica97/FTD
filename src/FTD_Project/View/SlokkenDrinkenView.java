/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FTD_Project.View;

import FTD_Project.Model.Kaartspel;
import javafx.scene.control.Spinner;
import javafx.scene.layout.Region;

/**
 * Het kiezen van de hoeveelheid slokken die gedronken wordt op het einde van de beurt
 * @author Sam America & Olivier Lenaerts
 */
public class SlokkenDrinkenView extends Region {
    /** spinner voor het bepalen van de hoeveelheid slokken die gedronken wordt */
    private Spinner slokkenDrinken;
    /** model van het kaartspel */
    private Kaartspel model;

    public SlokkenDrinkenView(Kaartspel model) {
        this.model = model;
    }
    
    /** 
     * de spinner maken met een maximum gelijk aan het aantal slokken van de speler
     */
    public void update() {
        getChildren().clear();
        slokkenDrinken = new Spinner(1, model.getSpelerLijst().get(model.getIndexSpeler()).getSlokken(), 1, 1);
        slokkenDrinken.setLayoutX(35);
        slokkenDrinken.setLayoutY(68);
        slokkenDrinken.setPrefWidth(90);
        getChildren().add(slokkenDrinken);
    }
    
    /**
     * de waarde van de spinner 
     * @return de waarde aangeduid door de speler in de spinner
     */
    public int getWaardeSpinner(){
        return (int) slokkenDrinken.getValue();
    }
}

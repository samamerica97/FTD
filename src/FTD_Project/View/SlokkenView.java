/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FTD_Project.View;

import FTD_Project.Model.Kaartspel;
import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import static javafx.scene.paint.Color.WHITE;
import javafx.scene.text.Font;

/**
 * het aantal slokken van de verschillende spelers wordt hier weergegeven
 * @author Sam America & Olivier Lenaerts
 */
public class SlokkenView extends Region{
    /** model van het kaartspel */
    private Kaartspel model;
    /** arraylist van de labels met elke speler zijn slokken */
    private ArrayList<Label> slokkenLijst;

    public SlokkenView(Kaartspel model) {
        this.model = model;
        slokkenLijst = new ArrayList<>();
    }
    
    /**
     * het weergeven van de slokken van de spelers naast de spelernamen
     */
    public void update(){
        getChildren().clear();
        for (int i = 0; i<model.getSpelerLijst().size(); i++){
            Label spelerSlokken = new Label(model.getSpelerLijst().get(i).getSlokken()+"");
            spelerSlokken.setLayoutX(165);
            spelerSlokken.setLayoutY(53+i*30);
            spelerSlokken.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),14));
            spelerSlokken.setTextFill(WHITE);
            getChildren().add(spelerSlokken);
            slokkenLijst.add(spelerSlokken);
        }        
    }    
}

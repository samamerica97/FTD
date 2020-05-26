/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FTD_Project.View;

import FTD_Project.Model.Kaartspel;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import static javafx.scene.paint.Color.WHITE;
import javafx.scene.text.Font;

/**
 * het scorebord op het einde van het spel.
 * @author Sam America & Olivier Lenaerts
 */
public class ScorebordView extends Region{
    /** het model van het kaartspel */
    private Kaartspel model;
    /** het raster van het scorebord */
    private GridPane scorebord;

    public ScorebordView(Kaartspel model) {
        this.model = model;
        update();
    }
    
    /**
     * het aanmaken en vullen van het scorebord.
     */
    public void update(){
        getChildren().clear();
        
        scorebord = new GridPane();
        scorebord.setPadding(new Insets(10));
        scorebord.setHgap(15);
        scorebord.setVgap(15);
        
        Label spelerNaam = new Label("  Speler  ");
        spelerNaam.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),22));
        spelerNaam.setTextFill(WHITE);
        
        Label slokken = new Label("aantal slokken");
        slokken.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),22));
        slokken.setTextFill(WHITE);
        
        Label totaalSlokken = new Label("totaal slokken");
        totaalSlokken.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),22));
        totaalSlokken.setTextFill(WHITE);
        
        Label aantalFout = new Label("aantal fout");
        aantalFout.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),22));
        aantalFout.setTextFill(WHITE);
        
        Label aantalJuist = new Label("aantal juist");
        aantalJuist.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),22));
        aantalJuist.setTextFill(WHITE);
        
        GridPane.setConstraints(spelerNaam, 0, 0);
        GridPane.setConstraints(slokken, 1, 0);
        GridPane.setConstraints(totaalSlokken, 2, 0);
        GridPane.setConstraints(aantalFout, 3, 0);
        GridPane.setConstraints(aantalJuist, 4, 0);
        
        scorebord.getChildren().addAll(spelerNaam, aantalFout, aantalJuist, totaalSlokken, slokken);
        
        for(int i = 0; i<model.getSpelerLijst().size(); i++){
            
            Label naamSpeler = new Label(model.getSpelerLijst().get(i).getNaam());
            naamSpeler.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),18));
            naamSpeler.setTextFill(WHITE);
            GridPane.setConstraints(naamSpeler, 0, i+1);
            GridPane.setHalignment(naamSpeler, HPos.CENTER);
                
            Label spelerSlokken = new Label(model.getSpelerLijst().get(i).getSlokken()+"");
            spelerSlokken.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),18));
            spelerSlokken.setTextFill(WHITE);
            GridPane.setConstraints(spelerSlokken, 1, i+1);
            GridPane.setHalignment(spelerSlokken, HPos.CENTER);
            
            Label slokkenTotaal = new Label(model.getSpelerLijst().get(i).getTotaalSlokken()+"");
            slokkenTotaal.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),18));
            slokkenTotaal.setTextFill(WHITE);
            GridPane.setConstraints(slokkenTotaal, 2, i+1);
            GridPane.setHalignment(slokkenTotaal, HPos.CENTER);
            
            Label totaalFout = new Label(model.getSpelerLijst().get(i).getAantalFout()+"");
            totaalFout.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),18));
            totaalFout.setTextFill(WHITE);
            GridPane.setConstraints(totaalFout, 3, i+1);
            GridPane.setHalignment(totaalFout, HPos.CENTER);
            
            Label totaalJuist = new Label(model.getSpelerLijst().get(i).getAantalJuist()+"");
            totaalJuist.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),18));
            totaalJuist.setTextFill(WHITE);
            GridPane.setConstraints(totaalJuist, 4, i+1);
            GridPane.setHalignment(totaalJuist, HPos.CENTER);
            
            scorebord.getChildren().addAll(spelerSlokken, naamSpeler, slokkenTotaal, totaalFout, totaalJuist);
        }
        
        scorebord.setLayoutX(250);
        scorebord.setLayoutY(50);
        
        getChildren().add(scorebord);
    }   
}

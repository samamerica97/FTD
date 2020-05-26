/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FTD_Project.View;

import FTD_Project.Model.Kaartspel;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Region;
import static javafx.scene.paint.Color.RED;
import static javafx.scene.paint.Color.WHITE;
import javafx.scene.text.Font;

/**
 * het spelmenu aan het begin van het spel.
 * @author Sam America & Olivier Lenaerts
 */
public class MenuView extends Region{
    /** het model van het kaartspel */
    private Kaartspel model;
    /** de achtergrond van het menu */
    private Background achtergrond2;
    /** de tekst waarop geklikt kan worden van start spel*/
    private Label startSpel;
    /** de tekst waarop geklikt kan worden van spelregels */
    private Label spelRegels;
    /** de tekst waarop geklikt kan worden om in de spelregels terug te keren naar het menu */
    private Label gaTerug;
    /** de tekst waarop geklikt kan worden om het spel af te sluiten */
    private Label exit;
    
    public MenuView(Kaartspel model) {
        this.model = model;
        BackgroundImage achtergrond = new BackgroundImage(new Image("/images/achtergrond.jpg",1300,700,false,true),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT);
        achtergrond2 = new Background(achtergrond);
        update();        
    }
    
    /**
     * laat de 3 knoppen zien van het spelmenu
     * indien er op start geklikt wordt start het spel
     * indien er op spelregels geklikt wordt, worden de spelregels getoont
     * indien er op exit geklikt wordt sluit het spel af
     */
    public void update(){
        getChildren().clear();
        
        startSpel = new Label("start spel");
        startSpel.setLayoutX(540);
        startSpel.setLayoutY(100);
        startSpel.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),36));
        startSpel.setTextFill(WHITE);
        startSpel.setOnMouseEntered(evt -> {
            startSpel.setTextFill(RED);
            startSpel.setCursor(Cursor.HAND);
        });
        startSpel.setOnMouseExited(evt -> startSpel.setTextFill(WHITE));
        
        spelRegels = new Label("spelregels");
        spelRegels.setLayoutX(540);
        spelRegels.setLayoutY(320);
        spelRegels.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),36));
        spelRegels.setTextFill(WHITE);
        spelRegels.setOnMouseEntered(evt -> {
            spelRegels.setTextFill(RED);
            spelRegels.setCursor(Cursor.HAND);
        });
        spelRegels.setOnMouseExited(evt -> spelRegels.setTextFill(WHITE));
        
        exit = new Label("exit");
        exit.setLayoutX(600);
        exit.setLayoutY(550);
        exit.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),36));
        exit.setTextFill(WHITE);
        exit.setOnMouseEntered(evt -> {
            exit.setTextFill(RED);
            exit.setCursor(Cursor.HAND);
        });
        exit.setOnMouseExited(evt -> exit.setTextFill(WHITE));
        exit.setOnMouseClicked(evt -> model.exitSpel());
        
        getChildren().addAll(startSpel, spelRegels, exit);        
    }
    
    /**
     * toont de knop ga terug om terug te keren naar het spelmenu
     */
    public void spelregels(){
        getChildren().clear();
        
        gaTerug = new Label("ga terug");
        gaTerug.setLayoutX(100);
        gaTerug.setLayoutY(640);
        gaTerug.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),22));
        gaTerug.setTextFill(WHITE);
        gaTerug.setOnMouseEntered(evt -> {
            gaTerug.setTextFill(RED);
            gaTerug.setCursor(Cursor.HAND);
        });
        gaTerug.setOnMouseExited(evt -> gaTerug.setTextFill(WHITE));
        
        getChildren().add(gaTerug);        
    }
    
    /**
     * indien er op start spel geklikt wordt dan verdwijnt de menu view
     */
    public void startSpel(){
        getChildren().clear();
    }
    
    /**
     * @return the achtergrond2 is de achtergrond die gebruikt wordt voor het spelmenu en het speelveld.
     */
    public Background getAchtergrond2() {
        return achtergrond2;
    }

    /**
     * @return the startSpel
     */
    public Label getStartSpel() {
        return startSpel;
    }

    /**
     * @return the spelRegels
     */
    public Label getSpelRegels() {
        return spelRegels;
    }

    /**
     * @return the gaTerug
     */
    public Label getGaTerug() {
        return gaTerug;
    }
    
    /**
     * @return the exit
     */
    public Label getExit(){
        return exit;
    }        
}

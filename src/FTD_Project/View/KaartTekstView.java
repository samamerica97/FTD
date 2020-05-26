/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FTD_Project.View;

import FTD_Project.Model.Kaartspel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.MAGENTA;
import static javafx.scene.paint.Color.RED;
import javafx.scene.text.Font;

/**
 * om de huidige tekst als string weer te geven op het speelveld
 * @author Sam America & Olivier Lenaerts
 */
public class KaartTekstView extends Region{
    /** model van het kaartspel*/
    private Kaartspel model;

    public KaartTekstView(Kaartspel model) {
        this.model = model;
    }
    
    /**
     * de tekst die de dealer tonen als string.
     */
    public void update(){
        getChildren().clear();
        Label tekst = new Label("het was de");
        tekst.setLayoutX(895);
        tekst.setLayoutY(390);
        tekst.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),30));
        tekst.setTextFill(BLACK);
        tekst.setAlignment(Pos.CENTER);
        tekst.setPrefWidth(260);
        Label kaart = new Label(model.getHuidigeKaart().toString());
        kaart.setLayoutX(895);
        kaart.setLayoutY(426);
        kaart.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),30));
        if (model.getHuidigeKaart().getSoort()==0 || model.getHuidigeKaart().getSoort()==3){
            kaart.setTextFill(RED);
        }
        else{
            kaart.setTextFill(BLACK);
        }
        if (model.getHuidigeKaart().getSoort()==1 && model.getHuidigeKaart().getWaarde()==7){
            kaart.setTextFill(MAGENTA);
            Label XD = new Label("XD");
            XD.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),40));
            XD.setLayoutX(1200);
            XD.setLayoutY(470);
            XD.setRotate(-15);
            XD.setTextFill(MAGENTA);
            getChildren().add(XD);
        }

        kaart.setAlignment(Pos.CENTER);
        kaart.setPrefWidth(260);
        getChildren().addAll(tekst, kaart);
    }
}

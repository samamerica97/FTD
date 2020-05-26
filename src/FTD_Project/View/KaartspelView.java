/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FTD_Project.View;

import FTD_Project.Model.Kaartspel;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 *  Deze view bepaalt waar de views van de aangemaakte kaarten komen te liggen op het speelveld.
 *  Hier wordt ook het pak speelkaarten getoont.
 * @author Sam America & Olivier Lenaerts & Brecht Gijsens
 *  Brecht heeft geholpen met maken van de verschillende array's. Dankzij Brecht is het begin
 *  iets makkelijker verlopen. Hij heeft een veel uitgelegt in functie van ons project zodat
 *  we een start hadden hoe we konden beginnen.
 */
public class KaartspelView extends Region{
    /** Het model van het kaartspel */
    private Kaartspel model;
    /** arraylist van rectangles die ervoor zorgt dat wanneer er 4 dezelfde kaarten op het speelveld liggen de achterkant van de kaart wordt getoont */
    private ArrayList<Rectangle> kwartetVol;
    /** arraylist die bijhoudt welke kaarten er al zijn aangemaakt */
    private ArrayList<KaartView> getrokkenKaart;
    /** 2D arraylist die de positie van de kaartviews bepaald */
    private KaartView[][] kaartLijst;
    private int i;
    private int j;
    
    /**
     * constructor voor de KaartspelView
     * @param model van het kaartspel
     */
    public KaartspelView(Kaartspel model) {
        this.model = model;
        kwartetVol = new ArrayList<>();
        kaartLijst = new KaartView [13][4];
        getrokkenKaart = new ArrayList<>();
    }
    
    /**
     * voegt de getrokken kaarten toe in de arraylist getrokkenKaart.
     * @param kv is de kaartview van de getrokken kaart.
     */
    public void addKaart(KaartView kv){
        getrokkenKaart.add(kv);
        for( i = 0; i< kaartLijst[model.getHuidigeKaart().getWaarde()-1].length; i++){
            if(kaartLijst[model.getHuidigeKaart().getWaarde()-1][i] == null){
                kaartLijst[model.getHuidigeKaart().getWaarde()-1][i]= kv;          
                break;
            }  
        }
    }
    
    /**
     * Hier wordt het speelveld geupdate en worden de posities van de kaartviews op het speelveld vastgelegd.
     */
    public void update(){
        getChildren().clear();
        getChildren().addAll(kwartetVol);
        
        for( i = 0; i < kaartLijst.length; i++){
            for(j = 0; j < kaartLijst[i].length; j++){
                
                if(i == 0) {
                    if (kaartLijst[i][0] != null){    
                        
                        kaartLijst[i][j].setLayoutX(120+102*i);
                        kaartLijst[i][j].setLayoutY(350+20*j); 
                        getChildren().addAll(kaartLijst[i][j]);

                        if( j == 3 || kaartLijst[i][j+1] == null){
                            break;
                        }
                    }
                }
                else if(i <= 6){               
                    if (kaartLijst[i][0] != null){
                                          
                        kaartLijst[i][j].setLayoutX(120+102*i);
                        kaartLijst[i][j].setLayoutY(250+20*j); 
                        getChildren().addAll(kaartLijst[i][j]);

                        if( j == 3 || kaartLijst[i][j+1] == null){
                            break;
                        }
                    }
                }
                else {
                    if (kaartLijst[i][0] != null){
                        
                        kaartLijst[i][j].setLayoutX(120+(102*(i-6)));
                        kaartLijst[i][j].setLayoutY(450+20*j); 
                        getChildren().addAll(kaartLijst[i][j]);

                        if( j == 3 || kaartLijst[i][j+1] == null){
                            break;
                        }
                    }
                } 
            }
        }        
        zichtbaarDeck();
    }
    
    /**
     * Als de 4de kaart van hetzelfde nummer op het speelveld gelegd wordt, draaien alle kaarten van dit nummer om
     * en wordt de achterkant van de kaart weergegeven.
     */    
    public void kaartenDraaien(){
        i = model.getHuidigeKaart().getWaarde()-1;
        if(kaartLijst[i][3] != null){
            for(j = 0; j <= kaartLijst[i].length-1; j++){
                if(i == 0){
                    kaartLijst[i][j].setVisible(false);
                    Rectangle fill = new Rectangle(120+102*i,350,100,140);
                    Image img = new Image("/images/achterkant.png", 0, 0, true, true);
                    fill.setFill(new ImagePattern(img));
                    kwartetVol.add(fill);
                    getChildren().add(fill);
                }
                else if(i <=6){
                    kaartLijst[i][j].setVisible(false);
                    Rectangle fill = new Rectangle(120+102*i,250,100,140);
                    Image img = new Image("/images/achterkant.png", 0, 0, true, true);
                    fill.setFill(new ImagePattern(img));
                    kwartetVol.add(fill);
                    getChildren().add(fill);                    
                }
                else{
                    kaartLijst[i][j].setVisible(false);
                    Rectangle fill = new Rectangle(120+(102*(i-6)),450,100,140);
                    Image img = new Image("/images/achterkant.png", 0, 0, true, true);
                    fill.setFill(new ImagePattern(img));
                    kwartetVol.add(fill);
                    getChildren().add(fill);                   
                }
            }
        }
    }

    /**
     * Zorgt ervoor dat het deck met de overige kaarten getoont wordt op het speelveld.
     * bij de laatste 6 kaarten gaat dit pak kleiner worden.
     */
    public void zichtbaarDeck(){
        if(model.getKaartenOver() <=6){
            for (int k = 0; k < model.getKaartenOver(); k++){
                Rectangle deck = new Rectangle(400-2*k,50,100,140);
                Image stapel = new Image("/images/achterkant.png", 0, 0, true, false);
                deck.setFill(new ImagePattern(stapel));
                getChildren().add(deck);
            }
        }
        else{
            for (int k = 0; k < 6; k++){
                Rectangle deck = new Rectangle(400-2*k,50,100,140);
                Image stapel = new Image("/images/achterkant.png", 0, 0, true, false);
                deck.setFill(new ImagePattern(stapel));
                getChildren().add(deck);
            }
        }
    }    
}

package FTD_Project.Controller;

import FTD_Project.Model.Kaartspel;
import FTD_Project.Model.Spelers;
import FTD_Project.View.FoutenView;
import FTD_Project.View.KaartTekstView;
import FTD_Project.View.KaartView;
import FTD_Project.View.KaartspelView;
import FTD_Project.View.MenuView;
import FTD_Project.View.ScorebordView;
import FTD_Project.View.SlokkenDrinkenView;
import FTD_Project.View.SlokkenView;
import FTD_Project.View.SpelerNaamView;
import java.util.ArrayList;
import java.util.Timer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.RED;
import static javafx.scene.paint.Color.WHITE;
import javafx.scene.text.Font;

public class KaartspelController {

    @FXML
    private AnchorPane ankerPaneel;

    @FXML
    private AnchorPane menuPaneel;

    @FXML
    private ImageView menuVogel;

    @FXML
    private ImageView menuTekstballon;

    @FXML
    private Label auteurs;

    @FXML
    private Label welkom;

    @FXML
    private Label menuVraag;

    @FXML
    private Label spelregelVeld;

    @FXML
    private Pane spelerPaneel;

    @FXML
    private Label labelAantalSpelers;

    @FXML
    private Label wieSpeelt;

    @FXML
    private Pane slokkenBijhoudenPaneel;

    @FXML
    private Label spelers;

    @FXML
    private Label aantalSlokken;

    @FXML
    private AnchorPane spelPaneel;

    @FXML
    private ImageView spelVogel;

    @FXML
    private ImageView spelTekstballon;

    @FXML
    private Label hoger;

    @FXML
    private Label lager;

    @FXML
    private Label eersteKeerJuist;

    @FXML
    private Label tweedeKeerJuist;

    @FXML
    private Label tweedeFout;

    @FXML
    private Label drieSlokken;

    @FXML
    private Label eenSlok;

    @FXML
    private Label uitdelen;

    @FXML
    private Label gokje;

    @FXML
    private Label aantalFouten;

    @FXML
    private Label drieKeerFout;

    @FXML
    private ImageView kaartVogel;

    @FXML
    private AnchorPane eindPaneel;

    @FXML
    private ImageView eindVogel;

    @FXML
    private Label opnieuwSpelen;

    @FXML
    private Label spelGedaan;

    @FXML
    private ImageView eindTekstVogel;

    @FXML
    private Label zatteTekst;

    @FXML
    private Label ja;

    @FXML
    private Label nee;

    @FXML
    private ImageView zatteVogel2;

    @FXML
    private ImageView eindTekstVogelSlokken;

    @FXML
    private Label drinkSlokkenLeeg;

    @FXML
    private Pane slokkenUitdelenPaneel;

    @FXML
    private Pane jaNeePaneel;

    @FXML
    private Label slokkenDrinken;

    @FXML
    private Label jaDrink;

    @FXML
    private Label neeDrink;

    @FXML
    private ImageView caraVogel;

    @FXML
    private ImageView drinkVogel;

    @FXML
    private Button drink;

    @FXML
    private Label hoeveel;   
    
    //de views oproepen in de controller
    private Kaartspel k;
    private KaartView kv;
    private KaartspelView ksv;
    private SlokkenView sv;
    private SlokkenDrinkenView sdv;
    private ScorebordView sbv;
    private SpelerNaamView snv;
    private FoutenView fv;
    private KaartTekstView ktv;
    private MenuView mv;
    
    private ArrayList<TextField> lijstNamen;
    private Button trek;
    private Button raadKnop;
    private Spinner raad;

    @FXML
    void initialize(){
        k = new Kaartspel();
        ksv = new KaartspelView(k);
        sv = new SlokkenView(k);
        sdv = new SlokkenDrinkenView(k);
        sbv = new ScorebordView(k);
        snv = new SpelerNaamView(k);
        fv = new FoutenView(k);
        ktv = new KaartTekstView(k);
        mv = new MenuView(k);
                
        
        ankerPaneel.getChildren().addAll(ksv, sv, fv, snv, ktv);
        jaNeePaneel.getChildren().add(sdv);
        menuPaneel.getChildren().add(mv);
        eindPaneel.getChildren().add(sbv);
        
        ankerPaneel.setBackground(mv.getAchtergrond2());
        menuPaneel.setBackground(mv.getAchtergrond2());
        eindPaneel.setBackground(mv.getAchtergrond2());
        
        menu();
    }
    
    /**
     * het spelmenu zichtbaar maken
     */
    public void menu(){        
        menuPaneel.setVisible(true);        
        mv.update();
        mv.getSpelRegels().setOnMouseClicked(evt -> {
            spelregelVeld.setVisible(true);
            menuVogel.setVisible(false);
            menuTekstballon.setVisible(false);
            menuVraag.setVisible(false);
            welkom.setVisible(false);
            mv.spelregels();
            mv.getGaTerug().setOnMouseClicked(e -> {
                mv.update();
                menuVogel.setVisible(true);
                menuTekstballon.setVisible(true);
                menuVraag.setVisible(true);
                welkom.setVisible(true);
                spelregelVeld.setVisible(false);
                menu();
            });            
        });
        mv.getStartSpel().setOnMouseClicked(evt-> {
            mv.startSpel();
            menuPaneel.setVisible(false);
            aantalSpelers();
            spelerPaneel.setVisible(true);
        });
        mv.getExit().setOnMouseClicked(evt -> k.exitSpel());
    }
    
    /**
     * spinner aantal spelers weergeven
     */
    public void aantalSpelers(){
        Spinner aantalSpelers = new Spinner(1, 10, 1, 1);
        aantalSpelers.setLayoutX(267);
        aantalSpelers.setLayoutY(80);
        
        Label addSpelers = new Label("Ok");
        addSpelers.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),24));
        addSpelers.setTextFill(WHITE);
        addSpelers.setLayoutX(320);
        addSpelers.setLayoutY(120);
        
        Label max10 = new Label("maximum 10 spelers");
        max10.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),15));
        max10.setTextFill(WHITE);
        max10.setLayoutX(260);
        max10.setLayoutY(50);
        
        spelerPaneel.getChildren().addAll(aantalSpelers, addSpelers, max10);
        
        addSpelers.setOnMouseEntered(evt -> {
            addSpelers.setTextFill(RED);
            addSpelers.setCursor(Cursor.HAND);
        });        
        addSpelers.setOnMouseExited(evt -> addSpelers.setTextFill(WHITE));
        addSpelers.setOnMouseClicked(evt -> {
            spelersLijstAanmaken((int) aantalSpelers.getValue());
            addSpelers.setVisible(false);
            aantalSpelers.setVisible(false);
            max10.setVisible(false);
            labelAantalSpelers.setVisible(false);
        });
    }
    
    //https://stackoverflow.com/questions/15159988/javafx-2-2-textfield-maxlength
    /**
     * het limiteren van het aantal characters wat ingegeven kan worden als naam van de speler
     * @param tf textfield waar de naam in getypt wordt
     * @param maxLength de maximum lengte van de naam
     */
    public void addTextLimiter(final TextField tf, final int maxLength) {
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (tf.getText().length() > maxLength) {
                    String s = tf.getText().substring(0, maxLength);
                    tf.setText(s);
                }
            }
        });
    }
    
    /**
     * het aanmaken van de spelerslijst en de ingevulde TextFields invullen in de array lijstNamen.
     * Wanneer er op start spel geklikt wordt, gaat het spel van start.
     * @param aantalSpelers het aantal spelers dat mee speelt (maximum 10 spelers)
     */
    public void spelersLijstAanmaken(int aantalSpelers){
        wieSpeelt.setVisible(true);
        lijstNamen = new ArrayList<>();
        for (int i = 0; i<aantalSpelers; i++){
            TextField spelerNaam = new TextField();
            spelerNaam.setPromptText("Naam speler");
            spelerNaam.setLayoutX(267);
            spelerNaam.setLayoutY(50+i*30);            
            addTextLimiter(spelerNaam, 10); //het instellen van de textlimiter
            spelerPaneel.getChildren().add(spelerNaam);
            lijstNamen.add(spelerNaam);
        }
        
        Label start = new Label("Start spel");
        start.setLayoutX(276);
        start.setLayoutY(50+aantalSpelers*30);
        start.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),24));
        start.setTextFill(WHITE);        
        spelerPaneel.getChildren().add(start);
        
        start.setOnMouseEntered(evt -> {
            start.setTextFill(RED);
            start.setCursor(Cursor.HAND);
        });
        start.setOnMouseExited(evt -> start.setTextFill(WHITE));
        start.setOnMouseClicked(evt -> {
            spelerPaneel.setVisible(false);
            startSpel();
            start.setVisible(false);                       
        });        
    }
    
    /**
     * het spelPaneel starten en de nodige elementen zichtbaar maken op het speelveld.
     */
    public void startSpel(){   
        spelPaneel.setVisible(true);
        lijstNamen.forEach(action-> action.setFocusTraversable(false));
        slokkenBijhoudenPaneel.setVisible(true);
        slokkenBijhoudenPaneel.getChildren().addAll(lijstNamen);
        for (TextField tf: lijstNamen){
            k.vulSpelersLijst(tf.getText());
            tf.setEditable(false);
            tf.setLayoutX(0);
            tf.setStyle("-fx-text-fill: white");
            tf.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),14));
            tf.setBackground(Background.EMPTY);
        }
        
        k.startSpel();
        ksv.update();//om het deck te laten zien
        sv.update();
        snv.isAanDeBeurt();
        lijstNamen.get(k.getIndexSpeler()).setStyle("-fx-text-fill: red");

        //knop voor kaarten te trekken toevoegen aan het ankerpaneel
        trek = new Button("Trek kaart!");
        trek.setLayoutX(410);
        trek.setLayoutY(20);        
        ankerPaneel.getChildren().add(trek);
        trek.toFront();        
        
        trek.setOnAction(evt -> {
            snv.update();
            k.raapKaart();           
            trek.setDisable(true);
            gokje.setVisible(true);
            kaartVogel.setVisible(true);
            kaartTrekken();             
        });
        
        //spinner en knop toevoegen voor te gokken
        raad = new Spinner(1,13,1,1); //spinner die van waarden aas tot koning kan gokken
        raad.setLayoutX(600);
        raad.setLayoutY(20);
        raad.setVisible(false);
        raadKnop = new Button("Raad");
        raadKnop.setLayoutX(650);
        raadKnop.setLayoutY(45);
        raadKnop.setVisible(false);
        ankerPaneel.getChildren().addAll(raad, raadKnop);           
        raad.toFront();
        raadKnop.toFront();
        
        //spelregels opvragen
        Label spelRegels = new Label("spelregels");
        spelRegels.setLayoutX(1200);
        spelRegels.setLayoutY(10);
        spelRegels.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bubblegum.ttf"),16));
        spelRegels.setTextFill(WHITE);
        spelRegels.setOnMouseEntered(evt -> {
            spelRegels.setTextFill(RED);
            spelRegels.setCursor(Cursor.HAND);
        });
        spelRegels.setOnMouseExited(evt -> spelRegels.setTextFill(WHITE));
        spelRegels.setOnMouseClicked(evt -> {
            spelregelVeld.setVisible(true);
            menuPaneel.setVisible(true);
            menuVogel.setVisible(false);
            menuTekstballon.setVisible(false);
            menuVraag.setVisible(false);
            welkom.setVisible(false);
            menuPaneel.toFront();
            mv.spelregels();
            mv.getGaTerug().setOnMouseClicked(e -> {
                menuPaneel.setVisible(false);
                spelregelVeld.setVisible(false);
                mv.getGaTerug().setVisible(false);
                menuVogel.setVisible(true);
                menuTekstballon.setVisible(true);
                menuVraag.setVisible(true);
                welkom.setVisible(true);                
                });
        });
        ankerPaneel.getChildren().add(spelRegels);
        
        //ChoiceBox genereren om slokken uit te delen aan een bepaalde speler   
        ChoiceBox<String> keuzeSpeler = new ChoiceBox<>();
        keuzeSpeler.setLayoutX(918);
        keuzeSpeler.setLayoutY(440);
        keuzeSpeler.setPrefWidth(150);
        for (int i = 0; i<lijstNamen.size(); i++){
            keuzeSpeler.getItems().add(lijstNamen.get(i).getText());
        }
        keuzeSpeler.setValue(lijstNamen.get(0).getText());
        Button keuzeUitdelen = new Button("Oké");
        keuzeUitdelen.setLayoutX(1075);
        keuzeUitdelen.setLayoutY(440);
        slokkenUitdelenPaneel.getChildren().addAll(keuzeSpeler,keuzeUitdelen);
        slokkenUitdelenPaneel.toFront();
        
        keuzeUitdelen.setOnAction(evt -> {
            slokkenGeven(keuzeSpeler.getValue());
            slokkenUitdelenPaneel.setVisible(false);
            uitdelen.setVisible(false);
            sv.update();
            drinkSlokken();
        });         
    }
    
    /**
     * Een kaartview laten aanmaken en de view van het kaartspel updaten.
     */
    public void kaartTrekken(){
        kv = new KaartView(k);
        ksv.addKaart(kv);
        ksv.update();
        raad.setVisible(true);
        raadKnop.setVisible(true);
        raadKnop.setDisable(false);
        gok();  
    }
    
    /**
     * de gebruiker laten gokken en de nodige elementen zichtbaar maken
     */
    public void gok(){   
        raadKnop.setOnAction(evt -> {
            k.setGok((int)raad.getValue());
            k.gok();
            raadKnop.setDisable(true);
            gok();
        });
        
        if (k.getAantalGokken()==1){
            gokje.setVisible(false);
            if (k.getGok()!= k.getHuidigeKaart().getWaarde()){
                if (k.getHuidigeKaart().getWaarde()> k.getGok()){
                    hoger.setVisible(true);
                }
                else{
                    lager.setVisible(true);
                }
                raadKnop.setDisable(false);
            }
            else{
                eersteKeerJuist.setVisible(true);
                KaartTonenTask kaartTonen = new KaartTonenTask(k, this);
                Timer kaart = new Timer(true);
                kaart.schedule(kaartTonen, 3000);          
                k.juistGeraden();               
            }
        }
        
        if (k.getAantalGokken()==2){
            hoger.setVisible(false);
            lager.setVisible(false);            
            if (k.getGok()!= k.getHuidigeKaart().getWaarde()){
                tweedeFout.setVisible(true);
                KaartTonenTask kaartTonen = new KaartTonenTask(k, this);
                Timer kaart = new Timer(true);
                kaart.schedule(kaartTonen, 3000);
                k.foutGeraden();                
            }
            else{               
                tweedeKeerJuist.setVisible(true);
                KaartTonenTask kaartTonen = new KaartTonenTask(k, this);
                Timer kaart = new Timer(true);
                kaart.schedule(kaartTonen, 3000);
                k.juistGeraden();
            }
        }
    }
    
    /**
     * de getrokken kaart tonen als tekst
     */
    public void toonKaart(){
        eersteKeerJuist.setVisible(false);
        tweedeKeerJuist.setVisible(false);
        tweedeFout.setVisible(false);
        ktv.setVisible(true);
        ktv.update();
        kv.update();
        ksv.kaartenDraaien();
        kaartVogel.setVisible(false);
        
        if (k.getAantalGokken()==2){
             if (k.getGok()== k.getHuidigeKaart().getWaarde()){
                TweedeJuistTask tweedeJuist = new TweedeJuistTask(k, this);
                Timer juist2 = new Timer(true);
                juist2.schedule(tweedeJuist, 3500);
             }
             else{
                TweedeFoutTask tweedeFout = new TweedeFoutTask(k, this);
                Timer fout = new Timer(true);
                fout.schedule(tweedeFout, 3500);
             }
        }
        else{
            EersteJuistTask eersteJuist = new EersteJuistTask(k, this);
            Timer juist1 = new Timer(true);
            juist1.schedule(eersteJuist, 3500);
        }
        
    }
    
    /**
     * Als de eerste keer juist is geraden, de juiste tekst displayen na een bepaald aantal seconden
     */
    public void eersteJuist(){
        ktv.setVisible(false);
        eersteKeerJuist.setVisible(false);
        drieSlokken.setVisible(true);
        UitdelenTask drieUitdelen = new UitdelenTask(k, this);
        Timer uitdelen3 = new Timer(true);
        uitdelen3.schedule(drieUitdelen, 2000);
    }
    /**
     * Als de tweede keer juist is geraden, de juiste tekst displayen na een bepaald aantal seconden
     */
    public void tweedeJuist(){
        ktv.setVisible(false);
        tweedeKeerJuist.setVisible(false);
        eenSlok.setVisible(true);
        UitdelenTask eenUitdelen = new UitdelenTask(k, this);
        Timer uitdelen1 = new Timer(true);
        uitdelen1.schedule(eenUitdelen, 2000);
    }
    
    /**
     * als het juist is geraden, het uitdeelpaneel zichtbaar maken voor de gebruiker
     */
    public void uitdelen(){
        drieSlokken.setVisible(false);
        eenSlok.setVisible(false);
        uitdelen.setVisible(true);
        slokkenUitdelenPaneel.setVisible(true);
    }
    
    /**
     * als het fout is geraden, de juiste tekst displayen na een bepaald aantal seconden
     */
    public void tweedeFout(){
        sv.update();
        ktv.setVisible(false);
        tweedeFout.setVisible(false);
        if (k.getAantalFouten() == 0){
            drieKeerFout.setVisible(true);
        }
        else {
            aantalFouten.setVisible(true);
            fv.setVisible(true);
            fv.update();
        }
        SlokkenDrinkenTask slokkenDrinken = new SlokkenDrinkenTask(k, this);
        Timer t6 = new Timer(true);
        t6.schedule(slokkenDrinken, 2500);
    }
    /**
     * de speler die aangeduid is door de gebruiker zijn slokken verhogen
     * @param st een string met de naam van de aangeduide speler
     */
    public void slokkenGeven(String st){
        for(Spelers s: k.getSpelerLijst()){
            if (s.getNaam().equals(st)){
                s.setSlokken(s.getSlokken()+k.getAantalSlokken());
                s.setTotaalSlokken(s.getTotaalSlokken()+k.getAantalSlokken());
            }            
        }
    }
    
    /**
     * de views updaten zodat op het einde van de beurt een bepaald aantal slokken mag gedronken worden.
     */
    public void drinkSlokken(){
        fv.setVisible(false);
        drieKeerFout.setVisible(false);
        aantalFouten.setVisible(false);
        if (k.getSpelerLijst().get(k.getIndexSpeler()).getSlokken() != 0){
            jaNeePaneel.setVisible(true);
            jaDrink.setOnMouseEntered(evt -> {
                jaDrink.setTextFill(RED);
                jaDrink.setCursor(Cursor.HAND);
            });
            jaDrink.setOnMouseExited(evt -> jaDrink.setTextFill(BLACK));
            jaDrink.setOnMouseClicked(evt -> {
                sdv.update();
                sdv.setVisible(true);
                slokkenDrinken.setVisible(false);
                jaDrink.setVisible(false);
                neeDrink.setVisible(false);
                hoeveel.setVisible(true);
                drink.setVisible(true);
                drinkVogel.setVisible(true);
            });
            
            neeDrink.setOnMouseEntered(evt -> {
                neeDrink.setTextFill(RED);
                neeDrink.setCursor(Cursor.HAND);
            });            
            neeDrink.setOnMouseExited(evt -> neeDrink.setTextFill(BLACK));
            neeDrink.setOnMouseClicked(evt -> {
                jaNeePaneel.setVisible(false);
                highlightSpeler();
                trek.setDisable(false);
                snv.isAanDeBeurt();
                if (k.getKaartenOver() == 0){
                    opnieuwSpelen();
                }                
            });                    
        }
        else{
            highlightSpeler();
            snv.isAanDeBeurt();
            trek.setDisable(false);
            if (k.getKaartenOver() == 0){
                opnieuwSpelen();
            }   
        }
        
        drink.setOnAction(evt -> {
            k.getSpelerLijst().get(k.getIndexSpeler()).setSlokken(k.getSpelerLijst().get(k.getIndexSpeler()).getSlokken()-sdv.getWaardeSpinner());
            sv.update();
            //JaNee paneel terug resetten, juiste elementen zichtbaar maken
            slokkenDrinken.setVisible(true);
            jaDrink.setVisible(true);
            neeDrink.setVisible(true);
            hoeveel.setVisible(false);
            drink.setVisible(false);
            drinkVogel.setVisible(false);
            sdv.setVisible(false);
            jaNeePaneel.setVisible(false);
            highlightSpeler();
            snv.isAanDeBeurt();
            trek.setDisable(false);
            if (k.getKaartenOver() == 0){
                opnieuwSpelen();
            }
        });
    }
    
    /**
     * de huidige speler highlighten in het rood
     */
    public void highlightSpeler(){
        lijstNamen.get(k.getIndexSpeler()).setStyle("-fx-text-fill: white");
        k.volgendeSpeler();
        lijstNamen.get(k.getIndexSpeler()).setStyle("-fx-text-fill: red");
    }
    /**
     * op het einde van het spelPaneel de nodige views updaten, zodat het scorebord en andere elementen worden getoont.
     */
    public void opnieuwSpelen(){
        eindPaneel.setVisible(true);
        eindPaneel.toFront();               
        sbv.update();
        
        ja.setOnMouseEntered(evt -> {
            ja.setTextFill(RED);
            ja.setCursor(Cursor.HAND);
        });
        ja.setOnMouseExited(evt -> ja.setTextFill(WHITE));
        ja.setOnMouseClicked(evt -> {
            k.speelOpnieuw();
            herstart();
        });
        nee.setOnMouseEntered(evt -> {
            nee.setTextFill(RED);
            nee.setCursor(Cursor.HAND);
        });
        nee.setOnMouseExited(evt -> nee.setTextFill(WHITE));
        nee.setOnMouseClicked(evt -> k.exitSpel());        
    }
    
    /**
     * de views resetten zodat er opnieuw gespeeld kan worden.
     */
    public void herstart(){              
        ankerPaneel.getChildren().clear();
        slokkenUitdelenPaneel.getChildren().clear();
        spelPaneel.setVisible(false);
        slokkenBijhoudenPaneel.setVisible(false);
        slokkenBijhoudenPaneel.getChildren().removeAll(lijstNamen);
        eindPaneel.setVisible(false);
        ankerPaneel.getChildren().addAll(eindPaneel,menuPaneel, slokkenUitdelenPaneel, spelPaneel, spelerPaneel, slokkenBijhoudenPaneel, jaNeePaneel);
        initialize();
    }
}

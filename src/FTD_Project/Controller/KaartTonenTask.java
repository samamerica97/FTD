/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FTD_Project.Controller;

import FTD_Project.Model.Kaartspel;
import java.util.TimerTask;
import javafx.application.Platform;

/**
 *
 * @author Sam America & Olivier Lenaerts
 */
public class KaartTonenTask extends TimerTask {
    private Kaartspel model;
    private KaartspelController controller;

    public KaartTonenTask(Kaartspel model, KaartspelController controller) {
        this.model = model;
        this.controller = controller;
    }

    @Override
    public void run() {       
        Platform.runLater(controller::toonKaart);        
    }   
}

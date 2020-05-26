/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FTD_Project.Controller;

import FTD_Project.Model.Kaartspel;
import java.util.TimerTask;

/**
 *
 * @author Sam America
 */
public class TweedeJuistTask extends TimerTask {
    private Kaartspel model;
    private KaartspelController controller;

    public TweedeJuistTask(Kaartspel model, KaartspelController controller) {
        this.model = model;
        this.controller = controller;
    }

    @Override
    public void run() {
        controller.tweedeJuist();
    }
}

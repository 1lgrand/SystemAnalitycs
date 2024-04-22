package org.demarzo.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import org.demarzo.Threads.*;
import org.demarzo.Threads.t_updateRam;


public class hpController implements Initializable{

    //Labels
    @FXML
    private Label perc_ram_label;
    @FXML
    private Label perc_cpu_label;
    @FXML
    private Label perc_gpu_label;

    @FXML
    private Label fractionRAM;

    private t_updateRam t_updateRam; //Aggiorna la label della RAM
    private t_updateCpu t_updateCpu; //Aggiorna la label della CPU
    private t_updateGpu t_updateGpu; //Aggiorna la label della GPU

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        t_updateRam = new t_updateRam(perc_ram_label,fractionRAM);
        t_updateRam.start();
    }

}

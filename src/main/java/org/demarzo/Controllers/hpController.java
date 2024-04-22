package org.demarzo.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javafx.scene.control.ProgressBar;
import org.demarzo.Threads.*;
import org.demarzo.Threads.t_updateRam;


public class hpController implements Initializable{

    //Labels
    @FXML
    private Label perc_ram_label;
    @FXML
    private Label perc_cpu_label;
    @FXML
    private Label freeSpaceLabel;

    @FXML
    private ProgressBar freeSpaceProgressBar;


    @FXML
    private Label fractionRAM;

    private t_updateRam t_updateRam; //Aggiorna la label della RAM
    private t_updateCpu t_updateCpu; //Aggiorna la label della CPU
    private t_updateMemory t_updateMemory; //Aggiorna la label della Memoria

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        t_updateRam = new t_updateRam(perc_ram_label,fractionRAM);
        t_updateCpu = new t_updateCpu(perc_cpu_label);
        t_updateMemory = new t_updateMemory(freeSpaceLabel,freeSpaceProgressBar);

        
        t_updateMemory.start();
        t_updateCpu.start();
        t_updateRam.start();

    }

}

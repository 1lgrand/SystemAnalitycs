package org.demarzo.Threads;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.GraphicsCard;
import oshi.hardware.HardwareAbstractionLayer;

import java.text.DecimalFormat;

public class t_updateCpu extends Thread{

    @FXML
    Label cpu_label;

    SystemInfo si = new SystemInfo();
    HardwareAbstractionLayer hardware = si.getHardware();
    CentralProcessor cpu = hardware.getProcessor();


    public t_updateCpu(Label cpu_label){
        this.cpu_label = cpu_label;
    }

    @Override
    public void run(){
        while (true){

            Platform.runLater(()->{

                cpu_label.setText(new DecimalFormat("##").format(cpu.getSystemCpuLoad(1000) * 100) + "%");
            });

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }



}

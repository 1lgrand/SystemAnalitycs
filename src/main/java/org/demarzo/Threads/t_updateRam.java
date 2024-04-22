package org.demarzo.Threads;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.text.DecimalFormat;

import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;

public class t_updateRam extends Thread{

    @FXML
    Label ram;

    @FXML
    Label fractionRAM;

    SystemInfo si = new SystemInfo();
    HardwareAbstractionLayer hardware = si.getHardware();
    GlobalMemory globalMemory = hardware.getMemory();
    Long totalMemory = globalMemory.getTotal();

    public t_updateRam(Label ramLabel,Label fractionRAM){
        this.ram = ramLabel;
        this.fractionRAM = fractionRAM;
    }



    private String calculatePercOfRAM(){


        Double availableRAM = globalMemory.getAvailable() / Math.pow(1024,3); //In GB
        Double totalRAM = totalMemory / Math.pow(1024,3); //in GB
        Double inUseRAM = totalRAM-availableRAM; //in GB

        String perc = new DecimalFormat("##").format((100*inUseRAM)/totalRAM);

        return perc + "%";
    }

    private String setFractionRam(){
        Double availableRAM = globalMemory.getAvailable() / Math.pow(1024,3); //In GB
        Double totalRAM = totalMemory / Math.pow(1024,3); //in GB
        Double inUseRAM = totalRAM-availableRAM; //in GB

        String df_totalRam = new DecimalFormat("##.#").format(totalRAM);
        String df_inUseRAM = new DecimalFormat("##.#").format(inUseRAM);

        return df_inUseRAM + " GB / " + df_totalRam + " GB";

    }

    @Override
    public void run() {

        while (true){

            try {

                Platform.runLater(()->{
                    ram.setText(calculatePercOfRAM());
                    fractionRAM.setText(setFractionRam());
                });
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

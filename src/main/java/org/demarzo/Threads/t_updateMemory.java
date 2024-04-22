package org.demarzo.Threads;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import oshi.SystemInfo;
import oshi.hardware.*;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;

import java.text.DecimalFormat;

public class t_updateMemory extends Thread{

    SystemInfo si = new SystemInfo();
    OperatingSystem os = si.getOperatingSystem();
    OSFileStore disk = os.getFileSystem().getFileStores().get(0);

    @FXML
    private Label freeSpaceLabel;
    @FXML
    private ProgressBar freeSpaceProgressBar;


    public t_updateMemory(Label freeSpaceLabel, ProgressBar freeSpaceProgressBar){
        this.freeSpaceLabel = freeSpaceLabel;
        this.freeSpaceProgressBar = freeSpaceProgressBar;
    }

    @Override
    public void run() {

        while (true){

            Platform.runLater(()->{

                double usedSpace = disk.getTotalSpace() - disk.getFreeSpace();
                double progress = 1*usedSpace/disk.getTotalSpace();

                freeSpaceLabel.setText(new DecimalFormat("###.#").format(toGigaByte(disk.getUsableSpace())) + " GB liberi di " + new DecimalFormat("###.#").format(toGigaByte(disk.getTotalSpace()))+" GB");

                freeSpaceProgressBar.setProgress(progress);


            });

            try {
                sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private double toGigaByte(long number){
        return number / Math.pow(1024,3);
    }

}

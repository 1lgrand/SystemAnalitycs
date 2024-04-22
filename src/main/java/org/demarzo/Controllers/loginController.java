package org.demarzo.Controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.demarzo.Main;
import org.demarzo.MainApp;

public class loginController{
    
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label errorLabel;

    @FXML
    private Button submit;

    @FXML
    private void accediOspite() throws IOException {
        MainApp.setRoot("homepage","Homepage");
    }

}

package org.demarzo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class MainApp extends Application {
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        setRoot("login", "Login");
    }

    public static void setRoot(String fxml) throws IOException {
        setRoot(fxml, "Login");
    }

    public static void setRoot(String fxml, String title) throws IOException {
        Scene scene = new Scene(loadFXML(fxml));
        stage.setResizable(false);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

module org.demarzo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.management;
    requires jdk.management;
    requires com.github.oshi;
    opens org.demarzo to javafx.fxml;
    exports org.demarzo;
    exports org.demarzo.Controllers;
    opens org.demarzo.Controllers to javafx.fxml;
    exports org.demarzo.Threads;
    opens org.demarzo.Threads to javafx.fxml;
}
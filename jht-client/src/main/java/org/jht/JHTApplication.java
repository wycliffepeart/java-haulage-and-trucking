package org.jht;

import javafx.application.Application;
import javafx.stage.Stage;
import org.jht.support.Navigate;

public class JHTApplication extends Application {
    @Override
    public void start(Stage stage) {
        Navigate.root(stage, "auth_signin_layout.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}
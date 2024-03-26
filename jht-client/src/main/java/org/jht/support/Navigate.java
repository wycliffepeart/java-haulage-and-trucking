package org.jht.support;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.jht.JHTApplication;

import java.io.IOException;

public class Navigate {

    private static Parent masterLayout;

    /**
     * Retrieve the application primary stage
     *
     * @return {@link Stage}
     */
    public static Stage getPrimaryStage() {

        return (Stage) Stage.getWindows();
    }

    public static Stage getParentStage() {

        return (Stage) Stage.getWindows().getFirst();
    }

    /**
     * Route the application to a scene
     *
     * @param layout The name of the layout
     */
    public static void root(Stage stage, String layout) {

        try {

            // Inflate the toDashboard layout
            Scene scene = FXMLInflater.inflate(JHTApplication.class.getResource(layout));

            //
            stage.setTitle("JAVA Haulage and Trucking");

            // Assign a new scene on the primary stage
            stage.setScene(scene);

            // Display the newly assigned scene
            stage.show();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    public static void to(String layout){
        Stage stage = getParentStage();

        if (masterLayout == null){
            masterLayout = FXMLInflater.inflateParent("master_layout.fxml");

            Scene scene = new Scene(masterLayout);

            stage.setScene(scene);
        }

        Parent childLayout = FXMLInflater.inflateParent(layout);

        HBox fxLayoutContent = (HBox) stage.getScene().lookup("#fxLayoutContent");

        fxLayoutContent.getChildren().removeAll(fxLayoutContent.getChildren());
        fxLayoutContent.getChildren().add(childLayout);

        stage.show();
    }

    /**
     * Route the application to a scene
     *
     * @param name   The name of the scene
     * @param layout The name of the layout
     */
    public static void root(String name, String layout) {

        try {

            // Retrieve the primary stage
            Stage primaryStage = getPrimaryStage();

            // Inflate the toDashboard layout
            Scene scene = FXMLInflater.inflate(JHTApplication.class.getResource(layout));

            //
            primaryStage.setTitle(name);

            // Assign a new scene on the primary stage
            primaryStage.setScene(scene);

            // Display the newly assigned scene
//            primaryStage.show();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

}

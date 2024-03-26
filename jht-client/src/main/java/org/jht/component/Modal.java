package org.jht.component;

import javafx.stage.Modality;
import javafx.stage.Stage;
import org.jht.support.R;

import java.io.IOException;

public class Modal {


    /**
     * Route the application to a modal
     *
     * @param name       The name of the modal
     * @param layoutName The name off the layout
     * @param controller The name of the controller
     */
    public static void open(String name, String layoutName, Object controller) {

        try {

            Stage window = new Stage();
            window.setResizable(false);
            window.initModality(Modality.APPLICATION_MODAL);
//        window.getIcons().add(ROld.image("identicon.png"));

            window.setScene(R.inflate(layoutName, controller));

            window.setTitle(name);
            window.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

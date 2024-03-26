package org.jht.component;

import javafx.scene.control.Alert;

public class Dialog {


    /**
     * Show dialog
     *
     * @param alertType   The alert type
     * @param title       The alert  title
     * @param headerText  The alert header message
     * @param contentText The alert content
     */
    public static void show(Alert.AlertType alertType, String title, String headerText, String contentText) {

        Alert alert = new Alert(alertType);

        alert.setTitle(title);

        alert.setHeaderText(headerText);

        alert.setContentText(contentText);

        alert.showAndWait();
    }
}

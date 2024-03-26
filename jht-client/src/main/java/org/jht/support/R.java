package org.jht.support;

import javafx.scene.Scene;

import java.io.IOException;

public class R {

    /**
     * Bind the layout to a controller
     *
     * @param layoutName   The file to load
     * @param controller The controller to bindFxml
     * @return {@link Scene}
     * @throws IOException IOException
     */
    public static Scene inflate(final String layoutName, final Object controller) throws IOException {

        return FXMLInflater.inflate(layoutName, controller);
    }
}

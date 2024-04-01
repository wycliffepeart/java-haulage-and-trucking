package org.jht.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jht.support.Data;
import org.jht.support.Navigate;
import org.jht.websocket.Message;
import org.jht.websocket.MyStompSessionHandler;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * The MasterLayoutController class is responsible for managing the layout of the master view.
 * It handles user interactions and updates the UI accordingly.
 */
public class MasterLayoutController implements Initializable {

    @FXML
    TextField fxChatTextField;

    @FXML
    public ListView<String> fxChatList;

    private final Logger logger = LogManager.getLogger(MasterLayoutController.class);

    /**
     * Initializes the controller after its root element has been completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<String> items = FXCollections.observableArrayList();

        fxChatList.setOrientation(Orientation.VERTICAL);

        this.fxChatList.setItems(items);

        MyStompSessionHandler.session.subscribe("/message", new StompFrameHandler() {
            @Override
            public Type getPayloadType(StompHeaders headers) {
                return Message.class;
            }

            @Override
            public void handleFrame(StompHeaders headers, Object payload) {
                logger.info("Message: {}", payload);
                Message msg = (Message) payload;
                var v = "@" + msg.getFrom() + ": " + msg.getText();
                logger.info("Received : " + v);

                Platform.runLater(() -> {
                    fxChatList.getItems().add(v);
                    fxChatList.scrollTo(fxChatList.getItems().size());
                });
            }
        });
    }

    /**
     * Handles the event when the user clicks the 'Send' button in the user interface.
     *
     * @param event The mouse event triggered by the user's click
     */
    @FXML
    void fxOnClickSend(MouseEvent event) {

    }

    /**
     * Handles the key press event on the chat box.
     *
     * @param event The key event triggered by the user's key press
     */
    @FXML
    void fxOnChatBoxKeyPress(KeyEvent event) {
        logger.info(event.getCode().getName());
        if (Objects.equals(event.getCode().getName(), "Enter")) {
            Platform.runLater(() -> {
                MyStompSessionHandler.session.send("/app/message", new Message().setFrom(Data.user.getEmail()).setText(fxChatTextField.getText()));
                fxChatTextField.setText("");
                fxChatList.scrollTo(fxChatList.getItems().size());
            });
        }
    }

    /**
     * Handles the event when the user clicks the "Manage Staff" button in the user interface.
     *
     * @param event The mouse event triggered by the user's click
     */
    @FXML
    private void onClickManageStaff(MouseEvent event) {
        Navigate.to("staff_table.fxml");
    }

    /**
     * Handles the event when the user clicks the Manage Customer button.
     *
     * @param event The mouse event triggered by the user's click
     */
    @FXML
    private void onClickManageCustomer(MouseEvent event) {
        Navigate.to("customer_table.fxml");
    }

    /**
     * Handles the event when the user clicks the "Manage Orders" button in the user interface.
     *
     * @param event The mouse event triggered by the user's click
     */
    @FXML
    private void onClickManageOrders(MouseEvent event) {
        Navigate.to("orders_table.fxml");
    }

    /**
     * Handles the event when the user clicks the "Manage Salary" button in the user interface.
     *
     * @param event The mouse event triggered by the user's click
     */
    @FXML
    private void onClickManageSalary(MouseEvent event) {
        Navigate.to("pay_slip_table.fxml");
    }

    /**
     * Handles the event when the user clicks the "Manage Route" button in the user interface.
     *
     * @param event The mouse event triggered by the user's click
     */
    @FXML
    private void onClickManageRoute(MouseEvent event) {
        Navigate.to("route_table.fxml");
    }

    @FXML
    private void fxOnClickOrderReport(MouseEvent event) {
        Navigate.to("invoice_table.fxml");

    }
}

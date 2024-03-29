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
import org.jht.websocket.JTHWebSocketClient;
import org.jht.websocket.Message;
import org.jht.websocket.MyStompSessionHandler;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.Collections;
import java.util.Objects;
import java.util.ResourceBundle;

public class MasterLayoutController implements Initializable {

    @FXML
    public ListView<String> fxChatList;

    @FXML
    TextField fxChatTextField;

    private final Logger logger = LogManager.getLogger(MasterLayoutController.class);


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
                var v =  "@" + msg.getFrom() + ": " + msg.getText();
                logger.info("Received : " + v);

                Platform.runLater(() -> {
                    fxChatList.getItems().add(v);
                    fxChatList.scrollTo(fxChatList.getItems().size());
                });
            }
        });
    }

    @FXML
    void fxOnClickSend(MouseEvent event){

    }

    @FXML
    void fxOnChatBoxKeyPress(KeyEvent event){
        logger.info(event.getCode().getName());
        if(Objects.equals(event.getCode().getName(), "Enter")){
            Platform.runLater(() -> {
                MyStompSessionHandler.session.send("/app/message", new Message().setFrom(Data.user.getEmail()).setText(fxChatTextField.getText()));
                fxChatTextField.setText("");
                fxChatList.scrollTo(fxChatList.getItems().size());
            });
        }
    }

    /**
     * Invoke when the user click sign in
     *
     * @param event {@link MouseEvent}
     */
    @FXML
    private void onClickManageStaff(MouseEvent event) {
        Navigate.to("staff_table.fxml");
    }

    @FXML
    private void onClickManageCustomer(MouseEvent event) {
        Navigate.to("customer_table.fxml");
    }

    @FXML
    private void onClickManageOrders(MouseEvent event) {
        Navigate.to("orders_table.fxml");
    }

    @FXML
    private void onClickManageSalary(MouseEvent event) {
        Navigate.to("pay_slip_table.fxml");
    }

    @FXML
    private void onClickManageRoute(MouseEvent event) {
        Navigate.to("route_table.fxml");
    }
}

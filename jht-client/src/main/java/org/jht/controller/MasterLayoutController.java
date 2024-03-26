package org.jht.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import org.jht.support.Navigate;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class MasterLayoutController implements Initializable {

    @FXML
    public ListView<String> fxChatList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<String> items = FXCollections.observableArrayList(
                Collections.nCopies(100, "@you: This is a chat message")
        );

        this.fxChatList.setItems(items);
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
        Navigate.to("salary_table.fxml");
    }
}

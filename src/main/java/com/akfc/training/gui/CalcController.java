package com.akfc.training.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CalcController implements Initializable {

    private StringBuffer number = new StringBuffer();

    @FXML
    private GridPane rootPane;
    @FXML
    private Label display;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Calc launched");
    }

    @FXML
    protected void onNumberClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        number.append(button.getText());
        display.setText(number.toString());
    }

    @FXML
    protected void onOperationCall(ActionEvent event) {
        //TODO: Implement this method
    }

    @FXML
    protected void onExitEvent() {
        ((Stage) rootPane.getScene().getWindow()).close();
    }
}
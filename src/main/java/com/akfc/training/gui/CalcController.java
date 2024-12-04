package com.akfc.training.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.nfunk.jep.JEP;

import java.net.URL;
import java.util.ResourceBundle;

public class CalcController implements Initializable {

    private JEP jep = new JEP();
    private boolean resultDisplayed = false;

    @FXML
    private GridPane rootPane;
    @FXML
    private Label display;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Configuration initiale de JEP
        jep.addStandardFunctions();
        jep.addStandardConstants();
    }

    @FXML
    protected void onNumberClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        String btnText = button.getText();
        //TODO: implements number click
    }

    @FXML
    protected void onOperationCall(ActionEvent event) {
        //TODO: implements equals click
    }

    @FXML
    protected void onClearEvent(ActionEvent event) {
        //TODO: clear expression
    }

    private String formatResult(double result) {
        // Gestion de l'affichage des décimales
        return Math.abs(result - (long) result) < 0.0000001
                ? String.valueOf((long) result)
                : String.valueOf(result);
    }

    @FXML
    protected void onExitEvent() {
        ((Stage) rootPane.getScene().getWindow()).close();
    }
}
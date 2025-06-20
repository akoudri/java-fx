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

    private boolean resultDisplayed = false;

    @FXML
    private GridPane rootPane;
    @FXML
    private Label display;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize display
        display.setText("");
    }

    @FXML
    protected void onNumberClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        String btnText = button.getText();
        
        //TODO
    }

    @FXML
    protected void onOperationCall(ActionEvent event) {
        String expression = display.getText();
        
        if (expression.isEmpty()) {
            return;
        }
        
        //TODO: use evaluator
    }

    @FXML
    protected void onClearEvent(ActionEvent event) {
        display.setText("");
        resultDisplayed = false;
    }

    private String formatResult(double result) {
        return Math.abs(result - (long) result) < 0.0000001
                ? String.valueOf((long) result)
                : String.valueOf(result);
    }
    
    /**
     * Helper method to check if a string represents a numeric value
     */
    private boolean isNumeric(String str) {
        return str.matches("\\d");
    }
    
    /**
     * Helper method to check if the expression ends with an operator
     */
    private boolean endsWithOperator(String expression) {
        if (expression.isEmpty()) {
            return false;
        }
        char lastChar = expression.charAt(expression.length() - 1);
        return lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/' || lastChar == '(';
    }

    @FXML
    protected void onExitEvent() {
        ((Stage) rootPane.getScene().getWindow()).close();
    }
}
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
        
        // If a result was just displayed, clear it when starting a new calculation
        if (resultDisplayed && isNumeric(btnText)) {
            display.setText("");
            resultDisplayed = false;
        }
        
        // Get current display text
        String currentText = display.getText();
        
        // Handle different button types
        if (btnText.equals(".")) {
            // Only add decimal point if current number doesn't already have one
            if (!currentText.contains(".") || endsWithOperator(currentText)) {
                if (currentText.isEmpty() || endsWithOperator(currentText)) {
                    display.setText(currentText + "0.");
                } else {
                    display.setText(currentText + ".");
                }
            }
        } else {
            // For numbers and operators, simply append to display
            display.setText(currentText + btnText);
        }
        
        resultDisplayed = false;
    }

    @FXML
    protected void onOperationCall(ActionEvent event) {
        String expression = display.getText();
        
        if (expression.isEmpty()) {
            return;
        }
        
        try {
            // Parse and evaluate the expression using our custom evaluator
            double result = SimpleExpressionEvaluator.evaluate(expression);
            
            // Check if result is valid (not NaN or Infinite)
            if (Double.isNaN(result) || Double.isInfinite(result)) {
                display.setText("Error");
            } else {
                display.setText(formatResult(result));
                resultDisplayed = true;
            }
        } catch (Exception e) {
            display.setText("Error");
            resultDisplayed = true;
        }
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
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

    private StringBuffer number = new StringBuffer();

    private JEP jep = new JEP();
    private double result = 0d;
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
        String expression = number.toString();

        try {
            jep.parseExpression(expression);
            result = jep.getValue();
            display.setText(String.valueOf(result));
            number.setLength(0);
        } catch (Exception e) {
            display.setText("Error");
            number.setLength(0);
        }
    }

    @FXML
    protected void onExitEvent() {
        ((Stage) rootPane.getScene().getWindow()).close();
    }
}
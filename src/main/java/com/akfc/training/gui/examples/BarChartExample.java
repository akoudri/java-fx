package com.akfc.training.gui.examples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class BarChartExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        CategoryAxis hAxis = new CategoryAxis();
        hAxis.setLabel("Sales");

        NumberAxis vAxis = new NumberAxis();
        vAxis.setLabel("New Car Sales");

        BarChart<String, Number> bcSales = new BarChart(hAxis, vAxis);
        bcSales.setTitle("1st Quarter Sales Report");

        XYChart.Series<String,Number> jan = new XYChart.Series<>();
        XYChart.Series<String,Number> feb = new XYChart.Series<>();
        XYChart.Series<String,Number> mar = new XYChart.Series<>();

        jan.setName("January");
        feb.setName("February");
        mar.setName("March");

        jan.getData().add(new XYChart.Data<String, Number>("Mary",120000));
        jan.getData().add(new XYChart.Data<String, Number>("Tom",100000));

        feb.getData().add(new XYChart.Data<String, Number>("Mary",90000));
        feb.getData().add(new XYChart.Data<String, Number>("Tom",50000));

        mar.getData().add(new XYChart.Data<String, Number>("Mary",55000));
        mar.getData().add(new XYChart.Data<String, Number>("Tom",130000));

        bcSales.getData().add(jan);
        bcSales.getData().add(feb);
        bcSales.getData().add(mar);

        FlowPane root = new FlowPane();
        root.getChildren().add(bcSales);

        Scene scene = new Scene(root, 600, 500);

        stage.setTitle("Quarterly Sales");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

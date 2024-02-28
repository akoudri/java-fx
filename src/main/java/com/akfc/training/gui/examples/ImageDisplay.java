package com.akfc.training.gui.examples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ImageDisplay extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        Text title = new Text("Lenna");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        title.setFill(Color.FIREBRICK);

        Image caPic = new Image("Lenna.jpg");
        ImageView ivPic = new ImageView(caPic);

        pane.setTop(title);
        pane.setCenter(ivPic);

        Scene scene = new Scene(pane, 600, 800);

        stage.setTitle("California");
        stage.setScene(scene);
        stage.show();
    }
}

package com.akfc.training.gui.examples;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Effects extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox(5);
        root.setSpacing(20);
        root.getChildren().addAll(perspective(), dropShadow(), reflection());
        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Effects");
        stage.setScene(scene);
        stage.show();
    }

    private Node dropShadow() {
        Text t = new Text();
        t.setCache(true);
        t.setFill(Color.FIREBRICK);
        t.setText("AKFC Training");
        t.setFont(Font.font("null", FontWeight.BOLD, 32));
        DropShadow ds=new DropShadow();
        ds.setOffsetX(3.0);
        ds.setOffsetY(3.0);
        ds.setColor(Color.GRAY);
        t.setEffect(ds);
        return t;
    }

    private Node reflection() {
        Text t = new Text();
        t.setCache(true);
        t.setText("Formation Java FX");
        t.setFill(Color.CORNFLOWERBLUE);
        t.setFont(Font.font("null", FontWeight.BOLD, 30));

        Reflection r = new Reflection();
        r.setFraction(0.9);
        t.setEffect(r);
        t.setTranslateY(50);
        return t;
    }

    static Node perspective(){
        Group g = new Group();
        PerspectiveTransform pt = new PerspectiveTransform();
        pt.setUlx(10.0f);
        pt.setUly(10.0f);
        pt.setUrx(210.0f);
        pt.setUry(40.0f);
        pt.setLrx(210.0f);
        pt.setLry(60.0f);
        pt.setLlx(10.0f);
        pt.setLly(90.0f);

        g.setEffect(pt);
        g.setCache(true);

        Rectangle r = new Rectangle();
        r.setX(10.0f);
        r.setY(10.0f);
        r.setWidth(280.0f);
        r.setHeight(80.0f);
        r.setFill(Color.DODGERBLUE);

        Text t = new Text();
        t.setX(20.0f);
        t.setY(65.0f);
        t.setText("OpenJFX Training");
        t.setFill(Color.WHITE);
        t.setFont(Font.font("null", FontWeight.BOLD, 36));

        g.getChildren().addAll(r,t);
        return g;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

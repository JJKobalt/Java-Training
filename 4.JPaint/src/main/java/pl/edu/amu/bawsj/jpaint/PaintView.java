package pl.edu.amu.bawsj.jpaint;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;


import java.io.IOException;

/**
 * Created by JanJa on 02.12.2016.
 */
public class PaintView extends Application {


    private SplitPane root;
    PaintApplication application;
    VBox canvasBox;

    @Override
    public void start(Stage primaryStage) {


        try {
            root = FXMLLoader.load(getClass()
                    .getResource("/main_view.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

            canvasBox = (VBox) root.lookup("#canvasBox");
            Button newLayerButton = (Button)root.lookup("#newLayerButton");
            newLayerButton.setOnMouseClicked(event -> application.document.addLayer(new Layer("New Layer")));


            application = PaintApplication.getInstance(this);
            application.document.layers.addListener(new ListChangeListener() {

                public void onChanged(ListChangeListener.Change change) {

                    canvasBox.getChildren().clear();
                    for (int i = 0; i < application.document.layers.size(); i++) {

                        BorderPane pane = createCanvasPane(i);
                     //Todo: add  onMouseClick to change currentLayout
                        canvasBox.getChildren().add(pane);

                    }

                }
            });


            application.document.addLayer(new Layer("1"));
            application.document.addLayer(new Layer("2"));
            application.document.addLayer(new Layer("3"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BorderPane createCanvasPane(int i) {

        BorderPane pane = new BorderPane();
        TextField nameField = new TextField(application.document.layers.get(i).name);
nameField.setMaxSize(40,20);
        nameField.setStyle("-fx-font: 9 arial; ");
       // Label label = new Label(application.document.layers.get(i).name);
        pane.setLeft(nameField);

        BorderPane buttonPane = createButtonPane(i);
        pane.setRight(buttonPane);

        return pane;
    }

    private BorderPane createButtonPane(int i) {


        BorderPane ButtonPane = new BorderPane();

        BorderPane moveCanvasPane = createMoveCanvasPane(i);
        ButtonPane.setLeft(moveCanvasPane);

        Button deleteButton = getButton("DELETE");
        deleteButton.setStyle("-fx-font: 8 arial; ");
        deleteButton.setMaxSize(50,50);
        ButtonPane.setRight(deleteButton);

        deleteButton.setOnMouseClicked(event -> application.document.delete(i));

        return ButtonPane;
    }

    private BorderPane createMoveCanvasPane(int i) {
        BorderPane moveCanvasPane = new BorderPane();

        Button upButton = getButton("UP");
        moveCanvasPane.setTop(upButton);
        upButton.setOnMouseClicked(event -> application.document.moveUp(i));

        Button downButton = getButton("Down");
        moveCanvasPane.setBottom(downButton);
        downButton.setOnMouseClicked(event -> application.document.moveDown(i));
        return moveCanvasPane;
    }

    private Button getButton(String s) {
        Button button = new Button(s);
        button.setStyle("-fx-font: 10 arial; ");
        button.setMaxSize(50, 25);
        return button;
    }

    private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                new double[]{210, 210, 240, 240}, 4);
    }

    public Canvas createNewCanvas() {

System.out.println("Create new Canvas");
        AnchorPane pane = (AnchorPane) root.lookup("#canvasPane");
        Canvas canvas = new Canvas();
        canvas.setHeight(pane.getHeight());
        canvas.setWidth(pane.getWidth());
GraphicsContext gc = canvas.getGraphicsContext2D();
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        gc.fillOval(e.getX(),e.getY(),20,20);
                    }
                });
        pane.getChildren().add(canvas);

return canvas;
    }
}


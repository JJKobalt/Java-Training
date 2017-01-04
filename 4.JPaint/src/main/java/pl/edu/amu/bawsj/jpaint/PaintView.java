package pl.edu.amu.bawsj.jpaint;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import pl.edu.amu.bawsj.jpaint.DrawingStyle.LinearGradient;
import pl.edu.amu.bawsj.jpaint.State.DrawingCircleState;
import pl.edu.amu.bawsj.jpaint.DrawingStyle.DrawingStyle;
import pl.edu.amu.bawsj.jpaint.DrawingStyle.PlainColor;
import pl.edu.amu.bawsj.jpaint.DrawingStyle.WithBorders;
import pl.edu.amu.bawsj.jpaint.State.DrawingLineState;
import pl.edu.amu.bawsj.jpaint.State.DrawingRectangleState;
import pl.edu.amu.bawsj.jpaint.State.DrawingWithBrushState;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JanJa on 02.12.2016.
 */
public class PaintView extends Application {


    private SplitPane root;
    PaintApplication application;
    VBox canvasBox;
    ColorPicker firstColorPicker;
    ColorPicker secondColorPicker;
    TextField brushSizeTextField;

    ChoiceBox fillStyleChoiceBox;
    List<DrawingStyle> drawingStyles;

    @Override
    public void start(Stage primaryStage) {


        try {
            initializeRoot(primaryStage);
            initializeButtons();
            initializeColorPickers();
            initializeChoiceBox();
            initializeBrushSizeTextField();
            canvasBox = (VBox) root.lookup("#canvasBox");


            application = new PaintApplication(this);

            application.document.layers.addListener(new ListChangeListener() {

                public void onChanged(ListChangeListener.Change change) {

                    canvasBox.getChildren().clear();
                    for (int i = 0; i < application.document.layers.size(); i++) {

                        HBox pane = createCanvasManagmentPane(i);


                        canvasBox.getChildren().add(0, pane);

                    }

                }
            });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeChoiceBox() {
        initializeStylesList();
        fillStyleChoiceBox = (ChoiceBox) root.lookup("#fillStyleChoiceBox");
        fillStyleChoiceBox.setItems(FXCollections.observableArrayList(drawingStyles));
        fillStyleChoiceBox.getSelectionModel().selectFirst();

    }

    private void initializeStylesList() {
        drawingStyles = new ArrayList<>();
        drawingStyles.add(new PlainColor());
        drawingStyles.add(new WithBorders());
        drawingStyles.add(new LinearGradient());
    }


    public DrawingStyle getStyleType() {
        DrawingStyle style = (DrawingStyle) fillStyleChoiceBox.getValue();

        return style;
    }

    private void initializeColorPickers() {
        firstColorPicker = (ColorPicker) root.lookup("#firstColorPicker");
        secondColorPicker = (ColorPicker) root.lookup("#secondColorPicker");


    }

    private void initializeBrushSizeTextField() {
        brushSizeTextField = (TextField) root.lookup("#brushSizeTextField");
        brushSizeTextField.setText("10");
        brushSizeTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                brushSizeTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

    }
    private void initializeButtons() {
        Button newLayerButton = (Button) root.lookup("#newLayerButton");

        newLayerButton.setOnMouseClicked(event -> application.addNewLayer());

        Button DrawCircle = (Button) root.lookup("#drawCircleButton");
        DrawCircle.setOnMouseClicked(event -> application.changeState(new DrawingCircleState(application)));

        Button DrawRectangle = (Button) root.lookup("#drawRectangleButton");
        DrawRectangle.setOnMouseClicked(event -> application.changeState(new DrawingRectangleState(application)));

        Button DrawLine = (Button) root.lookup("#drawLineButton");
        DrawLine.setOnMouseClicked(event -> application.changeState(new DrawingLineState(application)));

       Button DrawCurve = (Button) root.lookup("#drawCurveButton");
        DrawCurve.setOnMouseClicked(event -> application.changeState(new DrawingWithBrushState(application)));



        Button showStackButton = (Button) root.lookup("#showStackButton");
        showStackButton.setOnMouseClicked(event ->{

                    application.printStackInConsole();
                }
               );



        Button undoButton = (Button) root.lookup("#undoButton");
        undoButton.setOnMouseClicked(event ->
                application.undoCommand());

        Button redoButton = (Button) root.lookup("#redoButton");
        redoButton.setOnMouseClicked(event ->
                application.redoCommand());


    }

    private void initializeRoot(Stage primaryStage) throws IOException {
        root = FXMLLoader.load(getClass()
                .getResource("/main_view.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public void removeObject(Object obj) {
        Pane canvasPane = (AnchorPane) root.lookup("#canvasPane");
        canvasPane.getChildren().remove(obj);

    }


    private HBox createCanvasManagmentPane(int position) {

        HBox pane = new HBox();
        pane.getChildren().add(createNamePane(position));
        pane.getChildren().add(createMoveCanvasPane(position));
        pane.getChildren().add(createDeleteButton(position));
        return pane;
    }

    private Node createNamePane(int position) {

        BorderPane namePane = new BorderPane();

        namePane.setTop(createCanvasNameField(position));
        namePane.setBottom(createSelectButton(position));

        return namePane;
    }

    private TextField createCanvasNameField(int position) {

        Layer newLayer = application.getLayerAt(position);
        TextField nameField = new TextField(newLayer.name);

        nameField.textProperty().addListener((observable, oldValue, newValue) -> {

            newLayer.changeName(newValue);
        });
        nameField.setMaxSize(40, 20);
        nameField.setStyle("-fx-font: 9 arial; ");
        return nameField;
    }

    private Button createSelectButton(int position) {
        Button selectButton = new Button("select");

        addChangeColorOnSelect(position, selectButton);

        selectButton.setOnMouseClicked(event ->
                {
                    application.setCurrentLayer(position);

                }
        );
        return selectButton;
    }

    private void addChangeColorOnSelect(int position, Button selectButton) {
        StringProperty color = new SimpleStringProperty();
        selectButton.setStyle("-fx-base: " + application.document.layers.get(position).color.getValue() + " ;");
        application.document.layers.get(position).color.addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                selectButton.setStyle("-fx-base: " + newValue + " ;");

            }
        });


    }


    private Button createDeleteButton(int position) {
        Button deleteButton = getButton("DELETE");
        deleteButton.setOnMouseClicked(event -> application.deleteLayer(position));
        deleteButton.setStyle("-fx-font: 8 arial; ");
        deleteButton.setMaxSize(50, 50);
        return deleteButton;
    }


    private BorderPane createMoveCanvasPane(int i) {
        BorderPane moveCanvasPane = new BorderPane();

        Button upButton = getButton("UP");
        moveCanvasPane.setTop(upButton);
        upButton.setOnMouseClicked(event -> {
            application.moveLayerUp(i);

        });

        Button downButton = getButton("Down");
        moveCanvasPane.setBottom(downButton);
        downButton.setOnMouseClicked(event -> {
            application.moveLayerDown(i);

        });
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


        AnchorPane pane = (AnchorPane) root.lookup("#canvasPane");
        Canvas canvas = getResizableCanvas(pane);

        initializeCanvasEventHandler(canvas);
        pane.getChildren().add(canvas);

        return canvas;
    }

    private void initializeCanvasEventHandler(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                e -> application.handleMouseButtonPressed(e.getX(), e.getY(), gc));

        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED,
                e -> application.handleMouseButtonRelesed(e.getX(), e.getY(), gc));

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
                e -> application.handleMouseButtonDragged(e.getX(), e.getY(), gc));
    }

    private Canvas getResizableCanvas(AnchorPane pane) {
        Canvas canvas = new Canvas();

        canvas.heightProperty().bind(pane.widthProperty());
        canvas.widthProperty().bind(pane.widthProperty());
        return canvas;
    }

    public Color getFirstColor() {
        return firstColorPicker.getValue();
    }

    public Color getSecondColor() {
        return secondColorPicker.getValue();
    }

    public int getBrushSize() {
        return Integer.parseInt(brushSizeTextField.getText());
    }
}


package pl.edu.amu.bawsj.jpaint;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import pl.edu.amu.bawsj.jpaint.shape.Shape;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by JanJa on 08.12.2016.
 */
public class Layer {
    public Canvas canvas;
    public String name;
    StringProperty color;
    List<Shape> drawables;



    public Layer(String name) {
        this.name=name;
        color = new SimpleStringProperty();
        drawables = new ArrayList<>();


    }

    public Layer(String layerName, Canvas newCanvas) {
        this.name=layerName;
        color = new SimpleStringProperty();
        drawables = new ArrayList<>();
        canvas = newCanvas;
    }

    public void changeName(String newValue) {
        name=newValue;
    }


    public void changeColor(Colors newColor){

        color.setValue(newColor.toString());
    }

    public void addDrawable(Shape drawable) {
    drawables.add(drawable);
    }

    public void redraw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());


        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);


        for (Shape drawable : drawables) {
            drawable.draw(gc);
        }




    }

    public void removeLast() {
        drawables.remove(drawables.size() - 1);
        redraw();
    }


    public BufferedImage getLayerAsBufferedImage() {

        WritableImage writableImage = new WritableImage((int) canvas.getWidth(), (int) canvas.getHeight());

        canvas.snapshot(null, writableImage);
        BufferedImage image = SwingFXUtils.fromFXImage(writableImage, null);
        return image;
    }



}

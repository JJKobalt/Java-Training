package pl.edu.amu.bawsj.jpaint;

import javafx.beans.property.StringProperty;
import javafx.scene.canvas.*;
import javafx.scene.shape.Shape;

import java.util.List;


/**
 * Created by JanJa on 08.12.2016.
 */
public class Layer {
    javafx.scene.canvas.Canvas canvas;
    String name;


    public Layer(String name) {

        this.name=name;
    }

    public void changeName(String newValue) {
        name=newValue;
    }
}

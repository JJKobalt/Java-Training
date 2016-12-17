package pl.edu.amu.bawsj.jpaint;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;


/**
 * Created by JanJa on 08.12.2016.
 */
public class Layer {
    javafx.scene.canvas.Canvas canvas;
   public String name;
StringProperty color;

    public Layer(String name) {

        this.name=name;
        color = new SimpleStringProperty();


    }

    public void changeName(String newValue) {
        name=newValue;
    }


    public void changeColor(Colors newColor){

        color.setValue(newColor.toString());
    }

}

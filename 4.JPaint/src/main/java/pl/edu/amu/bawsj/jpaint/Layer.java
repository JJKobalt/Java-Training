package pl.edu.amu.bawsj.jpaint;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import pl.edu.amu.bawsj.jpaint.Drawables.Drawable;
import pl.edu.amu.bawsj.jpaint.Drawables.Ellipse;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by JanJa on 08.12.2016.
 */
public class Layer {
    public javafx.scene.canvas.Canvas canvas;
    public String name;
    StringProperty color;
    List<Drawable> drawables;



    public Layer(String name) {

        this.name=name;
        color = new SimpleStringProperty();
        drawables = new ArrayList<>();

    }

    public void changeName(String newValue) {
        name=newValue;
    }


    public void changeColor(Colors newColor){

        color.setValue(newColor.toString());
    }

    public void addDrawable(Drawable drawable) {
    drawables.add(drawable);
    }

    public void redraw() {

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);



for(Drawable drawable:drawables)
{
    drawable.draw(gc);
}




    }
}

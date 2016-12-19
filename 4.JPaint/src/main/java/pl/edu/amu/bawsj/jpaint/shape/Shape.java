package pl.edu.amu.bawsj.jpaint.shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import pl.edu.amu.bawsj.jpaint.DrawingStyle.DrawingStyle;

/**
 * Created by JanJa on 17.12.2016.
 */
public abstract class Shape {

    protected Color firstColor;
    protected Color secondColor;
    public DrawingStyle drawingStyle;





    public abstract void draw(GraphicsContext gc);





    public Color getSecondColor() {
        return secondColor;
    }

    public void setSecondColor(Color secondColor) {
        this.secondColor = secondColor;
    }


    public Color getFirstColor() {
        return firstColor;
    }

    public void setFirstColor(Color firstColor) {
        this.firstColor = firstColor;
    }
}

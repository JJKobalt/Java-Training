package pl.edu.amu.bawsj.jpaint.DrawingStyle;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import pl.edu.amu.bawsj.jpaint.shape.Ellipse;
import pl.edu.amu.bawsj.jpaint.shape.Rectangle;

/**
 * Created by JanJa on 18.12.2016.
 */
public class PlainColor implements DrawingStyle {


    @Override
    public GraphicsContext setFill(GraphicsContext gc, Color firstColor, Color secondColor) {
        gc.setFill(firstColor);


        return gc;
    }

    @Override
    public void drawOval(GraphicsContext gc, Ellipse ellipse) {

        gc.fillOval(ellipse.getCoordinates().x, ellipse.getCoordinates().y, ellipse.getRadius().x, ellipse.getRadius().y);
    }


    @Override
    public void drawRectangle(GraphicsContext gc, Rectangle rectangle) {
        gc.fillRect(rectangle.getTopLeft().x,rectangle.getTopLeft().y,rectangle.getWidth(),rectangle.getHeight());
    }



    @Override
    public String toString()
    {
        return  "Plain Color";
    }
}

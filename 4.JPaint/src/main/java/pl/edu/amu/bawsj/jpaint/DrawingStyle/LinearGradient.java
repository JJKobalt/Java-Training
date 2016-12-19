package pl.edu.amu.bawsj.jpaint.DrawingStyle;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Stop;
import pl.edu.amu.bawsj.jpaint.shape.Ellipse;
import pl.edu.amu.bawsj.jpaint.shape.Rectangle;

/**
 * Created by JanJa on 18.12.2016.
 */
public class LinearGradient implements DrawingStyle{

    @Override
    public GraphicsContext setFill(GraphicsContext gc, Color firstColor, Color secondColor) {
        javafx.scene.paint.LinearGradient lg = new   javafx.scene.paint.LinearGradient(0, 0, 1, 1, true,
                CycleMethod.REFLECT,
                new Stop(0.0, firstColor),
                new Stop(1.0, secondColor));

        gc.setFill(lg);
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
        return  "Linear Gradient";
    }
}

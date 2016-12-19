package pl.edu.amu.bawsj.jpaint.DrawingStyle;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import pl.edu.amu.bawsj.jpaint.shape.Ellipse;
import pl.edu.amu.bawsj.jpaint.shape.Rectangle;

/**
 * Created by JanJa on 18.12.2016.
 */
public interface DrawingStyle {

    public GraphicsContext setFill(GraphicsContext gc, Color firstColor, Color secondColor);

    void drawOval(GraphicsContext gc, Ellipse ellipse);

    void drawRectangle(GraphicsContext gc, Rectangle rectangle);
}

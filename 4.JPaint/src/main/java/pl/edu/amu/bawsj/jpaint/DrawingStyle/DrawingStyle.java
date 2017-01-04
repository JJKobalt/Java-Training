package pl.edu.amu.bawsj.jpaint.DrawingStyle;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import pl.edu.amu.bawsj.jpaint.shape.Ellipse;
import pl.edu.amu.bawsj.jpaint.shape.Line;
import pl.edu.amu.bawsj.jpaint.shape.Rectangle;
import pl.edu.amu.bawsj.jpaint.shape.Shape;

/**
 * Created by JanJa on 18.12.2016.
 */
public abstract class DrawingStyle {




    public abstract GraphicsContext setFill(GraphicsContext gc, Color firstColor, Color secondColor);

   public abstract void draw(GraphicsContext gc, Ellipse ellipse, Color firstColor, Color secondColor,int brushSize);

   public abstract void draw(GraphicsContext gc, Rectangle rectangle, Color firstColor, Color secondColor,int brushSize);
    public abstract void draw(GraphicsContext gc, Shape shape, Color firstColor, Color secondColor,int brushSize);
    public abstract void draw(GraphicsContext gc, Line line, Color firstColor, Color secondColor,int brushSize);



}

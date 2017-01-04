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
public class PlainColor extends DrawingStyle {


    @Override
    public GraphicsContext setFill(GraphicsContext gc, Color firstColor, Color secondColor) {
        gc.setFill(firstColor);
        gc.setStroke(firstColor);

        return gc;
    }

    @Override
    public void draw(GraphicsContext gc, Ellipse ellipse,Color firstColor, Color secondColor,int brushSize) {
        gc = setFill(gc, firstColor, secondColor);
        gc.fillOval(ellipse.getCoordinates().x, ellipse.getCoordinates().y, ellipse.getRadius().x, ellipse.getRadius().y);
    }


    @Override
    public void draw(GraphicsContext gc, Rectangle rectangle,Color firstColor, Color secondColor,int brushSize) {
        gc = setFill(gc, firstColor, secondColor);
        gc.fillRect(rectangle.getTopLeft().x,rectangle.getTopLeft().y,rectangle.getWidth(),rectangle.getHeight());
    }


    @Override
    public void draw(GraphicsContext gc, Shape shape,Color firstColor, Color secondColor,int brushSize) {

        System.err.println("NO defined shape");
    }

    @Override
    public void draw(GraphicsContext gc, Line line,Color firstColor, Color secondColor,int brushSize) {
        gc = setFill(gc, firstColor, secondColor);
        gc.setLineWidth(brushSize);
        gc.strokeLine(line.getStartCoordinates().x, line.getStartCoordinates().y, line.getEndCoordinates().x, line.getEndCoordinates().y);
    }

    @Override
    public String toString()
    {
        return  "Plain Color";
    }
}

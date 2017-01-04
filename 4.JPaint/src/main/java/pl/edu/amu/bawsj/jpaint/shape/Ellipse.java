package pl.edu.amu.bawsj.jpaint.shape;

import javafx.scene.canvas.GraphicsContext;
import pl.edu.amu.bawsj.jpaint.Coordinates;
import pl.edu.amu.bawsj.jpaint.DrawingStyle.DrawingStyle;

/**
 * Created by JanJa on 17.12.2016.
 */
public class Ellipse extends Shape {

    private Coordinates coordinates;
    private Coordinates radius;
    private double rotate;




    public Ellipse(DrawingStyle styleType, Coordinates coordinates, Coordinates radius) {
        rotate = 0;
        this.drawingStyle = styleType;
        this.coordinates = coordinates;
        this.radius = radius;
    }

    public void draw(GraphicsContext gc)
    {
        gc.save();
        gc.rotate(rotate);
        drawingStyle.draw(gc,this,firstColor, secondColor,brushSize);
        gc.restore();
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double x, double y) {
        coordinates = new Coordinates(x, y);
    }

    public Coordinates getRadius() {
        return radius;
    }

    public void setRadius(double x, double y) {
        radius = new Coordinates(x, y);
    }

    public double getX() {
        return coordinates.x;
    }

    public double getY() {
        return coordinates.y;
    }


    public void setRadius(Coordinates coordinates) {
        radius=coordinates;
    }

    public String toString(){
        return "Ellipse x:"+ coordinates.x+ "  y:"+coordinates.y;
    }
}

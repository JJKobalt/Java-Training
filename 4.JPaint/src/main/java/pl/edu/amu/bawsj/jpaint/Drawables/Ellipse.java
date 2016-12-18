package pl.edu.amu.bawsj.jpaint.Drawables;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import pl.edu.amu.bawsj.jpaint.Coordinates;

/**
 * Created by JanJa on 17.12.2016.
 */
public class Ellipse implements Drawable {

    private Coordinates coordinates;
    private Coordinates radius;
    private double rotate;
    private Color firstColor;
    private Color secondColor;

    public Coordinates getCoordinates() {
        return coordinates;
    }




    public Ellipse() {
        rotate = 0;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.save();
        gc.rotate(rotate);
        gc.fillOval(coordinates.x, coordinates.y, radius.x, radius.y);
       gc.restore();


    }


    public double getX() {
        return coordinates.x;
    }

    public double getY() {
        return coordinates.y;
    }

    public void setCoordinates(double x, double y) {
        coordinates = new Coordinates(x, y);
    }

    public void setRadius(double x, double y) {
        radius = new Coordinates(x, y);
    }


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

    public void setRadius(Coordinates coordinates) {
        radius=coordinates;
    }
}

package pl.edu.amu.bawsj.jpaint.shape;


import javafx.scene.canvas.GraphicsContext;
import pl.edu.amu.bawsj.jpaint.Coordinates;
import pl.edu.amu.bawsj.jpaint.DrawingStyle.DrawingStyle;

/**
 * Created by JanJa on 19.12.2016.
 */
public class Line extends Shape {

    private Coordinates startCoordinates;
    private Coordinates endCoordinates;

    public Line(DrawingStyle drawingStyle) {

        this.drawingStyle = drawingStyle;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.save();
        drawingStyle.draw(gc,this,firstColor, secondColor, brushSize);
        gc.restore();
    }


    public Coordinates getStartCoordinates() {
        return startCoordinates;
    }

    public void setStartCoordinates(Coordinates startCoordinates) {
        this.startCoordinates = startCoordinates;
    }

    public void setStartCoordinates(double x, double y) {
        this.startCoordinates = new Coordinates(x,y);
    }

    public Coordinates getEndCoordinates() {
        return endCoordinates;
    }

    public void setEndCoordinates(Coordinates endCoordinates) {

        this.endCoordinates = endCoordinates;
    }
    public void setEndCoordinates(double x, double y) {
        this.endCoordinates = new Coordinates(x,y);
    }

}

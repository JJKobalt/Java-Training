package pl.edu.amu.bawsj.jpaint.shape;

import javafx.scene.canvas.GraphicsContext;
import pl.edu.amu.bawsj.jpaint.Coordinates;
import pl.edu.amu.bawsj.jpaint.DrawingStyle.DrawingStyle;

/**
 * Created by JanJa on 19.12.2016.
 */
public class Rectangle extends Shape {

    private Coordinates topLeft;
    private Coordinates diagonalCoordinates;
    private double rotate;

    @Override
    public void draw(GraphicsContext gc) {


        gc.save();
        gc = drawingStyle.setFill(gc, firstColor, secondColor);
        gc.rotate(rotate);
        drawingStyle.drawRectangle(gc, this);
        gc.restore();


    }
    public Rectangle(DrawingStyle drawingStyle) {
        rotate = 0;
        this.drawingStyle = drawingStyle;
    }

    public Coordinates getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Coordinates topLeft) {
        this.topLeft = topLeft;
    }
    public void setTopLeft(double x, double y) {
        this.topLeft = new Coordinates(x,y);
    }

    public Coordinates getDiagonalCoordinates() {
        return diagonalCoordinates;
    }

    public void setDiagonalCoordinates(Coordinates diagonalCoordinates) {
        this.diagonalCoordinates = diagonalCoordinates;
    }

    public void setDiagonalCoordinates(double x , double y) {
        this.diagonalCoordinates = new Coordinates(x,y);
    }
    public double getRotate() {
        return rotate;
    }

    public void setRotate(double rotate) {
        this.rotate = rotate;
    }


    public double getWidth(){
       return  diagonalCoordinates.x;
    }

    public double getHeight(){
        return diagonalCoordinates.y;
    }


    public String toString(){
        return "Rectangle  TL x:"+ topLeft.x+ "  TL y:"+topLeft.y;
    }
}

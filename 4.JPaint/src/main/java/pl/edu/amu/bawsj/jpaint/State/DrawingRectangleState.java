package pl.edu.amu.bawsj.jpaint.State;

import javafx.scene.canvas.GraphicsContext;
import pl.edu.amu.bawsj.jpaint.Commands.DrawCommand;
import pl.edu.amu.bawsj.jpaint.Coordinates;
import pl.edu.amu.bawsj.jpaint.shape.Rectangle;
import pl.edu.amu.bawsj.jpaint.PaintApplication;

import static java.lang.Math.abs;

/**
 * Created by JanJa on 19.12.2016.
 */
public class DrawingRectangleState extends DrawingState {
    Rectangle rectangle;
    Coordinates anchor;


    public DrawingRectangleState(PaintApplication application) {
        super(application);
    }

    @Override
    public void handleMouseButtonPressed(Double x, Double y, GraphicsContext gc) {

        rectangle = new Rectangle(application.getStyleType());

        anchor = new Coordinates(x,y);

        rectangle.setFirstColor(application.getFirstColor());
        rectangle.setSecondColor(application.getSecondColor());
    }

    @Override
    public void handleMouseButtonRelesed(Double x, Double y, GraphicsContext gc) {

        if(rectangle.getTopLeft()!=null)
            application.document.addDrawable(rectangle);
        application.addToCommandStack(new DrawCommand( application.document.getCurrentLayer(),rectangle));


    }

    @Override
    public void handleMouseButtonDragged(Double x, Double y, GraphicsContext gc) {


        application.document.redrawCurrent();
        if (x < anchor.x && y < anchor.y) {
            rectangle.setTopLeft(x , y);
            rectangle.setDiagonalCoordinates(abs(anchor.x - x), abs(anchor.y - y));
            rectangle.draw(gc);
        }
        if (x > anchor.x && y < anchor.y) {
            rectangle.setTopLeft(anchor.x, y);
            rectangle.setDiagonalCoordinates(abs(anchor.x - x), abs(anchor.y - y));
            rectangle.draw(gc);
        }
        if (x < anchor.x && y > anchor.y) {
            rectangle.setTopLeft(x, anchor.y);
            rectangle.setDiagonalCoordinates(abs(anchor.x - x), abs(anchor.y - y));
            rectangle.draw(gc);
        }
        if (x > anchor.x && y > anchor.y) {

            rectangle.setTopLeft(anchor.x, anchor.y);
            rectangle.setDiagonalCoordinates(abs(anchor.x - x), abs(anchor.y - y));
            rectangle.draw(gc);

        }


    }


}

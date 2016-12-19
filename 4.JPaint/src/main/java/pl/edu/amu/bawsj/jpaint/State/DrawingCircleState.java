package pl.edu.amu.bawsj.jpaint.State;

import javafx.scene.canvas.*;
import pl.edu.amu.bawsj.jpaint.Commands.DrawCommand;
import pl.edu.amu.bawsj.jpaint.Coordinates;
import pl.edu.amu.bawsj.jpaint.shape.Ellipse;
import pl.edu.amu.bawsj.jpaint.PaintApplication;


import static java.lang.Math.abs;

/**
 * Created by JanJa on 07.12.2016.
 */
public class DrawingCircleState extends DrawingState {
    Ellipse ellipse;
    Coordinates anchor;


    public DrawingCircleState(PaintApplication application) {
        super(application);


    }

    @Override
    public void handleMouseButtonPressed(Double x, Double y, GraphicsContext gc) {

        ellipse = new Ellipse(application.getStyleType());

        anchor = new Coordinates(x, y);

        ellipse.setFirstColor(application.getFirstColor());
        ellipse.setSecondColor(application.getSecondColor());
    }

    public void handleMouseButtonRelesed(Double x, Double y, GraphicsContext gc) {

        if(ellipse.getCoordinates()!=null)
        application.document.addDrawable(ellipse);
        application.addToCommandStack(new DrawCommand(application.document.getCurrentLayer(), ellipse));

    }

    @Override
    public void handleMouseButtonDragged(Double x, Double y, GraphicsContext gc) {

        application.document.redrawCurrent();
        if (x < anchor.x && y < anchor.y) {
            ellipse.setCoordinates(x, y);
            ellipse.setRadius(abs(anchor.x - x), abs(anchor.y - y));
            ellipse.draw(gc);
        }
        if (x > anchor.x && y < anchor.y) {
            ellipse.setCoordinates(anchor.x, y);
            ellipse.setRadius(abs(anchor.x - x), abs(anchor.y - y));
            ellipse.draw(gc);
        }
        if (x < anchor.x && y > anchor.y) {
            ellipse.setCoordinates(x, anchor.y);
            ellipse.setRadius(abs(anchor.x - x), abs(anchor.y - y));
            ellipse.draw(gc);
        }
        if (x > anchor.x && y > anchor.y) {

            ellipse.setCoordinates(anchor.x, anchor.y);
            ellipse.setRadius(abs(anchor.x - x), abs(anchor.y - y));
            ellipse.draw(gc);

        }


    }

}

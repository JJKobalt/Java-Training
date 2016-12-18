package pl.edu.amu.bawsj.jpaint.State;

import javafx.scene.canvas.*;
import javafx.scene.shape.Circle;
import pl.edu.amu.bawsj.jpaint.Coordinates;
import pl.edu.amu.bawsj.jpaint.Drawables.Ellipse;
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
        clicksCount = 0;

    }







    @Override
    public void handleMouseButtonPressed(Double x, Double y, GraphicsContext gc) {

        ellipse = new Ellipse();
        this.gc=gc;
        anchor = new Coordinates(x, y);


        ellipse.setFirstColor(application.getFirstColor());


    }

    public void handleMouseButtonRelesed(Double x, Double y, GraphicsContext gc) {
        System.out.println("po relesed "+ellipse.getCoordinates());
        if(ellipse.getCoordinates()!=null)
        application.document.addDrawable(ellipse);

    }

    @Override
    public void handleMouseButtonDragged(Double x, Double y, GraphicsContext gc) {
        Canvas can = gc.getCanvas();
        gc.clearRect(0, 0, can.getWidth(), can.getHeight());
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
        System.out.println("po draged "+ellipse.getCoordinates());

    }

    @Override
    public void setApplication(PaintApplication application) {

    }
}

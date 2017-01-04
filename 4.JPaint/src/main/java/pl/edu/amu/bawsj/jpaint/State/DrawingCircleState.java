package pl.edu.amu.bawsj.jpaint.State;

import javafx.scene.canvas.*;
import pl.edu.amu.bawsj.jpaint.Commands.DrawCommand;
import pl.edu.amu.bawsj.jpaint.Coordinates;
import pl.edu.amu.bawsj.jpaint.DrawingStyle.DrawingStyle;
import pl.edu.amu.bawsj.jpaint.shape.Ellipse;
import pl.edu.amu.bawsj.jpaint.PaintApplication;


import static java.lang.Math.abs;

/**
 * Created by JanJa on 07.12.2016.
 */
public class DrawingCircleState extends DrawingState {
    Ellipse ellipse;
    Coordinates anchor;
    int brushSize ;

    public DrawingCircleState(PaintApplication application) {
        super(application);


    }

    @Override
    public void handleMouseButtonPressed(Double x, Double y, GraphicsContext gc) {

        //  ellipse = new Ellipse(application.getStyleType());

        anchor = new Coordinates(x, y);
        brushSize = application.getBrushSize();

    }

    public void handleMouseButtonRelesed(Double x, Double y, GraphicsContext gc) {
System.out.println("Relesed");
        saveShape(ellipse);


    }

    @Override
    public void handleMouseButtonDragged(Double x, Double y, GraphicsContext gc) {

        application.document.redrawCurrent();
        DrawingStyle style = application.getStyleType();

        if (x <= anchor.x && y <= anchor.y) {

            ellipse = new Ellipse(style, new Coordinates(x, y), new Coordinates(abs(anchor.x - x), abs(anchor.y - y)));


        } else if (x > anchor.x && y <= anchor.y) {
            ellipse = new Ellipse(style, new Coordinates(anchor.x, y), new Coordinates(abs(anchor.x - x), abs(anchor.y - y)));


        } else if (x <= anchor.x && y > anchor.y) {
            ellipse = new Ellipse(style, new Coordinates(x, anchor.y), new Coordinates(abs(anchor.x - x), abs(anchor.y - y)));


        } else if (x > anchor.x && y > anchor.y) {
            ellipse = new Ellipse(style, new Coordinates(anchor.x, anchor.y), new Coordinates(abs(anchor.x - x), abs(anchor.y - y)));


        }
        try {
            ellipse.setFirstColor(application.getFirstColor());
            ellipse.setSecondColor(application.getSecondColor());
            ellipse.setBrushSize(brushSize);
            ellipse.draw(gc);
        }catch (NullPointerException e)
        {
            System.out.println("anchor:  " + anchor.x + ":" + anchor.y+"   current:  "+ x+":"+y);

        }
    }

}

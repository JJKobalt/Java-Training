package pl.edu.amu.bawsj.jpaint.State;

import javafx.scene.canvas.GraphicsContext;
import pl.edu.amu.bawsj.jpaint.Commands.DrawCommand;
import pl.edu.amu.bawsj.jpaint.Coordinates;
import pl.edu.amu.bawsj.jpaint.DrawingStyle.DrawingStyle;
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



        anchor = new Coordinates(x,y);


    }

    @Override
    public void handleMouseButtonRelesed(Double x, Double y, GraphicsContext gc) {

        saveShape(rectangle);



    }

    @Override
    public void handleMouseButtonDragged(Double x, Double y, GraphicsContext gc) {


        application.document.redrawCurrent();
        DrawingStyle style = application.getStyleType();

        if (x <= anchor.x && y <= anchor.y) {
            rectangle = new Rectangle(style, new Coordinates(x, y), new Coordinates(abs(anchor.x - x), abs(anchor.y - y)));


        } else if (x > anchor.x && y <= anchor.y) {
            rectangle = new Rectangle(style, new Coordinates(anchor.x, y), new Coordinates(abs(anchor.x - x), abs(anchor.y - y)));

        }
        if (x <= anchor.x && y > anchor.y) {
            rectangle = new Rectangle(style, new Coordinates(x, anchor.y), new Coordinates(abs(anchor.x - x), abs(anchor.y - y)));
        }
        if (x > anchor.x && y > anchor.y) {

            rectangle = new Rectangle(style, new Coordinates(anchor.x, anchor.y), new Coordinates(abs(anchor.x - x), abs(anchor.y - y)));

        }
        rectangle.setFirstColor(application.getFirstColor());
        rectangle.setSecondColor(application.getSecondColor());
        rectangle.draw(gc);
    }


}

package pl.edu.amu.bawsj.jpaint.State;

import javafx.scene.canvas.GraphicsContext;
import pl.edu.amu.bawsj.jpaint.Commands.DrawCommand;
import pl.edu.amu.bawsj.jpaint.Coordinates;
import pl.edu.amu.bawsj.jpaint.PaintApplication;
import pl.edu.amu.bawsj.jpaint.shape.Line;
import pl.edu.amu.bawsj.jpaint.shape.Rectangle;

import static java.lang.Math.abs;

/**
 * Created by JanJa on 19.12.2016.
 */
public class DrawingLineState extends DrawingState {
    Line line;
    Coordinates anchor;


    public DrawingLineState(PaintApplication application) {
        super(application);
    }


    @Override
    public void handleMouseButtonPressed(Double x, Double y, GraphicsContext gc) {

        line = new Line(application.getStyleType());

        anchor = new Coordinates(x, y);
        line.setStartCoordinates(x, y);
        line.setFirstColor(application.getFirstColor());
        line.setSecondColor(application.getSecondColor());
        int brushSize = application.getBrushSize();
        line.setBrushSize(brushSize);
    }

    @Override
    public void handleMouseButtonRelesed(Double x, Double y, GraphicsContext gc) {

        saveShape(line);

    }

    @Override
    public void handleMouseButtonDragged(Double x, Double y, GraphicsContext gc) {


        application.document.redrawCurrent();


            line.setEndCoordinates(x, y);

            line.draw(gc);



    }
}

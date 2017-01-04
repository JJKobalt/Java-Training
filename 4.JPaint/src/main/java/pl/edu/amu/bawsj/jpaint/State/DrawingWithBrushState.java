package pl.edu.amu.bawsj.jpaint.State;

import javafx.scene.canvas.GraphicsContext;
import pl.edu.amu.bawsj.jpaint.Coordinates;
import pl.edu.amu.bawsj.jpaint.DrawingStyle.DrawingStyle;
import pl.edu.amu.bawsj.jpaint.PaintApplication;
import pl.edu.amu.bawsj.jpaint.shape.BrushCurve;
import pl.edu.amu.bawsj.jpaint.shape.Ellipse;
import pl.edu.amu.bawsj.jpaint.shape.Line;
import pl.edu.amu.bawsj.jpaint.shape.Shape;

/**
 * Created by JanJa on 31.12.2016.
 */
public class DrawingWithBrushState extends DrawingState {

    BrushCurve curve;
    Coordinates prevCoordinates;

    public DrawingWithBrushState(PaintApplication application) {
        super(application);
    }

    @Override
    public void handleMouseButtonPressed(Double x, Double y, GraphicsContext gc) {
        curve = new BrushCurve();
        prevCoordinates = new Coordinates(x, y);
    }

    @Override
    public void handleMouseButtonRelesed(Double x, Double y, GraphicsContext gc) {
        saveShape(curve);
    }

    @Override
    public void handleMouseButtonDragged(Double x, Double y, GraphicsContext gc) {


        application.document.redrawCurrent();

        DrawingStyle style = application.getStyleType();
        Line newLine = new Line(style);
        newLine.setStartCoordinates(prevCoordinates);
        newLine.setEndCoordinates(x, y);
        newLine.setBrushSize(application.getBrushSize());
        newLine.setFirstColor(application.getFirstColor());
        newLine.setSecondColor(application.getSecondColor());
        curve.add(newLine);


        curve.draw(gc);
        prevCoordinates = new Coordinates(x, y);
    }

    private Shape EllipseBrush(Double x, Double y, DrawingStyle style, double brushSizeCorrection) {
        Shape ellipse = new Ellipse(style, new Coordinates(x, y), new Coordinates(brushSizeCorrection, brushSizeCorrection));
        ellipse.setFirstColor(application.getFirstColor());
        ellipse.setSecondColor(application.getSecondColor());
        return ellipse;
    }
}

package pl.edu.amu.bawsj.jpaint.State;

import javafx.scene.canvas.GraphicsContext;
import pl.edu.amu.bawsj.jpaint.Commands.DrawCommand;
import pl.edu.amu.bawsj.jpaint.PaintApplication;
import pl.edu.amu.bawsj.jpaint.shape.Shape;

/**
 * Created by JanJa on 07.12.2016.
 */
public abstract class DrawingState implements AppState{


    PaintApplication application;

    int clicksCount;



    public DrawingState(PaintApplication application) {
        this.application = application;
    }


    void saveShape(Shape shape)
    {
        application.document.addDrawable(shape);
        application.addToCommandStack(new DrawCommand( application.document.getCurrentLayer(),shape));

    }

}

package pl.edu.amu.bawsj.jpaint.State;

import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import pl.edu.amu.bawsj.jpaint.PaintApplication;

import java.awt.*;

/**
 * Created by JanJa on 07.12.2016.
 */
public abstract class DrawingState implements AppState{

   GraphicsContext gc;
PaintApplication application;

    int clicksCount;



    public DrawingState(PaintApplication application) {
        this.application = application;
    }

}

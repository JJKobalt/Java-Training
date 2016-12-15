package pl.edu.amu.bawsj.jpaint.State;

import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

/**
 * Created by JanJa on 07.12.2016.
 */
public abstract class DrawingState implements AppState{

   GraphicsContext gc;


    public DrawingState() {

    }
}

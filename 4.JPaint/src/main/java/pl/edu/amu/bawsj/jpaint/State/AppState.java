package pl.edu.amu.bawsj.jpaint.State;

import javafx.scene.canvas.GraphicsContext;

/**
 * Created by JanJa on 07.12.2016.
 */
public interface AppState {

    public void handleMouseButtonPressed(Double x, Double y, GraphicsContext gc);
    public void handleMouseButtonRelesed();
}

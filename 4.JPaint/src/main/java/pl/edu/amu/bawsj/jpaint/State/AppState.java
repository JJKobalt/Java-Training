package pl.edu.amu.bawsj.jpaint.State;

import javafx.scene.canvas.GraphicsContext;
import pl.edu.amu.bawsj.jpaint.PaintApplication;

/**
 * Created by JanJa on 07.12.2016.
 */
public interface AppState {

    public void handleMouseButtonPressed(Double x, Double y, GraphicsContext gc);
    public void handleMouseButtonRelesed(Double x, Double y, GraphicsContext gc);
    public void handleMouseButtonDragged(Double x, Double y, GraphicsContext gc);
    void setApplication(PaintApplication application);
}

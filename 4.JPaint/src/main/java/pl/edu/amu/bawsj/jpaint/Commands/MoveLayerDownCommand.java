package pl.edu.amu.bawsj.jpaint.Commands;

import pl.edu.amu.bawsj.jpaint.PaintApplication;

/**
 * Created by JanJa on 15.12.2016.
 */
public class MoveLayerDownCommand implements Command {
   private int previousLayerPosition;
    private PaintApplication application;


    public MoveLayerDownCommand(int layerPosition,PaintApplication application) {
        this.previousLayerPosition = layerPosition;
        this.application = application;
    }

    @Override
    public void undo() {

        application.document.swap(previousLayerPosition,previousLayerPosition-1);

    }

    @Override
    public void redo() {
        application.document.swap(previousLayerPosition,previousLayerPosition+1);
    }

    @Override
    public String toString() {
        return "Layer moved down";
    }
}

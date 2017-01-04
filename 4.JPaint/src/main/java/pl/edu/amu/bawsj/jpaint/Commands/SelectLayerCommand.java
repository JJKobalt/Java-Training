package pl.edu.amu.bawsj.jpaint.Commands;

import pl.edu.amu.bawsj.jpaint.PaintApplication;

/**
 * Created by JanJa on 15.12.2016.
 */
public class SelectLayerCommand  implements Command {
    int PreviousLayer;
    int nextLayer;
    PaintApplication application;

    public SelectLayerCommand(int previousLayer, int nextLayer,PaintApplication application) {
        PreviousLayer = previousLayer;
        this.nextLayer = nextLayer;
        this.application = application;
    }

    @Override
    public void undo() {
        application.document.setCurrentLayer(PreviousLayer);
    }

    @Override
    public void redo() {
        application.document.setCurrentLayer(nextLayer);
    }

    @Override
    public String toString() {
        return  "changed current Layer ";
    }
}

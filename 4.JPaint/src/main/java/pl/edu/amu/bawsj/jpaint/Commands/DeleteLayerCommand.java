package pl.edu.amu.bawsj.jpaint.Commands;

import pl.edu.amu.bawsj.jpaint.Layer;

/**
 * Created by JanJa on 15.12.2016.
 */
public class DeleteLayerCommand  implements Command{
    Layer deletedLayer;

    public DeleteLayerCommand(Layer deletedLayer) {
        this.deletedLayer = deletedLayer;
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}

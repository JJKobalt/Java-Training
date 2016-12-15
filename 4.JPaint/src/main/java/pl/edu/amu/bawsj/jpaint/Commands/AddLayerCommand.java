package pl.edu.amu.bawsj.jpaint.Commands;

/**
 * Created by JanJa on 15.12.2016.
 */
public class AddLayerCommand implements Command {
int LayerPosition;

    public AddLayerCommand(int layerPosition) {
        LayerPosition = layerPosition;
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}

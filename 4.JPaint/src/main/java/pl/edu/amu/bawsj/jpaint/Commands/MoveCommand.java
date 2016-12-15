package pl.edu.amu.bawsj.jpaint.Commands;

/**
 * Created by JanJa on 15.12.2016.
 */
public class MoveCommand implements Command{

    int LayerPosition;
    int firstPosition;
    int secondPosition;

    public MoveCommand(int layerPosition, int firstPosition, int secondPosition) {
        LayerPosition = layerPosition;
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}

package pl.edu.amu.bawsj.jpaint.Commands;

import pl.edu.amu.bawsj.jpaint.PaintApplication;

/**
 * Created by JanJa on 15.12.2016.
 */
public class MoveLayerUpCommand implements Command {

    public int layerPosition;
       PaintApplication application;

    public MoveLayerUpCommand(int layerPosition, PaintApplication application) {
        this.layerPosition = layerPosition;
        this.application = application;
    }



    @Override
    public void undo() {
        System.out.println("try undo move up");
        application.document.swap(layerPosition,layerPosition+1);
    }

    @Override
    public void redo() {
        application.document.swap(layerPosition,layerPosition-1);
    }
}

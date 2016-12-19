package pl.edu.amu.bawsj.jpaint.Commands;

import pl.edu.amu.bawsj.jpaint.Layer;
import pl.edu.amu.bawsj.jpaint.PaintApplication;

/**
 * Created by JanJa on 15.12.2016.
 */
public class DeleteLayerCommand  implements Command{
    Layer deletedLayer;
    int layerPosition;
    PaintApplication application;

    public DeleteLayerCommand(Layer deletedLayer, int layerPosition, PaintApplication application) {
        System.out.println("Delete Layer sie wywoluje dla Layera:" + deletedLayer.name );
        this.deletedLayer = deletedLayer;
        this.layerPosition = layerPosition;
        this.application = application;
    }

    @Override
    public void undo() {

        application.document.addLayerAt(deletedLayer,layerPosition);
application.document.redrawAt(layerPosition);
    }

    @Override
    public void redo() {
        application.document.delete(layerPosition);
    }


    @Override
    public String toString() {
        return "deleted Layer";
    }
}

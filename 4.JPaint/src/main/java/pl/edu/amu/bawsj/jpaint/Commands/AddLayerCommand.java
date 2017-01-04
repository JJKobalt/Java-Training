package pl.edu.amu.bawsj.jpaint.Commands;

import pl.edu.amu.bawsj.jpaint.Layer;
import pl.edu.amu.bawsj.jpaint.PaintApplication;

/**
 * Created by JanJa on 15.12.2016.
 */
public class AddLayerCommand implements Command {


    PaintApplication application;

    public AddLayerCommand(PaintApplication application ) {

        this.application =application;
    }

    @Override
    public void undo() {
application.document.delete(application.document.layers.size()-1);
    }

    @Override
    public void redo() {
        application.document.addLayer("New Layer");
    }


    @Override
    public String toString() {
        return "Added Layer";
    }
}
